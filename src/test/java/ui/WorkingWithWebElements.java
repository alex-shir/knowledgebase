package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithWebElements {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.sugarcrm.com/request-demo/");
        driver.findElement(By.cssSelector("button[id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("Testing");
        driver.findElement(By.cssSelector("input[name=\"email\"]")).clear();
        System.out.println(driver.findElement(By.cssSelector("input[name=\"email\"]")).getAttribute("class"));
        System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"]")).getCssValue("text-transform"));
        System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"]")).getSize());
        System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"]")).getLocation());
        System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"]")).getText());
        System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"]")).getTagName());
        System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"]")).isDisplayed());
        System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"]")).isEnabled());
        System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"]")).isSelected());
    }
}
