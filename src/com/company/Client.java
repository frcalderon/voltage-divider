package com.company;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        SeriesCatalog seriesCatalog = new SeriesCatalog();
        // input for voltage divider calculation
        double k = 0.5;
        String name = "E6";
        double coincidence = 80.; // percentual
        Series series = seriesCatalog.findSeriesByName(name);
        List<VoltageDivider> result = VoltageDividerCalculation.calculate(k, coincidence, series);
        for (VoltageDivider vd : result) {
            System.out.println(vd); // thanks to toString()
        }
    }
}
