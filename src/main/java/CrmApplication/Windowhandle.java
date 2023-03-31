package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Windowhandle {


    WebDriver driver;

    @BeforeMethod
    public void start() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @org.testng.annotations.Test
    public void testOne() throws InterruptedException {
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();

        Thread.sleep(3000);
         Set<String> windows= driver.getWindowHandles();

         Iterator<String> it=windows.iterator();
         while (it.hasNext()){
             String window1=it.next();
             driver.switchTo().window(window1);
         }
        Assert.assertEquals("OrangeHRM | LinkedIn",driver.getTitle(),"Title is not matched");
        Thread.sleep(3000);
        driver.close();

    }
}
