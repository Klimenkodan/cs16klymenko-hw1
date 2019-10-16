package ua.edu.ucu.tempseries;

import org.junit.Assert;

import static org.junit.Assert.*;

public class TemperatureSeriesAnalysisTest {
    TemperatureSeriesAnalysis temps = new TemperatureSeriesAnalysis();
    TemperatureSeriesAnalysis temps1 = new TemperatureSeriesAnalysis(new double[]{-1, 4, 8, 4, 12, 98, 54, 23, -6, -3, 12});
    TempSummaryStatistics sum = temps1.summaryStatistics();

    @org.junit.Test
    public void average() {
        try
        {
            TemperatureSeriesAnalysis temps2 = new TemperatureSeriesAnalysis(new double[]{-273, 12, -3456, 67, 23, 9});

        } catch (Exception InputMismatchException){

        }
        Assert.assertEquals(18.636, temps1.average(), 0.005);

    }

    @org.junit.Test
    public void deviation() {
        Assert.assertEquals(29.6319, temps1.deviation(), 0.005);
    }

    @org.junit.Test
    public void min() {
        try {
            Assert.assertEquals(-6, temps.min(), 0);
        }
        catch (Exception IllegalArgumentException){

        }
        Assert.assertEquals(-6, temps1.min(), 0);
    }

    @org.junit.Test
    public void max() {
        Assert.assertEquals(98, temps1.max(), 0);
    }

    @org.junit.Test
    public void findTempClosestToZero() {
        Assert.assertEquals(-1, temps1.findTempClosestToZero(), 0);
    }

    @org.junit.Test
    public void findTempClosestToValue() {
        Assert.assertEquals(2, new TemperatureSeriesAnalysis(new double[]{3, 4, 2, -2, 8}).findTempClosestToValue(0), 0);
        Assert.assertEquals(98, temps1.findTempClosestToValue(1235), 0);

    }

    @org.junit.Test
    public void findTempsLessThen() {
        Assert.assertArrayEquals(new double[]{-1, -6, -3, 0, 0, 0, 0, 0, 0, 0}, temps1.findTempsLessThen(4), 0);
    }

    @org.junit.Test
    public void findTempsGreaterThen() {
        Assert.assertArrayEquals(new double[]{98, 54, 23, 0, 0, 0, 0, 0, 0, 0}, temps1.findTempsGreaterThen(20), 0);
    }

    @org.junit.Test
    public void summaryStatistics() {
        TempSummaryStatistics stat = new TempSummaryStatistics(temps1.average(), temps1.deviation(), temps1.min(), temps1.max());
        Assert.assertEquals(stat.avgTemp, temps1.average(), 0.05);
        Assert.assertEquals(stat.devTemp, temps1.deviation(), 0.05);
        Assert.assertEquals(stat.minTemp, temps1.min(), 0.05);
        Assert.assertEquals(stat.maxTemp, temps1.max(), 0.05);
    }

    @org.junit.Test
    public void addTemps() {
        Assert.assertEquals(15, temps1.addTemps(3, 6, 1, 9));
    }
}
