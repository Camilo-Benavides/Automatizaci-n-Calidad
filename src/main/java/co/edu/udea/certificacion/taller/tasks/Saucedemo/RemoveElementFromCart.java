package co.edu.udea.certificacion.taller.tasks.Saucedemo;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.REMOVE_BACKPACK_FROM_CART;

public class RemoveElementFromCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitTime.putWaitTimeOf(1000);
        actor.attemptsTo(Click.on(REMOVE_BACKPACK_FROM_CART));
        WaitTime.putWaitTimeOf(2000);
    }

    public static RemoveElementFromCart remove(){
        return Tasks.instrumented(RemoveElementFromCart.class);
    }
}
