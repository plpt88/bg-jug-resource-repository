package org.jug.bg.bdd.domain.health;

/**
 * Body Mass Index Calculator.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public interface BMICalculator {

	/**
	 * Calculates a body mass index.
	 * 
	 * @param healthRecord
	 *            Person's health record from which are taken the mass and
	 *            height needed for the calculation.
	 * 
	 * @return Returns the corresponding body mass index.
	 */
	BodyMassIndex calculate(HealthRecord healthRecord);
}
