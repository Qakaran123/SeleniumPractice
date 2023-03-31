package CrmApplication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class AlertsTab {
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

        Assert.assertEquals("CRMPRO", driver.getTitle(), "Title is not matched");


        driver.switchTo().frame(1);
        WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Alerts')]"));
        Actions action = new Actions(driver);
        action.moveToElement(button).build().perform();
        button.click();

        Thread.sleep(5000);


        Select sc1=new Select(driver.findElement(By.name("object_type")));
        sc1.selectByIndex(2);

        Select sc2=new Select(driver.findElement(By.name("alert_trigger")));
        sc2.selectByIndex(2);

        Select sc3=new Select(driver.findElement(By.name("format")));
        sc3.selectByIndex(1);

    }
    }
