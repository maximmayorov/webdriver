package i_can_win;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Runner {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        PasteBinHomePage pastebin = new PasteBinHomePage(driver);
        pastebin.openPage().createPaste("Hello from WebDriver", "10 Minutes", "helloweb");
        driver.quit();
    }
}
