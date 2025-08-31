package Utility;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor javascriptExecutor;

    static {

        driver=new ChromeDriver();
        driver.manage().window().maximize();//Ekranı maximum yapar.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));//20 sn sayfayı yükleme mühleti
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        javascriptExecutor = (JavascriptExecutor) driver;



    }
    public static void BekleKapat() {

        MyFunc.Bekle(3);
        driver.quit();

    }
}
