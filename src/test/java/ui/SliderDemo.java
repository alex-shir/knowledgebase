package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/#colorpicker");
        driver.manage().window().maximize();
        WebElement frame = driver.findElement(By.cssSelector("iframe[class=\"demo-frame\"]"));
        driver.switchTo().frame(frame);

        WebElement redslider = driver.findElement(By.cssSelector("div[id=\"red\"]>[class=\"ui-slider-handle ui-corner-all ui-state-default\"]"));
        WebElement greenslider = driver.findElement(By.cssSelector("div[id=\"green\"]>[class=\"ui-slider-handle ui-corner-all ui-state-default\"]"));
        WebElement blueslider = driver.findElement(By.cssSelector("div[id=\"blue\"]>[class=\"ui-slider-handle ui-corner-all ui-state-default\"]"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(redslider, 30, 123).perform();
        action.dragAndDropBy(greenslider, -100, 279).perform();
        action.dragAndDropBy(blueslider, 157, 320).perform();
    }
}
