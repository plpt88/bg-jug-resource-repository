package org.jug.bg.bdd.jbehave.embedders.embedder;

import java.util.List;
import java.util.Properties;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.StoryLoader;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jug.bg.bdd.jbehave.steps.bmi.calculator.MetricBMICalculatorSteps;
import org.jug.bg.bdd.jbehave.steps.bmi.calculator.WeightClassifierSteps;

/**
 * Creates and configures an instance of {@link EclipseEmbedder}.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class EclipseEmbedderFactory {

	// --- Class Variables -----------------------------------------------------

	private static EclipseEmbedderFactory instance;

	// --- Constructors --------------------------------------------------------

	private EclipseEmbedderFactory() {
	}

	// --- Methods (Singleton)--------------------------------------------------

	public static EclipseEmbedderFactory instance() {
		if (instance == null) {
			instance = new EclipseEmbedderFactory();
		}
		return instance;
	}

	// --- Methods (Factory) ---------------------------------------------------

	public EclipseEmbedder createEclipseEmbedder() {
		EclipseEmbedder eclipseEmbedder = new EclipseEmbedder();

		Configuration configuration = loadConfiguration(eclipseEmbedder);
		List<CandidateSteps> candidateSteps = new InstanceStepsFactory(
				configuration, new MetricBMICalculatorSteps(),
				new WeightClassifierSteps()).createCandidateSteps();

		eclipseEmbedder.useConfiguration(configuration);
		eclipseEmbedder.useCandidateSteps(candidateSteps);
		return eclipseEmbedder;
	}

	// --- Methods (Auxiliary) -------------------------------------------------

	private Configuration loadConfiguration(Embedder embedder) {
		Configuration configuration = new MostUsefulConfiguration();
		configuration = configuration.useStoryLoader(loadStoryLoader(embedder));
		configuration = configuration
				.useStoryReporterBuilder(loadStoryReporterBuilder());
		configuration = configuration.useStepMonitor(new SilentStepMonitor());
		configuration = configuration.useStoryControls((new StoryControls())
				.doSkipBeforeAndAfterScenarioStepsIfGivenStory(true));
		return configuration;
	}

	// where to find the stories
	private StoryLoader loadStoryLoader(Embedder embedder) {
		return new LoadFromRelativeFile(
				CodeLocations.codeLocationFromClass(embedder.getClass()));
	}

	private StoryReporterBuilder loadStoryReporterBuilder() {
		// CONSOLE and TXT reporting
		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml", "true");
		viewResources.setProperty("views", "ftl/jbehave-views.ftl");
		viewResources.setProperty("maps", "ftl/jbehave-maps.ftl");
		viewResources.setProperty("navigator", "ftl/jbehave-navigator.ftl");
		viewResources.setProperty("reports",
				"ftl/jbehave-reports-with-totals.ftl");
		viewResources.setProperty("decorated",
				"ftl/jbehave-report-decorated.ftl");
		viewResources.setProperty("nonDecorated",
				"ftl/jbehave-report-non-decorated.ftl");
		viewResources.setProperty("decorateNonHtml", "true");
		viewResources.setProperty("defaultFormats", "stats");
		viewResources.setProperty("viewDirectory", "view");
		StoryReporterBuilder storyReporterBuilder = new StoryReporterBuilder();
		storyReporterBuilder.withDefaultFormats();
		storyReporterBuilder.withFormats(Format.CONSOLE, Format.TXT,
				Format.HTML);
		storyReporterBuilder.withViewResources(viewResources);
		return storyReporterBuilder;
	}
}
