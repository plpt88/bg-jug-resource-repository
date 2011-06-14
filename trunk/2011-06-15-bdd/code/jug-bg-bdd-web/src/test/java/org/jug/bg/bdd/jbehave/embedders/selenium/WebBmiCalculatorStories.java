package org.jug.bg.bdd.jbehave.embedders.selenium;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.jug.bg.bdd.jbehave.selenium.bmi.pages.BmiPageFactory;
import org.jug.bg.bdd.jbehave.selenium.bmi.steps.BmiCalculatorSteps;
import org.jug.bg.bdd.jbehave.selenium.steps.BeforeAndAfterScenarioSteps;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

/**
 * Multiple stories running embedder for the web app integration testing.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class WebBmiCalculatorStories extends JUnitStories {

	// --- Instance Variables --------------------------------------------------

	private Selenium selenium;
	private ConditionRunner conditionRunner;
	private BmiPageFactory pageFactory;
	private SeleniumContext seleniumContext;

	// --- Constructors --------------------------------------------------------

	public WebBmiCalculatorStories() {
		selenium = SeleniumConfiguration.defaultSelenium();
		conditionRunner = SeleniumConfiguration
				.defaultConditionRunner(selenium);
		pageFactory = new BmiPageFactory(selenium, conditionRunner);
		seleniumContext = new SeleniumContext();
	}

	// --- Methods (JBeahave) --------------------------------------------------
	
	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		URL codeLocations = CodeLocations
				.codeLocationFromClass(embeddableClass);
		return new SeleniumConfiguration()
				.useSelenium(selenium)
				.useSeleniumContext(seleniumContext)
				.useStepMonitor(
						new SeleniumStepMonitor(selenium, seleniumContext,
								new SilentStepMonitor()))
				.useStoryLoader(new LoadFromClasspath(embeddableClass))
				.useStoryReporterBuilder(
						new StoryReporterBuilder()
								.withCodeLocation(codeLocations)
								.withDefaultFormats()
								.withFormats(Format.CONSOLE, Format.TXT,
										Format.HTML, Format.XML));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(),
				new BeforeAndAfterScenarioSteps(selenium),
				new BmiCalculatorSteps(pageFactory)).createCandidateSteps();
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(
				CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
				Arrays.asList("**/*.story"), null);
	}
}
