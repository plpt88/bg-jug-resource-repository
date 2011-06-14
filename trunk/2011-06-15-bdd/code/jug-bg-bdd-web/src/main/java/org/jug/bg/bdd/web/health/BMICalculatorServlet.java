package org.jug.bg.bdd.web.health;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jug.bg.bdd.domain.health.BMICalculator;
import org.jug.bg.bdd.domain.health.BodyMassIndex;
import org.jug.bg.bdd.domain.health.HealthRecord;
import org.jug.bg.bdd.domain.health.WeightClassifier;
import org.jug.bg.bdd.domain.health.impl.ISUHealthRecord;
import org.jug.bg.bdd.domain.health.impl.MetricBMICalculator;
import org.jug.bg.bdd.domain.health.impl.WeightClassifierImpl;

/**
 * Simple servlet which handles the web based version of the BMI calculator.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class BMICalculatorServlet extends HttpServlet {

	// --- Constants -----------------------------------------------------------
	
	// bloody eclipse
	private static final long serialVersionUID = 4923255477887606626L;

	// --- Instance Variables --------------------------------------------------
	
	private BMICalculator bmiCalculator;
	private WeightClassifier weightClasifier;

	// --- Constructors --------------------------------------------------------
	
	public BMICalculatorServlet() {
		bmiCalculator = new MetricBMICalculator();
		weightClasifier = new WeightClassifierImpl();
	}

	// --- Methods (HttpServlet) -----------------------------------------------
	
	@Override
	public void doGet(HttpServletRequest aRequest, HttpServletResponse aResponse)
			throws ServletException, IOException {
		doPost(aRequest, aResponse);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String massStr = request.getParameter(WebConstants.PARAM_MASS);
		String heightStr = request.getParameter(WebConstants.PARAM_HEIGHT);
		HealthRecord healthRecord = null;
		BodyMassIndex bmi = null;
		if (StringUtils.isEmpty(massStr) || StringUtils.isEmpty(heightStr)) {
			sendErrorRedirect(request, response, WebConstants.PAGE_BMI_CALC,
					null);
			return;
		}
		try {
			healthRecord = createHealthRecord(massStr, heightStr);
			bmi = bmiCalculator.calculate(healthRecord);
		} catch (Exception e) {
			sendErrorRedirect(request, response, WebConstants.PAGE_BMI_CALC, e);
			return;
		}

		request.setAttribute(WebConstants.PARAM_HEALTH_RECORD, healthRecord);
		request.setAttribute(WebConstants.PARAM_BMI, bmi);
		request.setAttribute(WebConstants.PARAM_WEIGHT_CATEGORY,
				weightClasifier.assess(bmi));

		getServletConfig().getServletContext()
				.getRequestDispatcher(WebConstants.PAGE_BMI_RESULT)
				.forward(request, response);
	}

	// --- Methods (Auxiliary) -------------------------------------------------
	
	private HealthRecord createHealthRecord(String massStr, String heightStr) {
		float mass = Float.parseFloat(massStr);
		float height = Float.parseFloat(heightStr);
		ISUHealthRecord healthRecord = new ISUHealthRecord();
		healthRecord.setWeight(mass);
		healthRecord.setHeight(height);
		return healthRecord;
	}

	private void sendErrorRedirect(HttpServletRequest request,
			HttpServletResponse response, String errorPageURL, Throwable e)
			throws ServletException, IOException {
		request.setAttribute(WebConstants.PARAM_HAS_PROBLEM,
				Boolean.TRUE.toString());
		request.setAttribute(WebConstants.PARAM_PROBLEM, e);
		getServletConfig().getServletContext()
				.getRequestDispatcher(errorPageURL).forward(request, response);
	}
}
