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

public class SaucedemoStepDefinition {
    public final Actor user = Actor.named("User");

//    private final EnvironmentVariables env =

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver driver;


    @Before
    public void config(){
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
    }

    @Given("I am in main menu")
    public void iAmInMainMenu() {
    }
    @When("I select one product")
    public void iSelectOneProduct() {
        // Write code here that turns the phrase above into concrete actions
        user.attemptsTo(SelectElement.elements());
    }
    @Then("the element is added")
    public void theElementIsAdded() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @Given("I already have elements in the shopping cart")
    public void iAlreadyHaveElementsInTheShoppingCart() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @When("I select remove")
    public void iSelectRemove() {
        user.attemptsTo(RemoveElement.remove());
    }
    @Then("the element is removed")
    public void theElementIsRemoved() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @Given("I have finished choosing the products")
    public void iHaveFinishedChoosingTheProducts() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @When("I click on the shopping cart")
    public void iClickOnTheShoppingCart() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        user.attemptsTo(ClickKey.move_to_shopping_cart());
    }
    @Then("It shows how many products I have in my cart")
    public void itShowsHowManyProductsIHaveInMyCart() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(ValidationSaucedemo.validateShoppingCart(), Matchers.containsString("1")));
    }

}
