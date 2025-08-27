package _02_MouseActions;

import Utility.MyFunc;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Utility.BaseDriver.BekleKapat;
import static Utility.BaseDriver.driver;

public class MouseActionsClass {
    Actions actions=new Actions(driver);

    //Fare Aksiyonları:Bir elementin üzerine fareyi getirme
   @Test
    public void hoverOverTest(){
    driver.get("http://the-internet.herokuapp.com/hovers");

    MyFunc.Bekle(2);

       WebElement elementToHover= driver.findElement(By.xpath("(//div[@class='figure'])[1]/img"));
       actions.moveToElement(elementToHover).perform();//Elementin üzerine git
       MyFunc.Bekle(2);
       //Fareyi elementin belli bir nokatasına getirme


       BekleKapat();
   }
   //Fare Aksiyonları:Çift Tıklama (Double Click)
    @Test
    public void DoubleClickTest(){
     driver.get("https://demoqa.com/buttons");

     WebElement doubleClickButton= driver.findElement(By.id("doubleClickBtn"));

       //Fare ile çift tıkalama
        actions.doubleClick(doubleClickButton).perform();
        //Alternatif:Double click için önce element üzerine hareket edip çift tıklama
        //actions.moveToElement(doubleClickButton).doubleclick.perform

        MyFunc.Bekle(2);

        BekleKapat();
    }
    //Fare Aksiyonları:Sağ tıklama (Right click) ve Alert ile etkileşim
      @Test
    public void RightClickTest(){
       driver.get("http://the-internet.herokuapp.com/context_menu");

       MyFunc.Bekle(2);

       WebElement elementToRightClick=driver.findElement(By.id("hot-spot"));
       actions.contextClick(elementToRightClick).perform();
       MyFunc.Bekle(2);

       //Açılan alert penceresini handle etme
          Alert alert=driver.switchTo().alert();
          System.out.println(alert.getText());
          alert.accept();

        BekleKapat();
      }
      //Fare Aksiyonlar:Tıklama (Click)
    @Test
    public void clickTest(){
       driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
       MyFunc.Bekle(2);

       WebElement elementToClick= driver.findElement(By.xpath("//button[text()='Add Element']"));
       actions.click(elementToClick).perform();
       MyFunc.Bekle(2);

        //Alternatif: actions.moveToElement() ile tıklama işlemi
      // actions.moveToElement(elementToClick).click().perform();

       BekleKapat();

    }
     //Fare Aksiyonları:Tıklayıp tutma ve bırakma (Click and hold realese
       @Test
      public void clickAndHoldRealese(){
      driver.get("http://the-internet.herokuapp.com/drag_and_drop");
      MyFunc.Bekle(2);

      WebElement elementToClickAndHold= driver.findElement(By.id("column-a"));
      WebElement elementToDrop= driver.findElement(By.id("column-b"));
      MyFunc.Bekle(2);

      //Elementi tıklayıp tut ve hedefe bırak
           actions.clickAndHold(elementToClickAndHold).moveToElement(elementToDrop).release().perform();


           BekleKapat();
       }
        //Fare Aksiyonları:Sürükle ve bırak (Drag and Drop)
      @Test
     public void dragAndDrop(){
       driver.get(" http://the-internet.herokuapp.com/drag_and_drop");
       MyFunc.Bekle(2);

          WebElement sourceElement= driver.findElement(By.id("column-a"));
          WebElement targetElement= driver.findElement(By.id("column-b"));
          MyFunc.Bekle(2);

          actions.dragAndDrop(sourceElement,targetElement).perform();
          MyFunc.Bekle(2);

          BekleKapat();
      }
}
