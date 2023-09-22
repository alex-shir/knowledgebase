package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.IOException;

public class HandleSSLErrors {


    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions coptions = new ChromeOptions();
        //coptions.setAcceptInsecureCerts(true);
        coptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        WebDriver driver = new ChromeDriver(coptions);
        driver.get("https://expired.badssl.com/");
    }
}
