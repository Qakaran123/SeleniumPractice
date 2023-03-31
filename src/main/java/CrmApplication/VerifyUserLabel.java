package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class VerifyUserLabel {
    WebDriver driver;

    @BeforeMethod
    public void start(){

        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();
    }
    @org.testng.annotations.Test
    public void testOne() throws InterruptedException {
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://classic.crmpro.com/index.html");

        driver.findElement(By.className("form-control")).sendKeys("qatestertest");

        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Test@123");


        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        //Here we are validating target page title verification
        Assert.assertEquals("CRMPRO",driver.getTitle(),"Title is not matched");

        //Handle frames in selenium
        //driver.switchTo().frame("leftpanel");
        driver.switchTo().frame(1);
        WebElement userLabel=driver.findElement(By.xpath("//td[contains(text(),'User: Test QA')]"));
        if (userLabel.isDisplayed()){
            System.out.println("User is being displayed");
        }
        else {
            System.out.println("User label is not displayed");
        }


    }
    @AfterMethod
    public void end(){
        driver.close();
    }


}
