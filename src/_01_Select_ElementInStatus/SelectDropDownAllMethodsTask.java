package _01_Select_ElementInStatus;

import Utility.BaseDriver;
import Utility.MyFunc;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropDownAllMethodsTask extends BaseDriver {
    @Test
    public void TestSelectDropDown(){
      //Siteye gidiyoruz
        driver.get("https://the-internet.herokuapp.com/dropdown ");

        //DropDown menüsünü buluyoruz
        WebElement dropDown= driver.findElement(By.id("dropdown"));

        //Dropdown menüsünden select sınıfını kullanıyoruz
        Select select=new Select(dropDown);

        MyFunc.Bekle(2);
        //1.Yöntem: Görünen metine göre seçim yapmak(SelectByVisibleText)
        select.selectByVisibleText("Option 2");

        WebElement selectedOption1=select.getFirstSelectedOption();
        String selectedText1=selectedOption1.getText();
        System.out.println("Seçilen Değer(Görünen Metin):"+selectedText1);
        Assert.assertEquals("Option 2 ",selectedText1);




         MyFunc.Bekle(2);
        //2.Yöntem: Value attribute'une göre seçim yapmak
        select.selectByValue("1");

        WebElement selectedOption2=select.getFirstSelectedOption();
        String selectedText2=selectedOption2.getText();
        System.out.println("Seçilen Değer(Value Attribute):"+selectedText2);
        Assert.assertEquals("Option 1 ",selectedText2);


        MyFunc.Bekle(2);

        //3.yöntem:İndek numrasına göre seçim yapmak
        select.selectByIndex(2);

        WebElement selectedOption3=select.getFirstSelectedOption();
        String selectedText3=selectedOption3.getText();
        System.out.println("Seçilen Değer(Index):"+selectedText3);
        Assert.assertEquals("Option 2",selectedText3);


        MyFunc.Bekle(2);

         //4.Yöntem: Dropdown daki tüm seçenekleri almak (getoptions)
        List<WebElement>allOptions=select.getOptions();
        System.out.println("DropDown'daki tüm seçenekler:");
        for (WebElement option : allOptions){
            System.out.println(option.getText());
        }
         MyFunc.Bekle(2);

        //5.yöntem:İlk seçili olan seçeneği almak
         WebElement firstSelected=select.getFirstSelectedOption();
         String firstselectedText=firstSelected.getText();
        System.out.println("İlk seçili olan değer:"+firstselectedText);
        Assert.assertEquals("Option 2",firstselectedText);

        BekleKapat();
    }

}
