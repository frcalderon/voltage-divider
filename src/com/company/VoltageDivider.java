package com.company;

public class VoltageDivider {

    private Resistor resistor1 = null;
    private Resistor resistor2 = null;
    private double coincidence;

    // TODO: three corresponding getters
    public VoltageDivider(Resistor r1, Resistor r2, double coincidence) {
        resistor1 = r1;
        resistor2 = r2;
        this.coincidence = coincidence;
    }

    @Override
    public String toString() {
        return resistor1 + ", " + resistor2 + "\nvoltage division "
                + resistor2.getResistance() / (resistor1.getResistance()
                + resistor2.getResistance())
                + "\ncoincidence " + coincidence + "\n";
    }
}
