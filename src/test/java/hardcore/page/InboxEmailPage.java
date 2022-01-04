package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class InboxEmailPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='bname']")
    private WebElement email;

    public InboxEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTotalEstimate() {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS / 5))
                .ignoring(NoSuchElementException.class);
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        WebElement totalEstimate = fluentWait.until(driver -> {
            driver.navigate().refresh();
            driver.switchTo().frame(driver.findElement(By.id("ifmail")));
            return  driver.findElement(By.xpath("//*[text()='Total Estimated Monthly Cost']/../../td[2]/h3"));
        });
        return totalEstimate.getText();
    }

    public String getEmail() {
        return email.getText();
    }
}
