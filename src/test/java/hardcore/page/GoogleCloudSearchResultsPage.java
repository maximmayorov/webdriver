package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudSearchResultsPage extends AbstractPage{

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudCalculatorPage openCalculatorPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='gs-title']/a/b[text()='Google Cloud Platform Pricing Calculator']"))).click();
        return new GoogleCloudCalculatorPage(driver);
    }
}
