package co.edu.udea.certificacion.taller.interactions.saucedemo;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;


import net.serenitybdd.screenplay.targets.Target;

public class ClickKey implements Interaction {
    private final Target target;

    public ClickKey(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitTime.putWaitTimeOf(1000);
        actor.attemptsTo(Click.on(target));
        WaitTime.putWaitTimeOf(1000);
    }

    public static ClickKey on(Target target) {
        return Tasks.instrumented(ClickKey.class, target);
    }
}