package i_can_win;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinHomePage {

    private static final String PAGE_URL = "https://pastebin.com";
    private static final int WAIT_TIMEOUT_SECONDS = 10;
    private final WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement pasteText;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationMenu;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createButton;

    public PasteBinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public void createPaste(String text, String expiration, String name) {
        pasteText.sendKeys(text);
        expirationMenu.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .xpath("//*[@id=\"select2-postform-expiration-results\"]/li[text()='" + expiration + "']"))).click();
        pasteName.sendKeys(name);
        createButton.click();
    }
}
