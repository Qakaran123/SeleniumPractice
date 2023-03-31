package launch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickGmail2 {
    public static void main(String[] args) throws Exception {
        WebDriver driver2;

        WebDriverManager.chromedriver().setup();

        driver2 = new ChromeDriver();
        driver2.get("https://www.youtube.com/");

        driver2.findElement(By.linkText("Images")).click();

        Thread.sleep(3000);
        driver2.close();
    }
}
