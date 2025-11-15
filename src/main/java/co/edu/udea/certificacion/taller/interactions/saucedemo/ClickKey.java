package co.edu.udea.certificacion.taller.interactions.saucedemo;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.SHOPPING_CART;

public class ClickKey implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitTime.putWaitTimeOf(2000);
        actor.attemptsTo(Click.on(SHOPPING_CART));
    }

    public static ClickKey move_to_shopping_cart() {
        return Tasks.instrumented(ClickKey.class);
    }
}
