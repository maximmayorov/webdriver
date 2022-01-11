package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailServicePage extends AbstractPage {

    private static final String PAGE_URL = "https://yopmail.com/";

    @FindBy(xpath = "//*[@id='listeliens']/a[1]")
    private WebElement randomEmailButton;

    public EmailServicePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EmailServicePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public RandomEmailGeneratorPage createRandomEmail() {
        randomEmailButton.click();
        return new RandomEmailGeneratorPage(driver);
    }
}
