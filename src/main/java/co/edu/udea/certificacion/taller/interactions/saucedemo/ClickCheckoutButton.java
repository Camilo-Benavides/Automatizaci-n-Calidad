package co.edu.udea.certificacion.taller.interactions.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.CHECKOUT_BUTTON;

public class ClickCheckoutButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CHECKOUT_BUTTON));
    }

    public static ClickCheckoutButton click() {
        return Tasks.instrumented(ClickCheckoutButton.class);
    }
}