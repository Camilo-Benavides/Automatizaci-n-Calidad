package co.edu.udea.certificacion.taller.tasks.Saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.*;

public class FillCheckoutForm implements Task {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public FillCheckoutForm(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(firstName).into(INPUT_FIRST_NAME),
            Enter.theValue(lastName).into(INPUT_LAST_NAME),
            Enter.theValue(postalCode).into(INPUT_POSTAL_CODE)
        );
    }

    public static FillCheckoutForm withData(String firstName, String lastName, String postalCode) {
        return Tasks.instrumented(FillCheckoutForm.class, firstName, lastName, postalCode);
    }
}