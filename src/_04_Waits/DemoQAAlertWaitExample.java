package _04_Waits;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class DemoQAAlertWaitExample extends BaseDriver {
    //Task: ExplicitWait ile zamanlı alert yakalama
    //Görev adımları:
    //1.https://demoqa.com/alerts sietsine gidiniz
    //2.Click me yazan butona tıklaynız.Bu buton 5 saniye sonra bir alerty penceresi açacaktır.
    //3.Bu alert penceresinin açılmasını bekleyiniz.
    //4.Alert penceresi açıldıktan sonra,alerti kabul ediniz.(Ok butonuna basınız)
    @Test
    public void waitForAlert(){
       driver.get("https://demoqa.com/alerts");
        MyFunc.Bekle(2);

        WebElement timerAlertButton= driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();

        wait.until(ExpectedConditions.alertIsPresent());//Alert görünür oluncaya kadar bekle

        driver.switchTo().alert().accept();//Alerti kabul et

        BekleKapat();
    }


}
