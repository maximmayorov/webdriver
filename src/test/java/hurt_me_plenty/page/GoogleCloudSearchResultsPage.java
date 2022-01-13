package hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudSearchResultsPage extends AbstractPage{

    private static final String CALCULATOR_LINK_XPATH = "//div[@class='gs-title']/a/b[text()='Google Cloud Platform Pricing Calculator']";

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudCalculatorPage openCalculatorPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CALCULATOR_LINK_XPATH))).click();
        return new GoogleCloudCalculatorPage(driver);
    }
}
