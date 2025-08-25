package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {
    public static WebDriver driver;

    static {

        driver=new ChromeDriver();
        driver.manage().window().maximize();//Ekranı maximum yapar.
    }

}
