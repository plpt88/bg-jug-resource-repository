package org.jug.bg.bdd.domain.health.impl;

import org.jug.bg.bdd.domain.health.BodyMassIndex;
import org.jug.bg.bdd.domain.health.WeightCategory;
import org.jug.bg.bdd.domain.health.WeightClassifier;

/**
 * Assesses to which weight category belongs a person using its BMI according to
 * the <a href="http://en.wikipedia.org/wiki/Body_mass_index#Categories">
 * classification defined by WHO</a>.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 * 
 * @see WeightCategory
 */
public class WeightClassifierImpl implements WeightClassifier {

	/**
	 * Assesses to which weight category belongs a person using its BMI
	 * according to the <a
	 * href="http://en.wikipedia.org/wiki/Body_mass_index#Categories">
	 * classification defined by WHO</a>.
	 * 
	 * @param bmi
	 *            Body mass index.
	 * 
	 * @return Returns weight category.
	 */
	public WeightCategory assess(BodyMassIndex bmi) {
		double bmiValue = bmi.value();

		if (bmiValue < 16.0) {
			return WeightCategory.SEVERELY_UNDERWEIGHT;
		}//
		else if (16.0 <= bmiValue && bmiValue < 18.5) {
			return WeightCategory.UNDERWEIGHT;
		}//
		else if (18.5 <= bmiValue && bmiValue < 25) {
			return WeightCategory.NORMAL;
		}//
		else if (25 <= bmiValue && bmiValue < 30) {
			return WeightCategory.OVERWEIGHT;
		}//
		else if (30 <= bmiValue && bmiValue < 35) {
			return WeightCategory.OBESE_CLASS_1;
		}//
		else if (35 <= bmiValue && bmiValue < 40) {
			return WeightCategory.OBESE_CLASS_2;
		}
		// else if 40 <= bmiValue
		return WeightCategory.OBESE_CLASS_3;
	}
}
