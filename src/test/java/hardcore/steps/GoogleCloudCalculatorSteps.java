package hardcore.steps;

import hardcore.model.CalculatorData;
import hardcore.page.EmailServicePage;
import hardcore.page.GoogleCloudCalculatorPage;
import hardcore.page.InboxEmailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class GoogleCloudCalculatorSteps {

    private final WebDriver driver;
    private final GoogleCloudCalculatorPage calculatorPage;

    public GoogleCloudCalculatorSteps(WebDriver driver, GoogleCloudCalculatorPage calculatorPage) {
        this.driver = driver;
        this.calculatorPage = calculatorPage;
    }

    public void addToEstimate(CalculatorData data) {
        calculatorPage.switchToCalculatorFrame();
        calculatorPage.selectTabComputeEngine();
        calculatorPage.setNumberOfInstance(data.getInstances());
        calculatorPage.selectOS(data.getOs());
        calculatorPage.selectVMClass(data.getVmClass());
        calculatorPage.selectMachineSeries(data.getSeries());
        calculatorPage.selectInstanceType(data.getInstanceType());
        calculatorPage.setAddGPUsCheckBox();
        calculatorPage.selectGPUType(data.getGpuType());
        calculatorPage.selectNumberOfGPUs(data.getNumberOfGPUs());
        calculatorPage.selectSSDSize(data.getSsd());
        calculatorPage.selectLocation(data.getLocation());
        calculatorPage.selectCommittedUsage(data.getCommittedUsage());
        calculatorPage.addConfigurationToEstimate();
    }

    public String getTotalEstimateFromEmail() {
        String calculatorPageHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        InboxEmailPage inboxEmailPage = new EmailServicePage(driver)
                .openPage()
                .createRandomEmail()
                .openInboxEmailPage();
        String email = inboxEmailPage.getEmail();
        String emailPage = driver.getWindowHandle();
        driver.switchTo().window(calculatorPageHandle);
        calculatorPage.switchToCalculatorFrame();
        calculatorPage.sendEmail(email);
        driver.switchTo().window(emailPage);
        return inboxEmailPage.getTotalEstimate();
    }
}
