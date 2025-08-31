package _06_Scroll;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class İnfiniteScrollTest extends BaseDriver {
//Task
    //- https://the-internet.herokuapp.com/infinite_scroll adresine gidin
    //- Sayfayı aşağı kaydırarak 10 paragrafın yüklenmesini sağlayın
    //- Yüklenen 10 paragrafı konsola yazdırın

    //Adımlar:
    //Sayfaya gidin ve sayafanın tamamen yüklendiğinden emin olun
    //JavaScriptExecutor kullanarak sayfanı altına doğru kaydırma işlemi yapın
    //Kaydırma sonrası,yeni yüklenen paragrafları tespit edin
    //Toplamda 10 paragraf yüklendikten sonra, bu paragrafları konsola yazdırın
    //Test sonunda tarayıcıyı kapatın

    @Test
    public void loadAndPrintTenPragraphs(){
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        List<String>paragraphs=new ArrayList<>();

        for (int i = 1; i <11 ; i++) {
            JavascriptExecutor js = null;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            WebElement paragraph=driver.findElement(By.xpath("(//div[@class='jscroll-added'])["+i+"]"));
            paragraphs.add(paragraph.getText());
            System.out.println(i+".Paragraf:"+paragraph.getText());

        }

        BekleKapat();
    }

}
