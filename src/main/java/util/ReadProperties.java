package util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private final String filename = "/TypeDAO.properties";

//    String readDAO() throws IOException {
//        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {
//            Properties properties = new Properties();
//            properties.load(inputStream);
//            return properties.getProperty("typeDAO");
//        }
//    }
//    String getUrlJdbcConnection() throws IOException {
//
//        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)){
//            Properties properties = new Properties();
//            properties.load(inputStream);
//            return properties.getProperty("urlJdbcConnection");
//        }
//    }
public String getProp(String prop) throws IOException {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)){
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(prop);
        }
    }
}