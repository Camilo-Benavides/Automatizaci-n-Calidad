package co.edu.udea.certificacion.taller.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SaucedemoPage extends PageObject {
    static final String ADD_ELEMENT = "Add element to shopping cart";
    static final String REMOVE_ELEMENT = "Remove element from shopping cart";
    
    public static final Target INPUT_USERNAME = Target.the("Text box username").locatedBy("//*[@id=\'user-name\']");
    public static final Target INPUT_PASSWORD = Target.the("Text box password").locatedBy("//*[@id=\'password\']");
    public static final Target BUTTON_SUBMIT = Target.the("Button login in").locatedBy("//*[@id=\'login-button\']");
    public static final Target ADD_ELEMENT_1 = Target.the(ADD_ELEMENT).locatedBy("//*[@id=\'add-to-cart-sauce-labs-backpack\']");
    public static final Target ADD_ELEMENT_2 = Target.the(ADD_ELEMENT).locatedBy("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
    public static final Target ADD_ELEMENT_3 = Target.the(ADD_ELEMENT).locatedBy("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
    public static final Target REMOVE_ELEMENT_1 = Target.the(REMOVE_ELEMENT).locatedBy("//*[@id=\'remove-sauce-labs-backpack\']");
    public static final Target REMOVE_ELEMENT_2 = Target.the(REMOVE_ELEMENT).locatedBy("//*[@id=\"remove-sauce-labs-bike-light\"]");
    public static final Target REMOVE_ELEMENT_3 = Target.the(REMOVE_ELEMENT).locatedBy("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]");
    public static final Target SHOPPING_CART = Target.the("Move to Shopping Cart").locatedBy("//*[@id=\"shopping_cart_container\"]/a");
    public static final Target SHOPPING_CART_BADGE = Target.the("Count").locatedBy("//*[@id=\"shopping_cart_container\"]/a/span");
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout Button").locatedBy("//*[@id=\"checkout\"]");
    public static final Target INPUT_FIRST_NAME = Target.the("Input First Name").locatedBy("//*[@id=\"first-name\"]");
    public static final Target INPUT_LAST_NAME = Target.the("Input Last Name").locatedBy("//*[@id=\"last-name\"]");
    public static final Target INPUT_POSTAL_CODE = Target.the("Input Postal Code").locatedBy("//*[@id=\"postal-code\"]");
    public static final Target CONTINUE_BUTTON = Target.the("Continue Button").locatedBy("//*[@id=\"continue\"]");
    public static final Target REMOVE_BACKPACK_FROM_CART = Target.the("Remove element from cart").locatedBy ("//*[@id=\"remove-sauce-labs-backpack\"]");
    public static final Target ERROR_MESSAGE = Target.the("Error Message").locatedBy("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]");
    public static final Target CHECKOUT_OVERVIEW = Target.the("Checkout Overview").locatedBy("//*[@id=\"header_container\"]/div[2]/span");
}
