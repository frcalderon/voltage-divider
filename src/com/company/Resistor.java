package com.company;

public class Resistor implements Comparable<Resistor> {

    private double resistance;
    private Series series;

    public Resistor(double resistance, Series series) {
        this.resistance = resistance;
        this.series = series;
    }

    public double getResistance() { return resistance; }

    @Override
    public int compareTo(Resistor anotherResistor) {
        if ((this.resistance - anotherResistor.getResistance()) > 0) {
            return 1;
        } else if ((this.resistance - anotherResistor.getResistance()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Resistance " + resistance + ", series " + series.getName() + ", precision " + series.getPrecision();
    }
}
