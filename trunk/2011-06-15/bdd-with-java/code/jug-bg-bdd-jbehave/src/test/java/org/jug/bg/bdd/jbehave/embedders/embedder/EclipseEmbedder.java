package org.jug.bg.bdd.jbehave.embedders.embedder;

import java.util.Arrays;

import org.jbehave.core.embedder.Embedder;
import org.jug.bg.bdd.jbehave.launcher.EclipseStoryLauncher;

/**
 * Example of an embedder which extends {@link Embedder} class. This class is
 * used by the {@link EclipseStoryLauncher} to run stories selected in eclipse.
 * 
 * <p>
 * NOTE: The embedder's configuration is prepared by the
 * {@link EclipseEmbedderFactory}.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class EclipseEmbedder extends Embedder {

	// --- Constants -----------------------------------------------------------

	private static final String STORY_FILE_EXTENSION = ".story";

	// --- Constructors --------------------------------------------------------

	public EclipseEmbedder() {
	}

	// --- Methods -------------------------------------------------------------

	/**
	 * Used to launch a single story.
	 * 
	 * @param story
	 */
	public void runStory(String story) {
		if (story != null && story.endsWith(STORY_FILE_EXTENSION)) {
			this.runStoriesAsPaths(Arrays.asList(story));
			generateReportsView();
		} else {
			throw new RuntimeException("Problem locating .story file:" + story);
		}
	}
}
