package hurt_me_plenty.steps;

import hurt_me_plenty.model.CalculatorData;
import hurt_me_plenty.page.GoogleCloudCalculatorPage;

public class GoogleCloudCalculatorSteps {

    private final GoogleCloudCalculatorPage calculatorPage;

    public GoogleCloudCalculatorSteps(GoogleCloudCalculatorPage calculatorPage) {
        this.calculatorPage = calculatorPage;
    }

    public void addToEstimate(CalculatorData data) {
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
}
