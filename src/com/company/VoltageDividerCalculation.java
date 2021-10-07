package com.company;

import java.util.*;

public class VoltageDividerCalculation {

    public static List<VoltageDivider> calculate(double voltageDivision, double coincidence, Series s) {
        List<VoltageDivider> result = new ArrayList<>();
        List<Resistor> resistors = s.getResistors();

        double k;
        double tol = voltageDivision * (100 - coincidence) / 100;
        double r1r2coincidence;

        // Non-optimized version at the moment and output to console
        for (Resistor r1 : resistors) {
            for (Resistor r2 : resistors) {
                k = r2.getResistance() / (r1.getResistance() + r2.getResistance());
                if ((voltageDivision - tol < k) && (k < voltageDivision + tol)) {
                    r1r2coincidence = 100 - (Math.abs(voltageDivision - k) * 100)/voltageDivision;
                    result.add(new VoltageDivider(r1, r2, r1r2coincidence));
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    public static List<VoltageDivider> calculateOptimized(double voltageDivision, double coincidence, Series s) {
        List<VoltageDivider> result = new ArrayList<>();
        List<Resistor> resistors = s.getResistors();
        Collections.sort(resistors);

        double k;
        double tol = voltageDivision * (100 - coincidence) / 100;
        double r1r2coincidence;
        List<Resistor> sublist;

        // Optimized version
        for (Resistor r1 : resistors) {
            final double r2Lower = (voltageDivision - tol) * r1.getResistance() / (1 - (voltageDivision - tol));
            final double r2Upper = (voltageDivision + tol) * r1.getResistance() / (1 - (voltageDivision + tol));
            sublist = resistors.stream().filter(x -> x.getResistance() >= r2Lower && x.getResistance() < r2Upper).toList();
            for (Resistor rx : sublist) {
                k = rx.getResistance() / (r1.getResistance() + rx.getResistance());
                r1r2coincidence = 100 - (Math.abs(voltageDivision - k) * 100)/voltageDivision;
                result.add(new VoltageDivider(r1, rx, r1r2coincidence));
            }
        }

        Collections.sort(result);
        return result;
    }
}
