package co.edu.udea.certificacion.taller.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.taller.userinterfaces.SaucedemoPage.SHOPPING_CART_BADGE;

public class ValidationSaucedemo implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String value = BrowseTheWeb.as(actor).find(SHOPPING_CART_BADGE).getText();
        System.out.println(value);
        return value.trim();
    }

    public static ValidationSaucedemo validateShoppingCart(){
        return new ValidationSaucedemo();
    }
}