package entities;

public class Rectangle {
    public double width;
    public double height;

    public double Area() {
        return width * height;
    }

    public double Perimeter() {
        return (width + height) * 2;
    }

    public double Diagonal() {
        return Math.sqrt((width * 2) + (height * 2));
    }
}
