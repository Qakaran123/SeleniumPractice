package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SignUp {
    WebDriver driver;

    @BeforeMethod
    public void start(){

        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();
    }
    @org.testng.annotations.Test
    public void testOne() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://classic.crmpro.com/index.html");



        driver.findElement(By.partialLinkText("Sign Up")).click();

        Thread.sleep(5000);



    }
    @AfterMethod
    public void end(){
        driver.close();
    }

}
