package _07_RobotClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class GoogleSearchWithRobotClass extends BaseDriver {
    //Task
    //1.Google ana sayfasına gidin https://www.google.com
    //2.Tümünü reddet butonu var ise çerez uyarısını kapatın
    //3.Google arama kutusuna fare ile tıklayarak odaklanın
    //4.Robot class kullnarak Selenium robot class metnini panoya kopyalayın ve arama kutusuna yapıştırın
    //5.Arama işlemini başlatmak için Enter tuşuna basın
    //6.Google arama sonuçlarında sayfanın tam olarak yüklenmesini bekleyin(İlk sonuç başlığının görünmesini bekleyin)
    //7.Fareyi ekranın sağ üst köşesine hareket ettirin ve sol tıklama yapın
    //Not:Kordinatlar ekranın çözünürlüğüne göre dinamik olarak ayarlanmış olmalıdır
    //8.Fareyi ekranın sol alt köşesine hareket ettirin ve sağ tıklama yapın
    //Not:Bu harekette dinamik olarak ekran çözünürlüğüne göre ayarlanmış olmalıdır
    //9.Tüm işlemler tamamlandıktan sonra tarayıcıyı kapatın
    @Test
    public void RobotClassTest() throws AWTException {
        driver.get("https://www.google.com");
        MyFunc.Bekle(2);

        List<WebElement> RejectAll = driver.findElements(By.xpath("//button[@id='W0wltc']/div"));
        if (!RejectAll.isEmpty()) {
            RejectAll.getFirst().click();
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
        MyFunc.Bekle(2);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("screenSize = " + screenSize);
        int screenWidth = screenSize.width;
        System.out.println("screenWidth = " + screenWidth);
        int screenHeight = screenSize.height;
        System.out.println("screenHeight = " + screenHeight);

        Robot robot = new Robot();

        String searchTerm = "Selenium Robot Class";
        StringSelection stringSelection = new StringSelection(searchTerm);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        MyFunc.Bekle(2);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        MyFunc.Bekle(2);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement firstResultHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//h3")));

            robot.mouseMove(screenWidth-50,50);
            MyFunc.Bekle(2);

          robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
          robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

          MyFunc.Bekle(2);

          robot.mouseMove(40,screenHeight-50);
          MyFunc.Bekle(2);

        robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);
        MyFunc.Bekle(2);

    }

}
