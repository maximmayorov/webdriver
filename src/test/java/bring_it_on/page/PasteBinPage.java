package bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinPage extends AbstractPage{

    private static final String PAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement pasteText;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationMenu;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingMenu;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement createButton;

    public PasteBinPage(WebDriver driver) {
        super(driver);
    }

    public PasteBinPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public CreatedPasteBinPage createPaste(String text, String syntaxHighlighting, String expiration, String name) {
        pasteText.sendKeys(text);
        expirationMenu.click();
        waitForElement(By.xpath("//*[@id=\"select2-postform-expiration-results\"]/li[text()='" + expiration + "']")).click();
        syntaxHighlightingMenu.click();
        waitForElement(By.xpath("//*[@id=\"select2-postform-format-results\"]/li/ul/li[text()='" + syntaxHighlighting + "']")).click();
        pasteName.sendKeys(name);
        createButton.click();
        return new CreatedPasteBinPage(driver);
    }

    private WebElement waitForElement(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
