package org.jug.bg.bdd.jbehave.selenium.bmi.pages;

import org.jug.bg.bdd.jbehave.selenium.pages.AbstractBmiPage;
import org.jug.bg.bdd.web.health.WebConstants;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

/**
 * <a href="http://code.google.com/p/selenium/wiki/PageObjects">Page object</a>
 * class which acts as facade to the functionality provided by the result page
 * of the use case.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class BmiResutlsPage extends AbstractBmiPage {

	private Selenium selenium;

	public BmiResutlsPage(Selenium selenium, ConditionRunner conditionRunner) {
		super(selenium, conditionRunner);
		this.selenium = selenium;
	}

	public String getUrl() {
		return selenium.getLocation();
	}

	public String getBmiValue() {
		return getElementValueById(WebConstants.ID_BMI_VALUE);
	}

	public String getHeading() {
		return getElementValueById(WebConstants.ID_PAGE_HEADING);
	}

	public String getWeightCategory() {
		return getElementValueById(WebConstants.ID_WEIGHT_CATEGORY);
	}
}
