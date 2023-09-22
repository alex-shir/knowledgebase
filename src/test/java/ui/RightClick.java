package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/#colorpicker");
        driver.manage().window().maximize();
        WebElement frame = driver.findElement(By.cssSelector("iframe[class=\"demo-frame\"]"));
        driver.switchTo().frame(frame);

        WebElement rectangle = driver.findElement(By.id("swatch"));
        Actions action = new Actions(driver);
        // action.contextClick().perform(); клик по текущему месту правой кнопкой
        action.contextClick(rectangle).perform(); // для клика по опрделенному элементу
    }
}
