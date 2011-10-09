package org.jug.bg.bdd.domain.health.impl;

import org.jug.bg.bdd.domain.health.BMICalculator;
import org.jug.bg.bdd.domain.health.BodyMassIndex;
import org.jug.bg.bdd.domain.health.HealthRecord;

/**
 * Calculator of a metric <a
 * href="http://en.wikipedia.org/wiki/Body_mass_index">BMI</a>.
 * 
 * <p>
 * The formula used is: *
 * 
 * <pre>
 *          mass (kg)
 * BMI = --------------
 *       (height (m))^2
 * </pre>
 * 
 * where:
 * <ul>
 * <li>BMI - Body mass index.</li>
 * <li>mass (kg) - Person's mass in kg.</li>
 * <li>height (m) - Person's height in m.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class MetricBMICalculator implements BMICalculator {

	/**
	 * Calculates a metric BMI.
	 * 
	 * @param healthRecord
	 *            Person's health record from which are taken the mass and
	 *            height needed for the calculation.
	 * 
	 * @return Returns the corresponding body mass index.
	 */
	public BodyMassIndex calculate(HealthRecord healthRecord) {
		float weight = healthRecord.getWeight();
		float height = healthRecord.getHeight();

		// Calculating Body Mass Index
		double bmiValue = weight / (height * height);

		return new BodyMassIndexImpl(bmiValue);
	}
}
