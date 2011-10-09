package org.jug.bg.bdd.jbehave.selenium.steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;

import com.thoughtworks.selenium.Selenium;

/**
 * Steps mappings used to start/stop the selenium before and after scenario
 * execution respectively.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class BeforeAndAfterScenarioSteps {

	// --- Instance Variables --------------------------------------------------
	
	private Selenium selenium;

	// --- Constructors --------------------------------------------------------
	
	public BeforeAndAfterScenarioSteps(Selenium selenium) {
		this.selenium = selenium;
	}

	// --- Methods (JBehave) ---------------------------------------------------
	
	@BeforeScenario
	public void startSelenium() {
		if (selenium != null) {
			selenium.start();
		}
	}

	@AfterScenario
	public void stopSelenium() {
		if (selenium != null) {
			selenium.stop();
		}
	}
}
