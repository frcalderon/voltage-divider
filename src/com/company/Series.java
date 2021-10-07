package com.company;

import java.util.ArrayList;
import java.util.List;

public class Series {

    private List<Resistor> resistors = new ArrayList<>();
    private String name;
    private double precision;
    private double[] normalizedValues;
    private static final double[] PowerFactors = {1., 10., 100., 1000., 1.0e+04, 1.0e+05, 1.0e+06};

    public Series(String name, double[] normalizedValues, double precision) {
        this.name = name;
        this.precision = precision;
        this.normalizedValues = normalizedValues;
        makeResistors();
    }

    public String getName() { return name; }

    public double getPrecision() { return precision; }

    public List<Resistor> getResistors() { return resistors; }

    private void makeResistors() {
        double resistance = 0;
        for (int i = 0; i < normalizedValues.length; i++) {
            for (int j = 0; j < PowerFactors.length; j++) {
                resistance = normalizedValues[i] * PowerFactors[j];
                resistors.add(new Resistor(resistance, this));
            }
        }
    }

    @Override
    public String toString() {
        String res = "Series " + name + "\nNormalized values ";
        for (int i=0; i < normalizedValues.length; i++) { res += normalizedValues[i] + ", "; }
        res += "\nPrecision " + precision;
        return res;
    }
}
