package co.edu.udea.certificacion.taller.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SaucedemoPage extends PageObject {
    static String addElement = "Add element to shopping cart";
    
    public static final Target INPUT_USERNAME = Target.the("Text box username").locatedBy("//*[@id=\'user-name\']");
    public static final Target INPUT_PASSWORD = Target.the("Text box password").locatedBy("//*[@id=\'password\']");
    public static final Target BUTTON_SUBMIT = Target.the("Button login in").locatedBy("//*[@id=\'login-button\']");
    public static final Target ADD_ELEMENT_1 = Target.the(addElement).locatedBy("//*[@id=\'add-to-cart-sauce-labs-backpack\']");
    public static final Target ADD_ELEMENT_2 = Target.the(addElement).locatedBy("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
    public static final Target ADD_ELEMENT_3 = Target.the(addElement).locatedBy("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
    public static final Target REMOVE_ELEMENT_1 = Target.the("Remove element").locatedBy("//*[@id=\"remove-sauce-labs-bike-light\"]");
    public static final Target REMOVE_ELEMENT_2 = Target.the("Remove element").locatedBy("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]");
    public static final Target SHOPPING_CART = Target.the("Move to Shopping Cart").locatedBy("//*[@id=\"shopping_cart_container\"]/a");
    public static final Target SHOPPING_CART_BADGE = Target.the("Count").locatedBy("//*[@id=\"shopping_cart_container\"]/a/span");
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout Button").locatedBy("//*[@id=\"checkout\"]");
    public static final Target INPUT_FIRST_NAME = Target.the("Input First Name").locatedBy("//*[@id=\"first-name\"]");
    public static final Target INPUT_LAST_NAME = Target.the("Input Last Name").locatedBy("//*[@id=\"last-name\"]");
    public static final Target INPUT_POSTAL_CODE = Target.the("Input Postal Code").locatedBy("//*[@id=\"postal-code\"]");
    public static final Target CONTINUE_BUTTON = Target.the("Continue Button").locatedBy("//*[@id=\"continue\"]");
    public static final Target REMOVE_BACKPACK_FROM_CART = Target.the("Remove element from cart").locatedBy("//*[@id=\"remove-sauce-labs-backpack\"]");

}
