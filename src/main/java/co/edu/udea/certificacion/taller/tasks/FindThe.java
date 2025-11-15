package co.edu.udea.certificacion.taller.tasks;

import co.edu.udea.certificacion.taller.interactions.InputKey;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FindThe implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(InputKey.searchWord());
    }

    public static FindThe keyWord(){
        return Tasks.instrumented(FindThe.class);
    }
}
