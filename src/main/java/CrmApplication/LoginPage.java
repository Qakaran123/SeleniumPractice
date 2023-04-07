package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginPage {
    //Created reference variable to interfcae in class level
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
        driver.get("https://classic.crmpro.com/index.html");

       // driver.findElement(By.className("form-control")).sendKeys("qatestertest");
        WebElement element = driver.findElement(By.className("form-control"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='qatestertest ';", element);

        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Test@123");


        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        //Here we are validating target page title verification
        Assert.assertEquals("CRMPRO",driver.getTitle(),"Title is not matched");

        //Indentify the google search box



        Thread.sleep(3000);
    }
    @AfterMethod
    public void end(){
        driver.close();
    }
}
