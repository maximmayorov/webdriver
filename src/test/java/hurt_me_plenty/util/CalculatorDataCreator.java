package hurt_me_plenty.util;

import hurt_me_plenty.model.CalculatorData;

public class CalculatorDataCreator {

    public static CalculatorData createDefaultData() {
        return new CalculatorData("4",
                "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)",
                "Regular",
                "N1",
                "n1-standard-8 (vCPUs: 8, RAM: 30GB)",
                "NVIDIA Tesla T4",
                "1",
                "2x375 GB",
                "Frankfurt (europe-west3)",
                "1 Year");
    }

    public static CalculatorData createEmptyData() {
        return new CalculatorData();
    }
}
