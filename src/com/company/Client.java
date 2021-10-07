package com.company;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        SeriesCatalog seriesCatalog = new SeriesCatalog();
        // input for voltage divider calculation
        double k = 0.5;
        String name = "E6";
        double coincidence = 80.; // percentual
        Series series = seriesCatalog.findSeriesByName(name);
        long startTime = System.nanoTime();
        List<VoltageDivider> result = VoltageDividerCalculation.calculate(k, coincidence, series);
        long elapsedTime = System.nanoTime() - startTime;
        for (VoltageDivider vd : result) {
            System.out.println(vd); // thanks to toString()
        }
        System.out.println("-------------------------------");
        System.out.println("Calculation elapsed time: " + TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " ms.");
        System.out.println("------------------------------- \n");

        //Optimized calculation
        System.out.println("Optimized calculation");
        startTime = System.nanoTime();
        result = VoltageDividerCalculation.calculateOptimized(k, coincidence, series);
        elapsedTime = System.nanoTime() - startTime;
        for (VoltageDivider vd : result) {
            System.out.println(vd); // thanks to toString()
        }
        System.out.println("-------------------------------");
        System.out.println("Calculation elapsed time: " + TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " ms.");
        System.out.println("------------------------------- \n");

    }
}
