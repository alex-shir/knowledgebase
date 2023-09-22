package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class ShadowRootDemo {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        //Поиск элемента в shadow DOM
        driver.get("https://developer.salesforce.com/signup");

        WebElement root = driver.findElement(By.tagName("dw-de-signup-form"));
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        SearchContext shadowDOM1 = (SearchContext) jsexecutor.executeScript("return arguments[0].shadowRoot", root);

        List<WebElement> dxinput = shadowDOM1.findElements(By.className("full-name-field"));

        for (int i = 0; i < dxinput.size(); i++) {
            WebElement webElement = dxinput.get(i);
            SearchContext shadowDOM2 = (SearchContext) jsexecutor.executeScript("return arguments[0].shadowRoot", webElement);
            WebElement input = shadowDOM2.findElement(By.cssSelector("div:nth-child(1)>input[id='input']"));
            if (i == 0) {
                input.sendKeys("Test");
            } else {
                input.sendKeys("Testing");
            }
        }
    }
}
        
