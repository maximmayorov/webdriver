package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GoogleCloudCalculatorPage extends AbstractPage {

    private static final String TOTAL_ESTIMATE_XPATH = "//h2/b";
    private static final String EMAIL_ESTIMATE_BUTTON_XPATH = "email_quote";
    private static final String EMAIL_INPUT_XPATH = "//input[@ng-model='emailQuote.user.email']";
    private static final String SEND_EMAIL_BUTTON_XPATH = "//button[@aria-label='Send Email']";
    private static final String GPU_TYPE_DROPDOWN_MENU_XPATH =
            "//md-select[@ng-model='listingCtrl.computeServer.gpuType']";
    private static final String GPU_NUMBER_DROPDOWN_MENU_XPATH =
            "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']";
    private static final String SSD_DROPDOWN_MENU_XPATH =
            "//md-select[@ng-model='listingCtrl.computeServer.ssd']";
    private static final String OS_DROPDOWN_OPTION_XPATH =
            "//div[@class='md-select-menu-container md-active md-clickable']" +
                    "/md-select-menu/md-content/md-option/div[@class='md-text']";
    private static final String VM_CLASS_DROPDOWN_OPTION_XPATH =
            "//div[@class='md-select-menu-container md-active md-clickable']" +
                    "/md-select-menu/md-content/md-option/div[@class='md-text']";
    private static final String SERIES_DROPDOWN_OPTION_XPATH =
            "//div[@class='md-select-menu-container md-active md-clickable']" +
                    "/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
    private static final String INSTANCE_TYPE_DROPDOWN_OPTION_XPATH =
            "//div[@class='md-select-menu-container md-active md-clickable']" +
                    "/md-select-menu/md-content/md-optgroup/md-option/div[@class='md-text ng-binding']";
    private static final String GPU_TYPE_DROPDOWN_OPTION_XPATH =
            "//div[@class='md-select-menu-container md-active md-clickable']" +
                    "/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";
    private static final String GPU_NUMBER_DROPDOWN_OPTION_XPATH =
            "//div[@class='md-select-menu-container md-active md-clickable']" +
                    "/md-select-menu/md-content/md-option/div";
    private static final String SSD_DROPDOWN_OPTION_XPATH =
            "//div[@class='md-select-menu-container md-active md-clickable']" +
                    "/md-select-menu/md-content/md-option/div";
    private static final String LOCATION_DROPDOWN_OPTION_XPATH =
            "//div[@class='md-select-menu-container cpc-region-select md-active md-clickable']" +
                    "/md-select-menu/md-content/md-optgroup/md-option/div";
    private static final String USAGE_DROPDOWN_OPTION_XPATH =
            "//div[@class='md-select-menu-container md-active md-clickable']" +
                    "/md-select-menu/md-content/md-option/div[@class='md-text']";

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement firstFrame;

    @FindBy(id = "myFrame")
    private WebElement secondFrame;

    @FindBy(xpath = "//div[@class='tab-holder compute']/div[1]/div[1]/div[1]/div[1]")
    private WebElement tabComputeEngine;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstance;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystem;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement machineClass;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    private WebElement series;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement instanceType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsButton;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement location;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsage;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void switchToCalculatorFrame() {
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
    }

    private void selectFromDropDownMenu(By by, String item) {
        List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        for (WebElement element: elementList) {
            if (element.getText().equals(item)) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                return;
            }
        }
        throw new NoSuchElementException("The dropdown menu doesn't contain the option " + item);
    }

    public void selectTabComputeEngine() {
        tabComputeEngine.click();
    }

    public void setNumberOfInstance(String number) {
        numberOfInstance.sendKeys(number);
    }

    public void selectOS(String os) {
        operatingSystem.click();
        selectFromDropDownMenu(By.xpath(OS_DROPDOWN_OPTION_XPATH), os);
    }

    public void selectVMClass(String vmClass) {
        machineClass.click();
        selectFromDropDownMenu(By.xpath(VM_CLASS_DROPDOWN_OPTION_XPATH), vmClass);
    }

    public void selectMachineSeries(String machineSeries) {
        series.click();
        selectFromDropDownMenu(By.xpath(SERIES_DROPDOWN_OPTION_XPATH), machineSeries);
    }

    public void selectInstanceType(String type) {
        instanceType.click();
        selectFromDropDownMenu(By.xpath(INSTANCE_TYPE_DROPDOWN_OPTION_XPATH), type);
    }

    public void setAddGPUsCheckBox() {
        addGPUsButton.click();
    }

    public void selectGPUType(String gpuType) {
        waitForElement(By.xpath(GPU_TYPE_DROPDOWN_MENU_XPATH)).click();
        selectFromDropDownMenu(By.xpath(GPU_TYPE_DROPDOWN_OPTION_XPATH), gpuType);
    }

    public void selectNumberOfGPUs(String number) {
        waitForElement(By.xpath(GPU_NUMBER_DROPDOWN_MENU_XPATH)).click();
        selectFromDropDownMenu(By.xpath(GPU_NUMBER_DROPDOWN_OPTION_XPATH), number);
    }

    public void selectSSDSize(String ssdSize) {
        waitForElement(By.xpath(SSD_DROPDOWN_MENU_XPATH)).click();
        selectFromDropDownMenu(By.xpath(SSD_DROPDOWN_OPTION_XPATH), ssdSize);
    }

    public void selectLocation(String machineLocation) {
        location.click();
        selectFromDropDownMenu(By.xpath(LOCATION_DROPDOWN_OPTION_XPATH), machineLocation);
    }

    public void selectCommittedUsage(String usage) {
        committedUsage.click();
        selectFromDropDownMenu(By.xpath(USAGE_DROPDOWN_OPTION_XPATH), usage);
    }

    public void addConfigurationToEstimate() {
        addToEstimateButton.click();
    }

    public void sendEmail(String email) {
        waitForElement(By.id(EMAIL_ESTIMATE_BUTTON_XPATH)).click();
        waitForElement(By.xpath(EMAIL_INPUT_XPATH)).sendKeys(email);
        waitForElement(By.xpath(SEND_EMAIL_BUTTON_XPATH)).click();
    }

    public String getTotalEstimate() {
        return waitForElement(By.xpath(TOTAL_ESTIMATE_XPATH)).getText();
    }

    private WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
