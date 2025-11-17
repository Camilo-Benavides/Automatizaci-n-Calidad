package co.edu.udea.certificacion.taller.stepdefinitions;

import co.edu.udea.certificacion.taller.interactions.saucedemo.ClickKey;
import co.edu.udea.certificacion.taller.questions.ValidationSaucedemo;
import co.edu.udea.certificacion.taller.tasks.Saucedemo.LoginSaucedemo;
import co.edu.udea.certificacion.taller.tasks.OpenUrl;
import co.edu.udea.certificacion.taller.tasks.Saucedemo.RemoveElementFromCart;
import co.edu.udea.certificacion.taller.tasks.Saucedemo.SelectElement;
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
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.ADD_ELEMENT_1;
import java.util.ArrayList;
import java.util.Arrays;
import co.edu.udea.certificacion.taller.interactions.saucedemo.ClickCheckoutButton;
import co.edu.udea.certificacion.taller.interactions.saucedemo.ClickContinueButton;

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
        // Write code here that turns the phrase above into concrete actions
        user.attemptsTo(SelectElement.elements(new ArrayList<>(Arrays.asList(ADD_ELEMENT_1))));
        user.attemptsTo(ClickKey.moveToShoppingCart());
    }
    @Then("the element is added")
    public void theElementIsAdded() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("I have products in my shopping cart")
    public void iAlreadyHaveElementsInTheShoppingCart() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(ValidationSaucedemo.validateShoppingCart(), Matchers.containsString("1")));
    }
    @When("I remove that item from the shopping cart")
    public void iSelectRemove() {
        user.attemptsTo(RemoveElementFromCart.remove());
    }
    @Then("the element is removed")
    public void theElementIsRemoved() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(ValidationSaucedemo.validateShoppingCart(), Matchers.containsString("0")));
    }

    @Given("I have finished choosing the products")
    public void iHaveFinishedChoosingTheProducts() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("I click on the shopping cart")
    public void iClickOnTheShoppingCart() {
        user.attemptsTo(ClickKey.moveToShoppingCart());
    }
    @Then("It shows how many products I have in my cart")
    public void itShowsHowManyProductsIHaveInMyCart() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(ValidationSaucedemo.validateShoppingCart(), Matchers.containsString("1")));
    }

    @When("I click on the checkout button")
    public void iClickOnTheCheckoutButton() {
        user.attemptsTo(ClickCheckoutButton.click());
    }

    @When("I click on the continue button")
    public void iClickOnTheContinueButton() {
        user.attemptsTo(ClickContinueButton.click());
    }

    @When("I fill the personal information")
    public void iFillThePersonalInformation() {
        user.attemptsTo(FillCheckoutForm.withData("John", "Doe", "12345"));
    }

    @When("I fill only the first name in the personal information")
    public void iFillOnlyFirstName() {
        user.attemptsTo(FillCheckoutForm.withData("John", "", ""));
    }

    @When("I remove that item from the shopping cart")
    public void iRemoveThatItemFromCart() {
        // Implementar acción para eliminar el producto del carrito
    }

    @Then("I can see the overview of my order")
    public void iCanSeeTheOverviewOfMyOrder() {
        // Implementar validación de la vista de resumen de la orden
    }

    @Then("I should see an error message indicating missing information")
    public void iShouldSeeErrorMessageMissingInfo() {
        // Implementar validación de mensaje de error por información faltante
    }

    @Then("I should see a message indicating the cart is empty or cannot proceed")
    public void iShouldSeeCartEmptyOrCannotProceed() {
        // Implementar validación de mensaje de carrito vacío o imposibilidad de continuar
    }
}
