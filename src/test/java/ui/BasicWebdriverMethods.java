package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasicWebdriverMethods {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.setAcceptInsecureCerts(true);
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get("https://accounts.lambdatest.com/register");
        driver.manage().window().maximize();

//        String currentUrl = driver.getCurrentUrl();
//        System.out.println(currentUrl);
//
//        String title = driver.getTitle();
//        System.out.println(title);
//
//        String pagesource = driver.getPageSource();
//        System.out.println(pagesource);

        driver.navigate().to("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("div[class=\"login-box\"] input[data-test='login-button']")).click();


        List<WebElement> webelements = driver.findElements(By.cssSelector("div[class='inventory_list'] > div"));
        System.out.println(webelements);

        driver.navigate().to("https://www.sugarcrm.com/");
        driver.findElement(By.cssSelector("button[id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
        String windowhandle = driver.getWindowHandle();
        System.out.println(windowhandle);

        // Ожидание подгрузки кнопки до ее кликабельности
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"col-md-4 mb-5\"] > a[class=\"btn btn-outline-dark\"]")));
        button.click();



//        driver.findElement(By.cssSelector("div[class=\"slide-buttons\"] > a[class=\"btn btn-outline-light\"]")).click();
        Set<String> windowhandles = driver.getWindowHandles();
        System.out.println(windowhandles);
    }
}
