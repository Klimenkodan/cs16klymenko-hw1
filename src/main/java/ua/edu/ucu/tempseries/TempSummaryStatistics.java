package ua.edu.ucu.tempseries;

public final class TempSummaryStatistics {
    
    public double avgTemp, devTemp, minTemp, maxTemp;
    
    public TempSummaryStatistics(double avgTemp1, double devTemp1,
                                 double minTemp1, double maxTemp1) {
        avgTemp = avgTemp1;
        devTemp = devTemp1;
        maxTemp = maxTemp1;
        minTemp = minTemp1;
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

