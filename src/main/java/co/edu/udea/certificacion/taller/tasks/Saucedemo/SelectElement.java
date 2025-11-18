package co.edu.udea.certificacion.taller.tasks.Saucedemo;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import net.serenitybdd.screenplay.targets.Target;
import java.util.List;

public class SelectElement implements Task {
    private final List<Target> elementsToSelect;

    public SelectElement(List<Target> elementsToSelect) {
        this.elementsToSelect = elementsToSelect;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Target element : elementsToSelect) {
            WaitTime.putWaitTimeOf(1000);
            actor.attemptsTo(Click.on(element));
            WaitTime.putWaitTimeOf(1000);
        }
    }

    public static SelectElement elements(List<Target> elementsToSelect) {
        return Tasks.instrumented(SelectElement.class, elementsToSelect);
    }
}
