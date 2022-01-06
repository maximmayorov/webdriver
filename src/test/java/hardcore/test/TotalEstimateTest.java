package hardcore.test;

import hardcore.model.CalculatorData;
import hardcore.page.GoogleCloudCalculatorPage;
import hardcore.page.GoogleCloudPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TotalEstimateTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void totalEstimateInEmailTest() {
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(new CalculatorData());
        String calculatorTotalEstimate = calculatorPage.getTotalEstimate();
        String emailTotalEstimate = calculatorPage.getTotalEstimateFromEmail();
        Assert.assertEquals(emailTotalEstimate, calculatorTotalEstimate);
    }

    @AfterMethod(alwaysRun = true)
    public void browserStop() {
        driver.quit();
        driver = null;
    }
}
