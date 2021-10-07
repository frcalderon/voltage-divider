package com.company;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        SeriesCatalog seriesCatalog = new SeriesCatalog();

        // Input for voltage divider calculation
        double k = 0.5;
        String name = "E24";
        double coincidence = 90.; // Percentual
        Series series = seriesCatalog.findSeriesByName(name);
        long startTime1 = System.nanoTime();
        List<VoltageDivider> result = VoltageDividerCalculation.calculate(k, coincidence, series);
        long elapsedTime1 = System.nanoTime() - startTime1;
        for (VoltageDivider vd : result) {
            System.out.println(vd); // Thanks to toString()
        }

        // Optimized calculation
        System.out.println("Optimized calculation");
        long startTime2 = System.nanoTime();
        result = VoltageDividerCalculation.calculateOptimized(k, coincidence, series);
        long elapsedTime2 = System.nanoTime() - startTime2;
        for (VoltageDivider vd : result) {
            System.out.println(vd); // Thanks to toString()
        }

        System.out.println("-------------------------------");
        System.out.println("Regular calculation elapsed time: " + TimeUnit.MILLISECONDS.convert(elapsedTime1, TimeUnit.NANOSECONDS) + " ms.");
        System.out.println("Optimized calculation elapsed time: " + TimeUnit.MILLISECONDS.convert(elapsedTime2, TimeUnit.NANOSECONDS) + " ms.");
        System.out.println("------------------------------- \n");
    }
}
