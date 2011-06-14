package org.jug.bg.bdd.jbehave.steps.bmi.calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jug.bg.bdd.domain.health.BodyMassIndex;
import org.jug.bg.bdd.domain.health.WeightCategory;
import org.jug.bg.bdd.domain.health.WeightClassifier;
import org.jug.bg.bdd.domain.health.impl.BodyMassIndexImpl;
import org.jug.bg.bdd.domain.health.impl.WeightClassifierImpl;

/**
 * Steps mappings used by the steps in the <code>*.story</code> files for the
 * Weight Classifier logic.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class WeightClassifierSteps {

	// --- Instance Variables --------------------------------------------------
	
	private WeightClassifier weightClassifier;

	// --- Constructors --------------------------------------------------------
	
	public WeightClassifierSteps() {
	}

	// --- Methods (JBehave) ---------------------------------------------------
	
	@Given("Weight Classifier is started")
	public void initializeWeightClassifier() {
		weightClassifier = new WeightClassifierImpl();
	}

	// @Then("And for the calculated bmi $bmi, the weight classifier shows: $weight-category")
	@Then("for the calculated bmi value <bmi>, the weight classifier shows: <weight-category>")
	public void validateWeightCategoryForGivenBmi_PARAMETRIZED(
			@Named("bmi") double bmiValue,
			@Named("weight-category") String expectedWeightCategory) {
		validateWeightCategoryForGivenBmi(bmiValue, expectedWeightCategory);
	}

	@Then("for the calculated bmi value $bmi, the weight classifier shows: $weightCategory")
	public void validateWeightCategoryForGivenBmi_NOT_PARAMETRIZED(
			@Named("bmi") double bmiValue,
			@Named("weightCategory") String expectedWeightCategory) {
		validateWeightCategoryForGivenBmi(bmiValue, expectedWeightCategory);
	}

	// --- Methods (Auxiliary) -------------------------------------------------
	
	private void validateWeightCategoryForGivenBmi(
			@Named("bmi") double bmiValue,
			@Named("weight-category") String expectedWeightCategory) {
		BodyMassIndex bmi = new BodyMassIndexImpl(bmiValue);
		WeightCategory actualWeightCategory = weightClassifier.assess(bmi);
		assertThat(actualWeightCategory.getStringValue(),
				is(equalTo(expectedWeightCategory)));
	}

}
