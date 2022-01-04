package bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatedPasteBinPage extends AbstractPage {

    @FindBy(className = "textarea")
    private WebElement pasteText;

    public CreatedPasteBinPage(WebDriver driver) {
        super(driver);
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    public String pasteText() {
        wait.until(driver -> !pasteText.getText().equals(""));
        return pasteText.getText();
    }

    public String syntaxHighlightingLanguage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='left']/a"))).getText();
    }
}
