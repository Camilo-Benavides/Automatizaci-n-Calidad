package co.edu.udea.certificacion.taller.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class GooglePage extends PageObject {

    public static final Target INPUT_TEXT = Target.the("Text Box init").locatedBy("//*[@id=\'APjFqb\']");
}