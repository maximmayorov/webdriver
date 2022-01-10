package hurt_me_plenty.page;

import hurt_me_plenty.model.CalculatorData;
import org.openqa.selenium.By;
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

    private void selectFromDropDownMenu(By by, String data) {
        List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        for (WebElement element: elementList) {
            if (element.getText().equals(data)) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }
        }
    }

    public GoogleCloudCalculatorPage addToEstimate(CalculatorData data) {
        tabComputeEngine.click();
        numberOfInstance.sendKeys(data.getInstances());
        operatingSystem.click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div[@class='md-text']"), data.getOs());
        machineClass.click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div[@class='md-text']"), data.getMachineClass());
        series.click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div[@class='md-text ng-binding']"), data.getSeries());
        machineType.click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart +"md-optgroup/md-option/div[@class='md-text ng-binding']"), data.getMachineType());

        addGPUsButton.click();
        waitForElement(By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuType']")).click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div[@class='md-text ng-binding']"), data.getGpuType());
        waitForElement(By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")).click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div"), data.getNumberOfGPUs());

        waitForElement(By.xpath("//md-select[@ng-model='listingCtrl.computeServer.ssd']")).click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div"), data.getSsd());
        location.click();
        selectFromDropDownMenu(By.xpath("//div[@class='md-select-menu-container cpc-region-select md-active md-clickable']/md-select-menu/md-content/md-optgroup/md-option/div"), data.getLocation());
        committedUsage.click();
        selectFromDropDownMenu(By.xpath(commonLocatorPart + "md-option/div[@class='md-text']"), data.getCommittedUsage());
        addToEstimateButton.click();
        return this;
    }

    public String getTotalEstimate() {
        return waitForElement(By.xpath("//h2[@class='md-title']/b[@class='ng-binding']")).getText();
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
