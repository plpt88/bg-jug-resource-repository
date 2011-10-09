package org.jug.bg.bdd.jbehave.selenium.bmi.pages;

import org.jug.bg.bdd.jbehave.selenium.pages.AbstractBmiPage;
import org.jug.bg.bdd.web.health.WebConstants;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

/**
 * A factory for <a
 * href="http://code.google.com/p/selenium/wiki/PageObjects">page object</a>s
 * related to the pages of the use case.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class BmiPageFactory {

	private final Selenium selenium;
	private final ConditionRunner conditionRunner;

	public BmiPageFactory(Selenium selenium, ConditionRunner conditionRunner) {
		this.selenium = selenium;
		this.conditionRunner = conditionRunner;
	}

	public Class<? extends AbstractBmiPage> getCurrentPageType() {
		String pageHeading = getCurrentPageHeading();
		if (WebConstants.HEADING_MAIN_PAGE.equalsIgnoreCase(pageHeading)) {
			return BmiMainPage.class;
		}//
		else if (WebConstants.HEADING_RESULTS_PAGE
				.equalsIgnoreCase(pageHeading)) {
			return BmiResutlsPage.class;
		}
		return null;
	}

	public BmiMainPage createBmiMainPage() {
		return new BmiMainPage(selenium, conditionRunner);
	}

	public BmiResutlsPage createBmiResultsPage() {
		return new BmiResutlsPage(selenium, conditionRunner);
	}

	// --- Methods (Auxiliary) -------------------------------------------------

	private String getCurrentPageHeading() {
		return selenium.getText("xpath=//*[@id='"
				+ WebConstants.ID_PAGE_HEADING + "']");
	}
}
