package org.jug.bg.bdd.jbehave.selenium.bmi.pages;

import org.jug.bg.bdd.jbehave.selenium.pages.AbstractBmiPage;
import org.jug.bg.bdd.web.health.WebConstants;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

/**
 * <a href="http://code.google.com/p/selenium/wiki/PageObjects">Page object</a>
 * class which acts as facade to the functionality provided by the main page of
 * the use case.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class BmiMainPage extends AbstractBmiPage {

	// --- Constructors --------------------------------------------------------

	public BmiMainPage(Selenium selenium, ConditionRunner conditionRunner) {
		super(selenium, conditionRunner);
	}

	// --- Methods (Page Functionality Related) --------------------------------

	public void open() {
		open("/web/bmi");
	}

	public String getHeading() {
		return getElementValueById(WebConstants.ID_PAGE_HEADING);
	}

	public void clickCalculateButton() {
		clickButtonWithName(WebConstants.ID_CALCULATE_BTTN);
	}

	public void populateMassValue(float weight) {
		populateDoubleField(WebConstants.ID_MASS, weight);
	}

	public void populateHeightValue(float height) {
		populateDoubleField(WebConstants.ID_HEIGHT, height);
	}

	public String getErrorMessage() {
		return getElementValueById(WebConstants.ID_ERR_MSG);
	}

	// --- Methods (Auxiliary) -------------------------------------------------

	private void populateDoubleField(String fieldId, double value) {
		type("xpath=//*[@id='" + fieldId + "']", Double.toString(value));
	}

	private void clickButtonWithName(String idCalculateBttn) {
		click("xpath=//*[@id='" + idCalculateBttn + "']");
	}
}