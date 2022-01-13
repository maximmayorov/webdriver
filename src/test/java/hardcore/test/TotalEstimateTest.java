package hardcore.test;

import hardcore.model.CalculatorData;
import hardcore.page.GoogleCloudCalculatorPage;
import hardcore.page.GoogleCloudPage;
import hardcore.steps.GoogleCloudCalculatorSteps;
import hardcore.util.CalculatorDataCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TotalEstimateTest {

    private WebDriver driver;
    private static final String CALCULATOR_SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void totalEstimateInEmailTest() {
        CalculatorData data = CalculatorDataCreator.createDefaultData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage(CALCULATOR_SEARCH_QUERY)
                .openCalculatorPage();
        GoogleCloudCalculatorSteps googleCloudCalculatorSteps = new GoogleCloudCalculatorSteps(driver, calculatorPage);
        googleCloudCalculatorSteps.addToEstimate(data);
        String calculatorTotalEstimate = calculatorPage.getTotalEstimate();
        String emailTotalEstimate = googleCloudCalculatorSteps.getTotalEstimateFromEmail();
        Assert.assertTrue(calculatorTotalEstimate.contains(emailTotalEstimate));
    }

    @AfterMethod(alwaysRun = true)
    public void browserStop() {
        driver.quit();
        driver = null;
    }
}
