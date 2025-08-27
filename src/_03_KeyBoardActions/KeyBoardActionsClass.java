package _03_KeyBoardActions;

import Utility.MyFunc;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Utility.BaseDriver.BekleKapat;
import static Utility.BaseDriver.driver;

public class KeyBoardActionsClass {

    Actions actions=new Actions(driver);

    //Klavye Aksiyonları:Tek bir tuşa basma (SendKeys)
    @Test
    public void SendKeysTest(){
       driver.get("https://the-internet.herokuapp.com/key_presses");
        MyFunc.Bekle(2);

        WebElement bodyElement= driver.findElement(By.tagName("body"));
        bodyElement.sendKeys(Keys.SPACE); //Boşluk tuşuna tıkladım
        //Alternatif:Actions.SendKeys() kullanarak
        //actions.SendKeys(Keys.Space).perform()
        MyFunc.Bekle(2);


        BekleKapat();
    }
      //Klavye Aksiyonları:Ctrl+A kombinasyonları
    @Test
    public void keyDownAndUpWithCordTest(){
      driver.get("https://the-internet.herokuapp.com/key_presses");
      MyFunc.Bekle(2);

        WebElement bodyElement= driver.findElement(By.tagName("body"));
        MyFunc.Bekle(2);

        bodyElement.sendKeys(Keys.chord(Keys.CONTROL+"a"));//Ctrl+A kombinasyonu
        MyFunc.Bekle(2);

        //Alternatif:KeyDown ve KeyUp ile
        //actions.KeyDown(Keys.CONTROL).SendKeys("a").KeyUp(Keys.CONTROL).perform
        //Control e bas sonra a ya bas sonra kontrol den kaldır ve çalıştır

      BekleKapat();
    }
    //Klavye Aksiyonları:Birden fazla tuşa aynı anda basma (SHIFT+T)
    @Test
    public void multipleKeysTest(){
      driver.get("https://the-internet.herokuapp.com/key_presses");
      MyFunc.Bekle(2);

        WebElement bodyElement= driver.findElement(By.tagName("body"));
        bodyElement.sendKeys(Keys.chord(Keys.SHIFT+"t"));
        MyFunc.Bekle(2);


      BekleKapat();
    }
    //Klavye Aksiyonları:Zincirleme Tuş kombibasyonları (Ctrl+a ve ardından Delete)
    @Test
    public void keyCombinationChainTest(){
        driver.get("https://the-internet.herokuapp.com/key_presses");
        MyFunc.Bekle(2);

        WebElement bodyElement= driver.findElement(By.tagName("body"));
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        MyFunc.Bekle(2);

        BekleKapat();
    }
}
