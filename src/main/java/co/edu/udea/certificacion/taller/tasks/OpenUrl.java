// OpenUrl.java
package co.edu.udea.certificacion.taller.tasks;

import co.edu.udea.certificacion.taller.utils.ConfigReader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenUrl implements Task {

    private final String key;

    public OpenUrl(String key) {
        this.key = key;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String fullKey = "pages." + key;
        String url = ConfigReader.getString(fullKey);
        actor.attemptsTo(Open.url(url));
    }

    public static OpenUrl page(String key){
        return Tasks.instrumented(OpenUrl.class, key);
    }
}
