package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class AlertDismiss {
    static WebDriver driver;

    @BeforeMethod
    public void start() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @org.testng.annotations.Test(groups = "Regression")
    public void testOne() throws InterruptedException {
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Alert a=driver.switchTo().alert();
        Thread.sleep(3000);
        a.dismiss();

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        Alert a2=driver.switchTo().alert();
       // a2.getText();
        a2.accept();
        Thread.sleep(3000);

        driver.close();

    }

    @org.testng.annotations.Test(groups = "smoke")
    public void testTwo() throws InterruptedException {
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert a=driver.switchTo().alert();
        Thread.sleep(3000);
        a.accept();
        Thread.sleep(3000);
        driver.close();

    }
}
