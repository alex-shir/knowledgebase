package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sugarcrm.com/request-demo/");
        driver.findElement(By.cssSelector("button[id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.name("awareness_source_c"));
        Select select = new Select(dropdown);

        select.selectByValue("Event");
        Thread.sleep(5000);

        select.selectByVisibleText("Podcast");
        Thread.sleep(5000);
        select.selectByIndex(3);
        Thread.sleep(5000);
    }
}
