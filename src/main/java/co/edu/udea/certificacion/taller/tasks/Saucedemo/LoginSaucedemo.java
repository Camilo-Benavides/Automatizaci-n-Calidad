package co.edu.udea.certificacion.taller.tasks.Saucedemo;

import co.edu.udea.certificacion.taller.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.*;

public class LoginSaucedemo implements Task {

    private final String username;
    private final String password;

    public LoginSaucedemo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitTime.putWaitTimeOf(1000);
        actor.attemptsTo(Enter.theValue(username).into(INPUT_USERNAME));
        WaitTime.putWaitTimeOf(1000);
        actor.attemptsTo(Enter.theValue(password).into(INPUT_PASSWORD));
        WaitTime.putWaitTimeOf(1000);
        actor.attemptsTo();
        actor.attemptsTo(Click.on(BUTTON_SUBMIT));
        WaitTime.putWaitTimeOf(1000);
    }

    public static LoginSaucedemo login(String username, String password) {
        return Tasks.instrumented(LoginSaucedemo.class, username, password);
    }
}
