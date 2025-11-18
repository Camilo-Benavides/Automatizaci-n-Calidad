package co.edu.udea.certificacion.taller.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContainsText implements Question<Boolean> {
    private static final Logger log = LoggerFactory.getLogger(ContainsText.class);
    private final Target target;
    private final String word;

    public ContainsText(Target target, String word) {
        this.target = target;
        this.word = word;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String text = target.resolveFor(actor).getText();
        log.info("[ContainsText] Texto obtenido: '{}' | Palabra buscada: '{}'", text, word);
        return text != null && word != null && text.toLowerCase().contains(word.toLowerCase());
    }

    public static ContainsText in(Target target, String word) {
        return new ContainsText(target, word);
    }
}
