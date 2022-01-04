package bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PasteBinHomePage extends AbstractPage{

    private static final String PAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement pasteText;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement createButton;

    public PasteBinHomePage(WebDriver driver) {
        super(driver);
    }

    public PasteBinHomePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public CreatedPasteBinPage createPaste(String text, String syntaxHighlighting, String expiration, String name) {
        pasteText.sendKeys(text);
        selectDropDownMenuOption(
                By.id("select2-postform-expiration-container"),
                By.xpath("//*[@id=\"select2-postform-expiration-results\"]//li"),
                expiration);
        selectDropDownMenuOption(
                By.id("select2-postform-format-container"),
                By.xpath("//*[@id=\"select2-postform-format-results\"]/li[3]/ul/li"),
                syntaxHighlighting);
        pasteName.sendKeys(name);
        createButton.click();
        return new CreatedPasteBinPage(driver);
    }

    private void selectDropDownMenuOption(By container, By optionMenu, String optionName) {
        WebElement optionsContainer = driver.findElement(container);
        optionsContainer.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionMenu));

        if (options.stream().noneMatch((o) -> o.getText().equals(optionName))) {
            System.out.println("No option: " + optionName);
        }

        for (WebElement option: options) {
            if (option.getText().equals(optionName)) {
                option.click();
                break;
            }
        }
    }

}
