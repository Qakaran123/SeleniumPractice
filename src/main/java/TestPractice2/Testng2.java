package TestPractice2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Testng2 {
    WebDriver driver;

    @BeforeMethod
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //syntax for implicit wait
        //driverobject.manage().implicitwait(time,timeunits);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.google.com/");

        driver.findElement(By.linkText("Images")).click();
        Thread.sleep(3000);

        //Sample code to handle drop downs
        Select sc=new Select(driver.findElement(By.id("somevalue")));
        sc.selectByIndex(2);
        sc.selectByValue("Telangana");
        sc.selectByVisibleText("Telanagana");
    }

@AfterMethod
public void end()
{
    driver.close();

}

}

