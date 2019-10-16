package main;

public final class TempSummaryStatistics {
    public double avgTemp, devTemp, minTemp, maxTemp;
    public TempSummaryStatistics(double avgTemp1, double devTemp1,
                                 double minTemp1, double maxTemp1) {
        avgTemp = avgTemp1;
        devTemp = devTemp1;
        maxTemp = maxTemp1;
        minTemp = minTemp1;
    }
}
