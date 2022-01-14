package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RandomEmailGeneratorPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='nw']/button[2]")
    private WebElement checkInboxButton;

    public RandomEmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public InboxEmailPage openInboxEmailPage() {
        checkInboxButton.click();
        return new InboxEmailPage(driver);
    }
}
