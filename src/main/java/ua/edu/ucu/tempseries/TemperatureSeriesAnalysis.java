package ua.edu.ucu.tempseries;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] x;
    public static final double lowest = -273;

    public TemperatureSeriesAnalysis() {
        this.x = new double[] {};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < lowest) {
                throw new InputMismatchException();
            }
        }
        this.x = temperatureSeries;

    }

    public double average() {
        checkIfEmpty();
        double sum = 0;
        for (int i = 0; i < this.x.length; i++) {
            sum += this.x[i];
        }
        return sum / this.x.length;
    }

    public double deviation() {
        checkIfEmpty();
        double average = this.average();
        double sum = 0;
        for (int i = 0; i < this.x.length; i++) {
            sum += (average - this.x[i]) * (average - this.x[i]);
        }
        return Math.sqrt(sum / this.x.length);

    }

    public double min() {
        checkIfEmpty();
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < this.x.length; i++) {
            if (this.x[i] < min) {
                min = this.x[i];
            }
        }

        return min;
    }

    public double max() {
        checkIfEmpty();
        double max = Double.POSITIVE_INFINITY;
        max = max * (-1);
        for (int i = 0; i < this.x.length; i++) {
            if (this.x[i] > max) {
                max = this.x[i];
            }
        }

        return max;
    }

    public double findTempClosestToZero() {
        checkIfEmpty();
        return findTempClosestToValue(0);
    }

    private void checkIfEmpty() {
        if (this.x.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double findTempClosestToValue(double tempValue) {
        checkIfEmpty();
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < this.x.length; i++) {
            if (Math.abs(tempValue - min) > Math.abs(tempValue - this.x[i])) {
                min = this.x[i];
            }
            else if (Math.abs(tempValue - min) == Math.abs(tempValue 
                                                           - this.x[i])) {
                min = Math.max(min, tempValue);
            }
        }
        return min;
    }

    public double[] findTempsLessThen(double tempValue) {
        checkIfEmpty();
        double[] less = new double[this.x.length - 1];
        int ind = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] < tempValue) {
                less[ind] = x[i];
                ind += 1;
            }
        }
        for (int i = 0; i < less.length; i++) {
            System.out.println(less[i]);

        }
        return less;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        checkIfEmpty();
        double[] less = new double[this.x.length - 1];
        int ind = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > tempValue) {
                less[ind] = x[i];
                ind += 1;
            }
        }
        return less;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(this.average(), this.deviation(),
                                         this.min(), this.max());
    }

    public int addTemps(double... temps) {
        int len = x.length;
        double[] array = new double[(len + 1)* 2];
        for (int k = 0; k < len; k++) {
            array[k] = x[k];
        }

        for (int i = 0; i < temps.length; i++) {
            array[len + i] = temps[i];
        }
        this.x = array;
        return len + temps.length;
    }
}
