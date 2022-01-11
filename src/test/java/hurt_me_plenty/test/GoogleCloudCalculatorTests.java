package hurt_me_plenty.test;

import hurt_me_plenty.model.CalculatorData;
import hurt_me_plenty.page.GoogleCloudCalculatorPage;
import hurt_me_plenty.page.GoogleCloudPage;
import hurt_me_plenty.util.CalculatorDataCreator;
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
        CalculatorData data = CalculatorDataCreator.createDefaultData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String vmClass = calculatorPage.getVMClass().toLowerCase();
        Assert.assertTrue(vmClass.contains(data.getVmClass().toLowerCase()));
    }

    @Test
    public void instanceTypeTest() {
        CalculatorData data = CalculatorDataCreator.createDefaultData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String instanceType = calculatorPage.getInstanceType().toLowerCase();
        Assert.assertTrue(instanceType.contains(data.getInstanceType().toLowerCase()));
    }

    @Test
    public void regionTest() {
        CalculatorData data = CalculatorDataCreator.createDefaultData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String region = calculatorPage.getRegion().toLowerCase();
        Assert.assertTrue(region.contains(data.getLocation().toLowerCase()));
    }

    @Test
    public void localSSDTest() {
        CalculatorData data = CalculatorDataCreator.createDefaultData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String localSSD = calculatorPage.getLocalSSD().toLowerCase();
        Assert.assertTrue(localSSD.contains(data.getSsd().toLowerCase()));
    }

    @Test
    public void commitmentTermTest() {
        CalculatorData data = CalculatorDataCreator.createDefaultData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String commitmentTerm = calculatorPage.getCommitmentTerm().toLowerCase();
        Assert.assertTrue(commitmentTerm.contains(data.getCommittedUsage().toLowerCase()));
    }

    @Test
    public void totalEstimateMatchesWithManualTestTotalEstimate() {
        CalculatorData data = CalculatorDataCreator.createDefaultData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(data);
        String totalEstimate = calculatorPage.getTotalEstimate();
        Assert.assertTrue(totalEstimate.contains(MANUAL_TEST_TOTAL_ESTIMATE));
    }

    @AfterMethod(alwaysRun = true)
    public void browserStop() {
        driver.quit();
        driver = null;
    }
}
