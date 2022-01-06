package hurt_me_plenty.test;

import hurt_me_plenty.model.CalculatorData;
import hurt_me_plenty.page.GoogleCloudCalculatorPage;
import hurt_me_plenty.page.GoogleCloudPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleCloudCalculatorTests {

    private WebDriver driver;
    private static final String MANUAL_TEST_TOTAL_ESTIMATE = "1,841.97";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void vmClassTest() {
        CalculatorData data = new CalculatorData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String vmClass = calculatorPage.getVMClass().toLowerCase();
        Assert.assertEquals(data.getMachineClass().toLowerCase(), vmClass);
    }

    @Test
    public void instanceTypeTest() {
        CalculatorData data = new CalculatorData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String instanceType = calculatorPage.getInstanceType().toLowerCase();
        Assert.assertTrue(instanceType.contains("n1-standard-8"));
    }

    @Test
    public void regionTest() {
        CalculatorData data = new CalculatorData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String region = calculatorPage.getRegion();
        Assert.assertEquals(data.getLocation(), region);

    }

    @Test
    public void localSSDTest() {
        CalculatorData data = new CalculatorData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String localSSD = calculatorPage.getLocalSSD();
        Assert.assertEquals(data.getSsd(), localSSD);
    }

    @Test
    public void commitmentTermTest() {
        CalculatorData data = new CalculatorData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String commitmentTerm = calculatorPage.getCommitmentTerm();
        Assert.assertEquals(data.getCommittedUsage(), commitmentTerm);
    }

    @Test
    public void totalEstimateMatchesWithManualTestTotalEstimate() {
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(new CalculatorData());
        String totalEstimate = calculatorPage.getTotalEstimate();
        Assert.assertEquals(MANUAL_TEST_TOTAL_ESTIMATE, totalEstimate);

    }

    @AfterMethod(alwaysRun = true)
    public void browserStop() {
        driver.quit();
        driver = null;
    }
}
