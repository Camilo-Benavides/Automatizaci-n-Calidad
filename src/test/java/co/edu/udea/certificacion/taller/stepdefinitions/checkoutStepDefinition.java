package co.edu.udea.certificacion.taller.stepdefinitions;

import co.edu.udea.certificacion.taller.interactions.saucedemo.ClickKey;
import co.edu.udea.certificacion.taller.questions.ContainsText;
import co.edu.udea.certificacion.taller.questions.ValidationSaucedemo;
import co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage;
import co.edu.udea.certificacion.taller.tasks.Saucedemo.FillCheckoutForm;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

public class checkoutStepDefinition {
    public final Actor user = Actor.named("User");


    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver driver;


    @Before
    public void config(){
        user.can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

    @When("I select the checkout module")
    public void iClickOnTheCheckoutButton() {
        user.attemptsTo(ClickKey.on(SaucedemoPage.CHECKOUT_BUTTON));
    }

    @When("I proceed to the checkout module")
    public void iClickOnTheContinueButton() {
        user.attemptsTo(ClickKey.on(SaucedemoPage.CONTINUE_BUTTON));
    }
 
    @When("I fill the personal information")
    public void iFillThePersonalInformation() {
        user.attemptsTo(FillCheckoutForm.withData("Pepito", "Perez", "2345"));
    }

    @When("I fill only the first name in the personal information")
    public void iFillOnlyFirstName() {
        user.attemptsTo(FillCheckoutForm.withData("Pepito", "", ""));
    }

    @When("I remove that item from the shopping cart")
    public void iRemoveThatItemFromCart() {
        user.attemptsTo(ClickKey.on(SaucedemoPage.REMOVE_BACKPACK_FROM_CART));
    }

    @Then("I can see the overview of my order")
    public void iCanSeeTheOverviewOfMyOrder() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(ContainsText.in(SaucedemoPage.CHECKOUT_OVERVIEW, "overview"), Matchers.is(true)));
    }

    @Then("I should see an error message indicating missing information")
    public void iShouldSeeErrorMessageMissingInfo() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(ContainsText.in(SaucedemoPage.ERROR_MESSAGE, "error"), Matchers.is(true)));
    }

    @Then("I should see a message indicating the cart is empty or cannot proceed")
    public void iShouldSeeCartEmptyOrCannotProceed() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(ContainsText.in(SaucedemoPage.CHECKOUT_OVERVIEW, "overview"), Matchers.is(false)));
    }
}
