package launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchBox2 {

    public static void main(String[] args) throws Exception {
        WebDriver driver1;

        WebDriverManager.chromedriver().setup();

        driver1 = new ChromeDriver();
        driver1.get("https://www.google.com/");

        driver1.findElement(By.name("q")).click();
               // .sendKeys("Java");

        Thread.sleep(3000);
        driver1.close();
    }
}
