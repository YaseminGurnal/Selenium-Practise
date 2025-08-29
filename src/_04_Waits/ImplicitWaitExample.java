package _04_Waits;

import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static Utility.BaseDriver.BekleKapat;
import static Utility.BaseDriver.driver;

public class ImplicitWaitExample {

    //Görev
    //https://www.saucedemo.com/ sitesine gidiniz
    //Kullanıcı adı ve şifreyi giriniz
    //Kullanıcı ad: standard user
    //Şifre: secret_sauce
    //Login butonuna tıklayınız
    //Sonrasında gelen sayfada ilk ürünün yüklendiğini ve göründüğünü doğrulayınız

    @Test
    public void implicitWaitTask() {
        driver.get("https://www.saucedemo.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement logınButton = driver.findElement(By.id("login-button"));
        logınButton.click();

        //İlk ürünün yüklendiğini element alarak kontrol etmiş olduk.
        WebElement ilkÜrün = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        System.out.println("ilkÜrün.getText() = " + ilkÜrün.getText());

        //Doğrulama İşlemi
        Assert.assertTrue("Ürün görüntülenmedi.",ilkÜrün.isDisplayed());

        BekleKapat();
    }
}
