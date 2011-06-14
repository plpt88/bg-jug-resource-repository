package org.jug.bg.bdd.jbehave.selenium.pages;

import org.jbehave.web.selenium.SeleniumPage;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

/**
 * Abstract <a href="http://code.google.com/p/selenium/wiki/PageObjects">page
 * object</a> class which acts holds the common logic of the page objects for
 * BMI Calculator web app.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class AbstractBmiPage extends SeleniumPage {

	// --- Constructors --------------------------------------------------------

	public AbstractBmiPage(Selenium selenium, ConditionRunner conditionRunner) {
		super(selenium, conditionRunner);
	}

	// --- Methods (Page) ------------------------------------------------------

	protected String getElementValueById(String htmlElemId) {
		return getText("xpath=//*[@id='" + htmlElemId + "']");
	}
}
