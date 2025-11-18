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

public class RemoveElement implements Task {

    @Step("{0} remueve productos del carrito de compras")
    @Override
    public <T extends Actor> void performAs(T actor) {
        removeFirstProduct(actor);
        removeSecondProduct(actor);
    }

    @Step("Usuario remueve el primer producto (Sauce Labs Bike Light) del carrito")
    private void removeFirstProduct(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(REMOVE_ELEMENT_1, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(REMOVE_ELEMENT_1));
        WaitTime.putWaitTimeOf(1500);
    }

    @Step("Usuario remueve el segundo producto (Sauce Labs Bolt T-Shirt) del carrito")
    private void removeSecondProduct(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(REMOVE_ELEMENT_2, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(REMOVE_ELEMENT_2));
        WaitTime.putWaitTimeOf(1500);
    }

    public static RemoveElement remove() {
        return Tasks.instrumented(RemoveElement.class);
    }
}
