package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class AlertHandle {

    WebDriver driver;

    @BeforeMethod
    public void start() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @org.testng.annotations.Test(groups = "smoke")
    public void testOne() throws InterruptedException {
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
