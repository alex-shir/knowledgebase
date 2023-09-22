package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ChekBoxDemo {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sugarcrm.com/request-demo/");
        driver.findElement(By.cssSelector("button[id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
        driver.manage().window().maximize();
        driver.findElement(By.id("doi0")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("doi0")).click();

        List<WebElement> size = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        System.out.println(size);

        WebElement scroll = driver.findElement(By.cssSelector("a[class=\"btn btn-primary btn btn-outline-dark\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(scroll);
        actions.perform();
    }
}
