package co.edu.udea.certificacion.taller.tasks.Saucedemo;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectElement implements Task {

    @Step("{0} selecciona y agrega 3 productos al carrito de compras")
    @Override
    public <T extends Actor> void performAs(T actor) {
        addFirstProduct(actor);
        addSecondProduct(actor);
        addThirdProduct(actor);
    }

    @Step("Usuario agrega el primer producto (Sauce Labs Backpack) al carrito")
    private void addFirstProduct(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(ADD_ELEMENT_1, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ADD_ELEMENT_1));
        WaitTime.putWaitTimeOf(1500);
    }

    @Step("Usuario agrega el segundo producto (Sauce Labs Bike Light) al carrito")
    private void addSecondProduct(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(ADD_ELEMENT_2, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ADD_ELEMENT_2));
        WaitTime.putWaitTimeOf(1500);
    }

    @Step("Usuario agrega el tercer producto (Sauce Labs Bolt T-Shirt) al carrito")
    private void addThirdProduct(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(ADD_ELEMENT_3, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ADD_ELEMENT_3));
        WaitTime.putWaitTimeOf(1500);
    }

    public static SelectElement elements() {
        return Tasks.instrumented(SelectElement.class);
    }
}
