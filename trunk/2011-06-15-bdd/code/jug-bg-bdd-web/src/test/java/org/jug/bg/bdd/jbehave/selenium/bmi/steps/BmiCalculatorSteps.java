package org.jug.bg.bdd.jbehave.selenium.bmi.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import junit.framework.Assert;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jug.bg.bdd.jbehave.selenium.bmi.pages.BmiMainPage;
import org.jug.bg.bdd.jbehave.selenium.bmi.pages.BmiPageFactory;
import org.jug.bg.bdd.jbehave.selenium.bmi.pages.BmiResutlsPage;
import org.jug.bg.bdd.jbehave.selenium.pages.AbstractBmiPage;

/**
 * Steps mappings used by the steps in the <code>*.story</code> files for the
 * Web BMI Calculator testing.
 * 
 * <p>
 * 2011, Bulgarian Java Users Group<br/>
 * Some rights reserved. This work is licensed under a <a rel="license"
 * http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
 * </p>
 * 
 * @author Nikolay Vasilev
 */
public class BmiCalculatorSteps {

	// --- Instance Variables --------------------------------------------------

	private BmiPageFactory pageFactory;
	private BmiMainPage mainPage;
	private BmiResutlsPage resultPage;

	// --- Constructors --------------------------------------------------------

	public BmiCalculatorSteps(BmiPageFactory pageFactory) {
		this.pageFactory = pageFactory;
		mainPage = pageFactory.createBmiMainPage();
		resultPage = pageFactory.createBmiResultsPage();
	}

	// --- Methods (JBehave) ---------------------------------------------------

	@Given("an user is on the BMI Calculator main page")
	public void userOpensMainPage() {
		mainPage.open();
	}

	@Then("the BMI Calculator main page should be displayed")
	@Alias("the user is brought back to BMI Calculator main page")
	public void verifyThatMainPageIsOpened() {
		verifyThatCurrentPageTypeIs(BmiMainPage.class);
	}

	@When("the user populates the form with values for mass - <mass> kg and height - <height> m")
	public void userPopulatesMassAndHeight(@Named("mass") float mass,
			@Named("height") float height) {
		mainPage.populateMassValue(mass);
		mainPage.populateHeightValue(height);
	}

	@When("the user populates the form only with value for mass $mass kg")
	public void userPopulatesMass(@Named("mass") float mass) {
		mainPage.populateMassValue(mass);
	}

	@When("the user populates the form only with value for height $height m")
	public void userPopulatesHeight(@Named("height") float height) {
		mainPage.populateHeightValue(height);
	}

	@When("the user clicks on the Calculate button")
	public void userClicksCalculateButton() {
		mainPage.clickCalculateButton();
	}

	@Then("the user is brought to BMI Result Analysis page")
	public void verifyPageIsOpened() {
		verifyThatCurrentPageTypeIs(BmiResutlsPage.class);
	}

	@Then("user's body mass index is <bmi>")
	public void validateBoddyMassIndex(@Named("bmi") String expectedBmiValue) {
		String actualBmi = resultPage.getBmiValue();
		assertThat(actualBmi, is(equalTo(expectedBmiValue)));
	}

	@Then("user's weight category is <weight-category>")
	public void validateWeightCategory(
			@Named("weight-category") String expectedWeightCategory) {
		String actualWeightCategory = resultPage.getWeightCategory();
		assertThat(actualWeightCategory, is(equalTo(expectedWeightCategory)));
	}

	@Then("an error message is displayed: $errMsg")
	public void thenAnErrorMsgIsDisplayed(@Named("errMsg") String expectedErrMsg) {
		String actualErrMsg = mainPage.getErrorMessage();
		assertThat(actualErrMsg, is(equalTo(expectedErrMsg)));
	}

	// --- Methods (Auxiliary) -------------------------------------------------

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void verifyThatCurrentPageTypeIs(
			Class<? extends AbstractBmiPage> expectedPageType) {

		Class currentPageType = pageFactory.getCurrentPageType();

		// hamcrest integration
		assertThat(currentPageType, is(notNullValue()));

		// JUnit integration
		Assert.assertEquals(currentPageType, expectedPageType);
	}
}
