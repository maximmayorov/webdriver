package hurt_me_plenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }
}
