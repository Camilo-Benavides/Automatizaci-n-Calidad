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
        actor.attemptsTo(Enter.theValue(username).into(INPUT_USERNAME)); // Se podria combinar con la siguiente linea
        WaitTime.putWaitTimeOf(2000);
        actor.attemptsTo(Enter.theValue(password).into(INPUT_PASSWORD)); //Se podria combinar con la anterior linea
        WaitTime.putWaitTimeOf(2000);
        actor.attemptsTo(); //¿Es necesaria esta linea?
        actor.attemptsTo(Click.on(BUTTON_SUBMIT));

        /* TODO:
         * @Override
         * public <T extends Actor> void performAs(T actor) {
         *  actor.attemptsTo(
         *      Enter.theValue(username).into(INPUT_USERNAME),
         *      Enter.theValue(password).into(INPUT_PASSWORD)
         *  );
         *  WaitTime.putWaitTimeOf(2000);
         *  actor.attemptsTo(Click.on(BUTTON_SUBMIT));
         *}
         */
    }

    public static LoginSaucedemo login(String username, String password) {
        return Tasks.instrumented(LoginSaucedemo.class, username, password);
    }
}
