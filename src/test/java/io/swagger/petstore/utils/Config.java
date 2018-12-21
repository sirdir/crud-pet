package io.swagger.petstore.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static final String BASE_URL;
    public static final String PET_PATH;

    static {
        Properties prop = new Properties();
        String sep = File.separator;

        try {
            String path = "build" + sep + "resources" + sep + "test" + sep + "config.properties";
            FileInputStream input = new FileInputStream(path);
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BASE_URL = prop.getProperty("base.url");
        PET_PATH = prop.getProperty("pet.path");
    }
}
