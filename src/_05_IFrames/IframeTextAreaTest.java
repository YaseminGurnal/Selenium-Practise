package _05_IFrames;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IframeTextAreaTest extends BaseDriver {
    //Task
    //1.https://www.w3schools.com/tags/tryit.asp?filename_tryhtml_textarea adresine gidin
    //2.Çerez onayı varsa kapatın
    //3.Sayfadaki Iframe geçiş yapın
    //4.Iframe içindeki textarea'nın mevcut metnini temizleyip,yeni metin yazın:"Bu metin Selenium ile değiştirilmiştir."
    //5.Iframe den çıkın ve anasayfa dönün
    //6.Birkaç saniye bekleyip sayfayı kapatın

    @Test
    public void ıframeTextAreaTest(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename_tryhtml_textarea");

        List<WebElement>acceptCookiesButton=driver.findElements(By.id("accept-choices"));
        //Liste atmamızın sebebi çerez olsada olmasada çalışıcaktır.
        if (!acceptCookiesButton.isEmpty())
            acceptCookiesButton.getFirst().click();

        WebElement ıframe= driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(ıframe);

        WebElement textArea= driver.findElement(By.id("w3review"));
        textArea.clear();
        MyFunc.Bekle(2);
        textArea.sendKeys("Bu metin selenium ile değiştirilmiştir!");

        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent(); Bu da aynı şekilde ana sayfaya gelir.

        BekleKapat();

    }



}
