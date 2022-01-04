package hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudPage extends AbstractPage {

    private static final String PAGE_URL = "https://cloud.google.com/";

    @FindBy(name = "q")
    private WebElement searchInput;

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public GoogleCloudSearchResultsPage findCalculatorPage() {
        searchInput.click();
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']"))).click();
        return new GoogleCloudSearchResultsPage(driver);
    }
}
