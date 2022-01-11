package hardcore.model;

import java.util.Objects;

public class CalculatorData {

    private String instances;
    private String os;
    private String vmClass;
    private String series;
    private String InstanceType;
    private String gpuType;
    private String numberOfGPUs;
    private String ssd;
    private String location;
    private String committedUsage;

    public CalculatorData() {

    }

    public CalculatorData(String instances, String os, String vmClass, String series, String InstanceType, String gpuType, String numberOfGPUs, String ssd, String location, String committedUsage) {
        this.instances = instances;
        this.os = os;
        this.vmClass = vmClass;
        this.series = series;
        this.InstanceType = InstanceType;
        this.gpuType = gpuType;
        this.numberOfGPUs = numberOfGPUs;
        this.ssd = ssd;
        this.location = location;
        this.committedUsage = committedUsage;
    }

    public String getInstances() {
        return instances;
    }

    public String getOs() {
        return os;
    }

    public String getVmClass() {
        return vmClass;
    }

    public String getSeries() {
        return series;
    }

    public String getInstanceType() {
        return InstanceType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getSsd() {
        return ssd;
    }

    public String getLocation() {
        return location;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setInstances(String instances) {
        this.instances = instances;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setInstanceType(String instanceType) {
        this.InstanceType = instanceType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "CalculatorData{" +
                "instances='" + instances + '\'' +
                ", os='" + os + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", series='" + series + '\'' +
                ", InstanceType='" + InstanceType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", ssd='" + ssd + '\'' +
                ", location='" + location + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorData that = (CalculatorData) o;
        return Objects.equals(instances, that.instances) &&
                Objects.equals(os, that.os) &&
                Objects.equals(vmClass, that.vmClass) &&
                Objects.equals(series, that.series) &&
                Objects.equals(InstanceType, that.InstanceType) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(ssd, that.ssd) &&
                Objects.equals(location, that.location) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instances, os, vmClass, series, InstanceType, gpuType, numberOfGPUs, ssd, location, committedUsage);
    }
}
