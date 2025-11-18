package co.edu.udea.certificacion.taller.stepdefinitions;

import co.edu.udea.certificacion.taller.interactions.saucedemo.ClickKey;
import co.edu.udea.certificacion.taller.questions.ValidationSaucedemo;
import co.edu.udea.certificacion.taller.tasks.Saucedemo.LoginSaucedemo;
import co.edu.udea.certificacion.taller.tasks.OpenUrl;
import co.edu.udea.certificacion.taller.tasks.Saucedemo.RemoveElement;
import co.edu.udea.certificacion.taller.tasks.Saucedemo.SelectElement;
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

import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.REMOVE_ELEMENT_1;
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.ADD_ELEMENT_1;
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.ADD_ELEMENT_2;
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.ADD_ELEMENT_3;
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.SHOPPING_CART;

import java.util.ArrayList;
import java.util.Arrays;

public class SaucedemoStepDefinition {
    public final Actor user = Actor.named("User");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver driver;

    @Before
    public void config() {
        user.can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

    @Given("I am in the saucedemo page")
    public void iAmInTheGooglePage() {
        user.attemptsTo(OpenUrl.page("saucedemo"));
    }

    @When("I fill the login")
    public void iTypeSaucedemoOnGoogleSearchBar() {
        user.attemptsTo(LoginSaucedemo.login("standard_user", "secret_sauce"));
    }

    @Then("I can access to the site")
    public void iCanSeeTheSaucedemoSOfficialPage() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("I am in main menu")
    public void iAmInMainMenu() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I select one product")
    public void iSelectOneProduct() {
        user.attemptsTo(SelectElement.elements(new ArrayList<>(Arrays.asList(ADD_ELEMENT_1, ADD_ELEMENT_2, ADD_ELEMENT_3))));
    }

    @Then("the element is added")
    public void theElementIsAdded() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(
            ValidationSaucedemo.validateShoppingCart(), 
            Matchers.containsString("3")
        ));
    }

    @Given("I already have elements in the shopping cart")
    public void iAlreadyHaveElementsInTheShoppingCart() {
        user.attemptsTo(SelectElement.elements(Arrays.asList(ADD_ELEMENT_1)));
    }

    @Given("I add some elements to the shopping cart")
    public void iAddSomeElementsToTheShoppingCart() {
        user.attemptsTo(SelectElement.elements(Arrays.asList(ADD_ELEMENT_1, ADD_ELEMENT_2)));
    }
    @When("I remove one of them")
    public void iSelectRemove() {
        user.attemptsTo(RemoveElement.remove(Arrays.asList(REMOVE_ELEMENT_1)));
    }

    @Then("the element is removed")
    public void theElementIsRemoved() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(ValidationSaucedemo.validateShoppingCart(), Matchers.containsString("")));
    }

    @Given("I have finished choosing the products")
    public void iHaveFinishedChoosingTheProducts() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click on the shopping cart")
    public void iClickOnTheShoppingCart() {
        user.attemptsTo(ClickKey.on(SHOPPING_CART));
    }

    @Then("It shows how many products I have in my cart")
    public void itShowsHowManyProductsIHaveInMyCart() {
        GivenWhenThen.then(user).should(
                GivenWhenThen.seeThat(ValidationSaucedemo.validateShoppingCart(), Matchers.containsString("1")));
    }

}
