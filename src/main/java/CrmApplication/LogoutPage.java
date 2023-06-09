package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class LogoutPage {

    WebDriver driver;
    //method syntax
    //return type method name(){
    //}
    //Annotation
    @BeforeMethod
    public void start(){
        //Interface reference variable;
        //Webdriver is an interface. which contains only abstarct methods. we can not create object to interface
        //with help of implementation classes we can use the abstract methods


        //webdrivermanager is a lib to interact to the browsers
        WebDriverManager.chromedriver().setup();
        //Created object to implementation class
        //classname objectname=new classname();
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

        Thread.sleep(10000);


        //driver.findElement(By.className("fa fa-sign-out icon-2x")).click();

        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//*[contains(text(),' Logout')]")).click();


        //driver.findElement(By.xpath("//input[@type = 'fa fa-sign-out icon-2x']")).click();

        //driver.findElement(By.partialLinkText("Home")).click();

        //driver.findElement(By.id("Home")).click();

        //driver.findElement(By.name("Home")).click();


        //driver.findElement(By.xpath("//a[text()='Home']")).click();


        //driver.findElement(By.xpath("//a[@href=\"" + "https://classic.freecrm.com/system/index.cfm?action=home" + "\"]"));



        //Here we are validating target page title verification
        Assert.assertEquals("CRMPRO",driver.getTitle(),"Title is not matched");


        Thread.sleep(3000);
    }
    @AfterMethod
    public void end(){
        driver.close();
    }
}
