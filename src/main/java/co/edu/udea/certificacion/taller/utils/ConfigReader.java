package co.edu.udea.certificacion.taller.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigReader {
    private static final Config config = ConfigFactory.load();  // Tener cuidado que aquí lee el archivo application.conf

    private ConfigReader() {}

    public static String getString(String key) { //Aqui pueden agregar una excepción
        return config.getString(key);
    }
}
