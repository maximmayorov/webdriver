package hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GoogleCloudCalculatorPage extends AbstractPage {

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
    private WebElement machineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsButton;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement location;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsage;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    private static final String commonLocatorPart = "//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/";

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
        selectFromDropDownMenu(By.
                xpath(commonLocatorPart + "md-option/div[@class='md-text']"), os);
    }

    public void selectVMClass(String vmClass) {
        machineClass.click();
        selectFromDropDownMenu(By.
                xpath(commonLocatorPart + "md-option/div[@class='md-text']"), vmClass);
    }

    public void selectMachineSeries(String machineSeries) {
        series.click();
        selectFromDropDownMenu(By.
                xpath(commonLocatorPart + "md-option/div[@class='md-text ng-binding']"), machineSeries);
    }

    public void selectInstanceType(String instanceType) {
        machineType.click();
        selectFromDropDownMenu(By.
                xpath(commonLocatorPart +"md-optgroup/md-option/div[@class='md-text ng-binding']"), instanceType);
    }

    public void setAddGPUsCheckBox() {
        addGPUsButton.click();
    }

    public void selectGPUType(String gpuType) {
        waitForElement(By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuType']")).click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div[@class='md-text ng-binding']"), gpuType);
    }

    public void selectNumberOfGPUs(String number) {
        waitForElement(By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")).click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div"), number);
    }

    public void selectSSDSize(String ssdSize) {
        waitForElement(By.xpath("//md-select[@ng-model='listingCtrl.computeServer.ssd']")).click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div"), ssdSize);
    }

    public void selectLocation(String machineLocation) {
        location.click();
        selectFromDropDownMenu(By.
                xpath("//div[@class='md-select-menu-container cpc-region-select md-active md-clickable'] " +
                        "/md-select-menu/md-content/md-optgroup/md-option/div"), machineLocation);
    }

    public void selectCommittedUsage(String usage) {
        committedUsage.click();
        selectFromDropDownMenu(By.
                xpath(commonLocatorPart + "md-option/div[@class='md-text']"), usage);
    }

    public void addConfigurationToEstimate() {
        addToEstimateButton.click();
    }

    public String getTotalEstimate() {
        return waitForElement(By.xpath("//h2/b")).getText();
    }

    public String getVMClass() {
        return waitForElement(By.xpath("//*[@id='compute']/md-list/md-list-item[4]/div")).getText();
    }

    public String getInstanceType() {
        return waitForElement(By.xpath("//*[@id='compute']/md-list/md-list-item[5]/div[1]")).getText();
    }

    public String getLocalSSD() {
        return waitForElement(By.xpath("//*[@id='compute']/md-list/md-list-item[8]/div[1]")).getText();
    }

    public String getRegion() {
        return waitForElement(By.xpath("//*[@id='compute']/md-list/md-list-item[1]/div")).getText();
    }

    public String getCommitmentTerm() {
        return waitForElement(By.xpath("//*[@id='compute']/md-list/md-list-item[3]/div")).getText();
    }

    private WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
