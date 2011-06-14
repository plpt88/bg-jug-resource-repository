package org.jug.bg.bdd.web.health;

/**
 * Constants used by the web-app for unifying the strings in the app.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class WebConstants {

	public static final String PARAM_MASS = "mass";
	public static final String PARAM_HEIGHT = "height";
	public static final String PARAM_BMI = "bmi";
	public static final String PARAM_HEALTH_RECORD = "healthRecord";
	public static final String PARAM_WEIGHT_CATEGORY = "weightCategory";
	public static final String PARAM_PROBLEM = "exception";
	public static final String PARAM_HAS_PROBLEM = "hasProblem";

	public static final String PAGE_BMI_RESULT = "/bmi-result";
	public static final String PAGE_BMI_CALC = "/main";
	public static final String PAGE_BMI_SERVLET = "/bmi";

	public static final String ID_PAGE_HEADING = "bmiPageHeadingId";
	public static final String ID_HEIGHT = "heightId";
	public static final String ID_MASS = "massId";
	public static final String ID_BMI_VALUE = "bmiValueId";
	public static final String ID_WEIGHT_CATEGORY = "weightCategoryId";
	public static final String ID_CALCULATE_BTTN = "calculateBttnId";
	public static final String ID_ERR_MSG = "errMsgId";

	public static final String ERR_MSG = "Problem during BMI calculation.";
	public static final String HEADING_MAIN_PAGE = "BMI Calculator Application";
	public static final String HEADING_RESULTS_PAGE = "BMI Result Analysis";
}
