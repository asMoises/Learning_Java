package entities;

public class Product {
    private String name;
    private double price;
    private int quantity;

    // constructor
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    // getters and setters
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void MessageCreator() {
        System.out.println("Product data: " + getName() + ", $ " + getPrice() + ", "
                + getQuantity()
                + " units, Total: $ " + String.format("%.2f", TotalValueInStock()));
    }

    // class methods
    public double TotalValueInStock() {

        return this.quantity * this.price;
    }

    public void AddProducts(int quantity) {
        this.quantity += quantity;
    }

    public void RemoveProduct(int quantity) {
        this.quantity -= quantity;
    }

    public String toString() { // sobreposição do toString da classe object
        String message = "Product data: " + name + ", $ " +
                String.format("%.2f", price) + ", " +
                quantity + " units, " +
                "Total: $ " + String.format("%.2f", TotalValueInStock()) +
                "\n>>";
        return message;
    }
}
