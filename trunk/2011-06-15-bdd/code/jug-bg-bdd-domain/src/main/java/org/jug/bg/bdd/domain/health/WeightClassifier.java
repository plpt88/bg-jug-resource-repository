package org.jug.bg.bdd.domain.health;

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
 */
public interface WeightClassifier {

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
	WeightCategory assess(BodyMassIndex bmi);
}
