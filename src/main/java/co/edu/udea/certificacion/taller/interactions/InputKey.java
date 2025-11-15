package co.edu.udea.certificacion.taller.interactions;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.edu.udea.certificacion.taller.userinterfaces.GooglePage.INPUT_TEXT;

public class InputKey implements Interaction{

    @Override
    public <T extends Actor> void performAs(T actor) {

        WaitTime.putWaitTimeOf(2000);
        actor.attemptsTo(Enter.theValue("saucedemo").into(INPUT_TEXT).thenHit(Keys.ENTER));

    }

    public static InputKey searchWord(){
        return Tasks.instrumented(InputKey.class);
    }
}
