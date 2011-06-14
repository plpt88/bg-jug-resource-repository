package org.jug.bg.bdd.domain.health;

/**
 * Weight categories defined by the World Health Organization (WHO).
 *  
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public enum WeightCategory {

	SEVERELY_UNDERWEIGHT("Severely Underweight"),

	UNDERWEIGHT("Underweight"),

	NORMAL("Normal"),

	OVERWEIGHT("Overweight"),

	OBESE_CLASS_1("Obese Class I"),

	OBESE_CLASS_2("Obese Class II"),

	OBESE_CLASS_3("Obese Class III");

	private String strValue;

	private WeightCategory(String strValue) {
		this.strValue = strValue;
	}

	public String getStringValue() {
		return strValue;
	}
}
