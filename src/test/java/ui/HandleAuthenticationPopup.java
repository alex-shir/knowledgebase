package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class HandleAuthenticationPopup {

    public static String username = "admin"; // Read file XLS or CSV
    public static String password = "admin";

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth");
    }
}
