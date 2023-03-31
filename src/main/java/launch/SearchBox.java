package launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SearchBox {
    public static void main(String[] args) throws InterruptedException {
        //Interface reference variable;
        //Webdriver is an interface. which contains only abstarct methods. we can not create object to interface
        //with help of implementation classes we can use the abstract methods
        WebDriver driver;

        //webdrivermanager is a lib to interact to the browsers
        WebDriverManager.edgedriver().setup();
        //Created object to implementation class
        //classname objectname=new classname();
        driver=new EdgeDriver();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Selenium");

        //Indentify the google search box

        Thread.sleep(3000);
        driver.close();
    }
}
