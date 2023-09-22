package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class JavaScriptExecutorDemo {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onclick");

        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        //Print title page
        String script = "return document.title;";
        String title = (String) jsex.executeScript(script);
        System.out.println(title);
        //Click
        driver.switchTo().frame("iframeResult");
        jsex.executeScript("myFunction()");

        //highlight
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement button = driver.findElement(By.xpath("/html/body/button"));
        jsex.executeScript("arguments[0].style.border='5px solid green'", button);

        //Scroll
        driver.navigate().to("https://www.w3schools.com/");
        WebElement buttonstart = driver.findElement(By.cssSelector("a[class=\"w3-btn w3-margin-bottom\"]"));
        jsex.executeScript("arguments[0].scrollIntoView(true);", buttonstart);
    }
}
