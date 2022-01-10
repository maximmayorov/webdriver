package hurt_me_plenty.model;

import java.util.Objects;

public class CalculatorData {

    private String instances = "4";
    private String os = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    private String machineClass = "Regular";
    private String series = "N1";
    private String machineType = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private String gpuType = "NVIDIA Tesla T4";
    private String numberOfGPUs = "1";
    private String ssd = "2x375 GB";
    private String location = "Frankfurt (europe-west3)";
    private String committedUsage = "1 Year";

    public CalculatorData() {

    }

    public CalculatorData(String instances, String os, String machineClass, String series, String machineType, String gpuType, String numberOfGPUs, String ssd, String location, String committedUsage) {
        this.instances = instances;
        this.os = os;
        this.machineClass = machineClass;
        this.series = series;
        this.machineType = machineType;
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

    public String getMachineClass() {
        return machineClass;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
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

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
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
                ", machineClass='" + machineClass + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
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
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(series, that.series) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(ssd, that.ssd) &&
                Objects.equals(location, that.location) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instances, os, machineClass, series, machineType, gpuType, numberOfGPUs, ssd, location, committedUsage);
    }
}
