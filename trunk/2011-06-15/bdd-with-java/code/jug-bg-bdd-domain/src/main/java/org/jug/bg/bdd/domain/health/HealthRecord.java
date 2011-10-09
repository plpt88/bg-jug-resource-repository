package org.jug.bg.bdd.domain.health;

/**
 * Interface declaring bean wrapping the height and weight of a person.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public interface HealthRecord {

	float getHeight();

	void setHeight(float height);

	float getWeight();

	void setWeight(float weight);
}