package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoIframe {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

        driver.manage().window().maximize();
        WebElement frame1 = driver.findElement(By.cssSelector("div[id=\"iframecontainer\"] > div[id= \"iframe\"] > div[id= \"iframewrapper\"] > iframe"));
        driver.switchTo().frame(frame1);
        System.out.println(frame1.isSelected());
        driver.findElement(By.id("w3loginbtn")).click();
        driver.switchTo().parentFrame();
        System.out.println();
    }
}
