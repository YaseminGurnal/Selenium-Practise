package Utility;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;

    static {

        driver=new ChromeDriver();
        driver.manage().window().maximize();//Ekranı maximum yapar.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));//20 sn sayfayı yükleme mühleti
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public static void BekleKapat() {

        MyFunc.Bekle(3);
        driver.quit();

    }
}
