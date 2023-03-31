package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class QuickCreate {
    WebDriver driver;

    @BeforeMethod
    public void start(){

        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();
    }
    @org.testng.annotations.Test
    public void testOne() throws InterruptedException {
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/index.html");

        driver.findElement(By.className("form-control")).sendKeys("qatestertest");

        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Test@123");


        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        Assert.assertEquals("CRMPRO",driver.getTitle(),"Title is not matched");


        driver.switchTo().frame(1);
        WebElement button=driver.findElement(By.xpath("//a[contains(text(),'Quick Create»')]"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();

        Thread.sleep(5000);

       // driver.switchTo().frame(0);


        driver.findElement(By.xpath("//input[@name='company_name']")).sendKeys("Quick");

        //driver.findElement(By.className("contact_first_name")).sendKeys("Karan");

       // driver.findElement(By.className("contact_surname")).sendKeys("C");

       // driver.findElement(By.xpath("//input[@type = 'button']")).click();



        Thread.sleep(5000);

    }
    @AfterMethod
    public void end(){
        driver.close();
    }
}
