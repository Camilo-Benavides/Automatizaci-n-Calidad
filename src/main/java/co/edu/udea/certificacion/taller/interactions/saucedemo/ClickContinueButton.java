package co.edu.udea.certificacion.taller.interactions.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.CONTINUE_BUTTON;

public class ClickContinueButton implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CONTINUE_BUTTON));
    }

    public static ClickContinueButton click() {
        return Tasks.instrumented(ClickContinueButton.class);
    }
}