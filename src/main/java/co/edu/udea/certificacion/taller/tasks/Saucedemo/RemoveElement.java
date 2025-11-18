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

public class RemoveElement implements Task {
    private final List<Target> elementsToRemove;

    public RemoveElement(List<Target> elementsToRemove) {
        this.elementsToRemove = elementsToRemove;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Target element : elementsToRemove) {
            WaitTime.putWaitTimeOf(1000);
            actor.attemptsTo(Click.on(element));
            WaitTime.putWaitTimeOf(1000);
        }
    }

    public static RemoveElement remove(List<Target> elementsToRemove) {
        return Tasks.instrumented(RemoveElement.class, elementsToRemove);
    }
}
