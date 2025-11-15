package co.edu.udea.certificacion.taller.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SaucedemoPage extends PageObject {

    public static final Target INPUT_USERNAME = Target.the("Text box username").locatedBy("//*[@id=\'user-name\']");
    public static final Target INPUT_PASSWORD = Target.the("Text box password").locatedBy("//*[@id=\'password\']");
    public static final Target BUTTON_SUBMIT = Target.the("Button login in").locatedBy("//*[@id=\'login-button\']");
    public static final Target ADD_ELEMENT_1 = Target.the("Add element to shopping cart").locatedBy("//*[@id=\'add-to-cart-sauce-labs-backpack\']");
    public static final Target ADD_ELEMENT_2 = Target.the("Add element to shopping cart").locatedBy("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
    public static final Target ADD_ELEMENT_3 = Target.the("Add element to shopping cart").locatedBy("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
    public static final Target REMOVE_ELEMENT_1 = Target.the("Remove element").locatedBy("//*[@id=\"remove-sauce-labs-bike-light\"]");
    public static final Target REMOVE_ELEMENT_2 = Target.the("Remove element").locatedBy("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]");
    public static final Target SHOPPING_CART = Target.the("Move to Shopping Cart").locatedBy("//*[@id=\"shopping_cart_container\"]/a");

}
