package org.jug.bg.bdd.domain.health.impl;

import org.jug.bg.bdd.domain.health.BodyMassIndex;

/**
 * Bean which holds a BMI value.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class BodyMassIndexImpl implements BodyMassIndex {

	private double value;

	public BodyMassIndexImpl(double value) {
		this.value = value;
	}

	public double value() {
		return value;
	}
}
