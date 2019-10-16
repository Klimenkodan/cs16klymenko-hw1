package ua.edu.ucu.tempseries;

public final class TempSummaryStatistics {
    
    private double avgTemp, devTemp, minTemp, maxTemp;
    
    public TempSummaryStatistics(double avTemp, double deTemp,
                                 double miTemp, double maTemp) {
        avgTemp = avTemp;
        devTemp = deTemp;
        maxTemp = maTemp;
        minTemp = miTemp;
    }
    
    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}

