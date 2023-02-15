package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String property){
        Properties prop = null;
        FileInputStream fileInput = null;
        String filePath = "src/test/java/data/config/configuration.properties";
        try{
            fileInput = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fileInput);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                fileInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop.getProperty(property);
    }
}
