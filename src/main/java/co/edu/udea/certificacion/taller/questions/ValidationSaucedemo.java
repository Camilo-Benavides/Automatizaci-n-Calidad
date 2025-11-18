package co.edu.udea.certificacion.taller.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.SHOPPING_CART_BADGE;

public class ValidationSaucedemo implements Question<String> {
    //TODO: Se podria pensar en validaciones o expeciones

    private static final Logger log = LoggerFactory.getLogger(ValidationSaucedemo.class);
    @Override
    public String answeredBy(Actor actor) {
        String value = BrowseTheWeb.as(actor).find(SHOPPING_CART_BADGE).getText();
        log.info(value);
        return value.trim();
    }

    public static ValidationSaucedemo validateShoppingCart(){
        return new ValidationSaucedemo();
    }
}