package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonDemo {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.singaporeair.com/en_UK/tr/home#/book/bookflight");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[class=\"dwc--SiaCookie__PopupEssentialBtn dwc--SiaCookie__PopupAllBtn\"]")).click();

        WebElement radio1 = driver.findElement(By.id("bookFlights"));
        WebElement radio2 = driver.findElement(By.id("redeemFlights"));
        radio1.click();
        radio2.click();
        System.out.println(radio1.isSelected());
        System.out.println(radio2.isSelected());

        System.out.println(driver.findElements(By.xpath("//*[@name=\"book-flight-radio\"]")).size());
    }
}
