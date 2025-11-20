package co.edu.udea.certificacion.taller.tasks.Saucedemo;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import net.serenitybdd.screenplay.targets.Target;

public class RemoveElementFromCart implements Task {
    private final Target elementToRemove;

    public RemoveElementFromCart(Target elementToRemove) {
        this.elementToRemove = elementToRemove;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitTime.putWaitTimeOf(1000);
        actor.attemptsTo(Click.on(elementToRemove));
        WaitTime.putWaitTimeOf(1000);
    }

    public static RemoveElementFromCart remove(Target elementToRemove){
        return Tasks.instrumented(RemoveElementFromCart.class, elementToRemove);
    }
}
