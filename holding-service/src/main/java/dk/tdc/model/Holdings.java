package dk.tdc.model;

public class Holdings {
    private double price;
    private int pieces;

    public Holdings(double price, int pieces) {
        this.price = price;
        this.pieces = pieces;
    }

    public double getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }
}
