package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintAllLinks {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/blog/category/tutorial/");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[class=\"cbtn btn_accept_ck allow__btn\"]")).click();

        driver.manage().window().maximize();
//        Thread.sleep(8000);
//        driver.findElement(By.cssSelector("span[id=\"exit_popup_close\"]")).click();

        List<WebElement> alltags = driver.findElements(By.tagName("a"));
        System.out.println("Total:" + alltags.size());

        for (int i = 0; i < alltags.size(); i++) {
            System.out.println("Links on page are " + alltags.get(i).getAttribute("href"));
            System.out.println("Links on page are " + alltags.get(i).getText());
        }
    }
}
