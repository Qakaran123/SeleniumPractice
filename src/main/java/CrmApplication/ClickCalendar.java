package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ClickCalendar {

    WebDriver driver;

    @BeforeMethod
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }

    @Test(groups = "Regression")

    public void testone() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://classic.crmpro.com/index.html");
        driver.findElement(By.className("form-control")).sendKeys("qatestertest");
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Test@123");

        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        Assert.assertEquals("CRMPRO", driver.getTitle(),"Title is not matched");

        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//a[contains(text(),'Calendar')]")).click();

    }

    @AfterMethod
    public void end() {
        driver.close();
    }
}
