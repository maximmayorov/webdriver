package bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatedPasteBinPage extends AbstractPage {

    private static final String SYNTAX_HIGHLIGHTING_XPATH = "//*[@class='left']/a";

    @FindBy(className = "textarea")
    private WebElement pasteText;

    public CreatedPasteBinPage(WebDriver driver) {
        super(driver);
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    public String pasteText() {
        wait.until(driver -> !pasteText.getText().isEmpty());
        return pasteText.getText();
    }

    public String syntaxHighlightingLanguage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SYNTAX_HIGHLIGHTING_XPATH))).getText();
    }
}
