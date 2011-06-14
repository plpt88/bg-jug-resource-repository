package org.jug.bg.bdd.domain.health.impl;

import org.jug.bg.bdd.domain.health.HealthRecord;

/**
 * Personal health record which uses International System of Units for
 * measurement the body characteristics, e.g. height, mass, etc.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class ISUHealthRecord implements HealthRecord {

	// --- Instance Variables --------------------------------------------------

	/** Height of the patient */
	private float height;

	/** Patient's mass */
	private float mass;

	// --- Constructors --------------------------------------------------------

	public ISUHealthRecord() {
	}

	public ISUHealthRecord(float height, float weight) {
		this.height = height;
		this.mass = weight;
	}

	// --- Getters and Setters -------------------------------------------------

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return mass;
	}

	public void setWeight(float weight) {
		this.mass = weight;
	}
}
