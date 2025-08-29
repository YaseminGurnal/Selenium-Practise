package _04_Waits;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class ExpilicitWaitButtonExample extends BaseDriver {
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    //Görev
    //https://the-internet.herokuapp.com/dynamic_loading/2 sitesine gidiniz
    //Start butununa tıklayınız
    //Dinamik olarak yüklenecek Hello Word! yazısını bekleyiniz ve yazının görünür olduğunu doğrulayınız
    //Çözüm:Bu task ta Expilicit wait kullanarak dinamik olarak yüklelen bir elementin
    //görünür olamasını bekleyeceğiz.

    @Test
    public  void expilicitWaitButtonTask(){
      driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement startButton= driver.findElement(By.xpath("//button[text()='Start']"));
        startButton.click();



        WebElement helloWordText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World']")));
        System.out.println("helloWordText.getText() = " + helloWordText.getText());

        Assert.assertTrue(" 'Hello World' görüntülenemedi.",helloWordText.getText().contains("Hello World"));

       BekleKapat();
    }

}
