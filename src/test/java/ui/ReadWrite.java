package ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadWrite {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("C:\\gitprojects\\autowithmaven\\autotest\\src\\test\\resources\\properties\\testdata.properties");
        properties.load(inputStream);
        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("url"));
        FileOutputStream outputStream = new FileOutputStream("C:\\gitprojects\\autowithmaven\\autotest\\src\\test\\resources\\properties\\testdata.properties");
        properties.setProperty("testdate", "65654");
        properties.store(outputStream, "This is number");
    }
}
