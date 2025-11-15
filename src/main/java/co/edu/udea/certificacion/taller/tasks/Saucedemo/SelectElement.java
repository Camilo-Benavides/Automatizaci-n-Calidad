package co.edu.udea.certificacion.taller.tasks.Saucedemo;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.*;

public class SelectElement implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ADD_ELEMENT_1));
        WaitTime.putWaitTimeOf(2000);
        actor.attemptsTo(Click.on(ADD_ELEMENT_2));
        WaitTime.putWaitTimeOf(2000);
        actor.attemptsTo(Click.on(ADD_ELEMENT_3));
    }

    public static SelectElement elements(){
        return Tasks.instrumented(SelectElement.class);
    }
}
