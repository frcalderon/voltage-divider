package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VoltageDividerCalculation {

    public static List<VoltageDivider> calculate(double voltageDivision, double coincidence, Series s) {
        /*
        K = (Vout / Vin)
        k = r2.getResistance() / (r1.getResistance() + r2.getResistance())
        c = coincidence
        AError = |K - k| < tol
        tol = (K * (100 - c)) / 100
        r1r2Coincidence = 1 / tol
        */
        List<VoltageDivider> result = new ArrayList<VoltageDivider>();
        List<Resistor> resistors = s.getResistors();
        double k = 0;
        double tol = voltageDivision * (100 - coincidence) / 100;
        double r1r2coincidence = 0;
        // non-optimized version at the moment and output to console
        for (Resistor r1 : resistors) {
            for (Resistor r2 : resistors) {
                k = r2.getResistance() / (r1.getResistance() + r2.getResistance());
                if ((voltageDivision - tol < k) && (k < voltageDivision + tol)) {
                    r1r2coincidence = 100 - (Math.abs(voltageDivision - k) * 100)/voltageDivision;
                    VoltageDivider vd = new VoltageDivider(r1, r2, r1r2coincidence);
                    result.add(vd);
                }
            }
        }
        result.sort(Comparator.comparing(VoltageDivider::getCoincidence).reversed());
        return result;
    }
}
