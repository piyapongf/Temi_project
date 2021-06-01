package dataClass;

public class Product {

    private String menu;

    private int piece;

    private double price;

    public String getmenu() {
        return this.menu;
    }

    public void setmenu(String menu) {
        this.menu = menu;
    }

    public int getpiece() {
        return this.piece;
    }

    public void setpiece(int piece) {
        this.piece = piece;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Product() {
    }

    public Product(String menu, int piece, double price) {
        this.menu = menu;
        this.piece = piece;
        this.price = price;
    }
}
