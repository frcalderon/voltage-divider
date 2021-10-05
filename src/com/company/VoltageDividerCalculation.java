package com.company;

import java.util.ArrayList;
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
        // non-optimized version at the moment and output to console
        for (Resistor r1 : resistors) {
            for (Resistor r2 : resistors) {
                if ( /* some condition */) {
                    VoltageDivider vd = new VoltageDivider(r1, r2, r1r2Coincidence);
                    result.add(vd);
                }
            }
        }
    }
}
