package com.company;

public class VoltageDivider implements Comparable<VoltageDivider> {

    private Resistor resistor1;
    private Resistor resistor2;
    private double coincidence;

    public VoltageDivider(Resistor r1, Resistor r2, double coincidence) {
        resistor1 = r1;
        resistor2 = r2;
        this.coincidence = coincidence;
    }

    public double getCoincidence() { return coincidence; }

    @Override
    public int compareTo(VoltageDivider anotherVoltageDivider) {
        if ((anotherVoltageDivider.getCoincidence() - this.coincidence) > 0) {
            return 1;
        } else if ((anotherVoltageDivider.getCoincidence() - this.coincidence) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return resistor1 + ", " + resistor2 + "\nvoltage division "
                + resistor2.getResistance() / (resistor1.getResistance()
                + resistor2.getResistance())
                + "\ncoincidence " + coincidence + "\n";
    }
}
