package testngPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNgOne {
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
    @Test
    public void testOne() throws InterruptedException {
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Selenium");

        //Indentify the google search box

        Thread.sleep(3000);
    }
    @AfterMethod
    public void end(){
        driver.close();
    }

}
