package launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class google {

    public static void main(String[] args) throws Exception {
        //Interface reference variable;
        WebDriver driver;

        //webdrivermanager is a lib to interact to the browsers
        WebDriverManager.edgedriver().setup();
        //Created object to implementation class
        //classname objectname=new classname();
         driver=new EdgeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.close();

    }
}
