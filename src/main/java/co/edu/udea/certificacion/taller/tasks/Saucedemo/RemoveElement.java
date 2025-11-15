package co.edu.udea.certificacion.taller.tasks.Saucedemo;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.REMOVE_ELEMENT_1;
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.REMOVE_ELEMENT_2;

public class RemoveElement implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(REMOVE_ELEMENT_1));
        WaitTime.putWaitTimeOf(2000);
        actor.attemptsTo(Click.on(REMOVE_ELEMENT_2));
    }

    public static RemoveElement remove(){
        return Tasks.instrumented(RemoveElement.class);
    }
}
