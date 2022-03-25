package abstract_classes;

import decomp_enum.Colors;

public abstract class Shape {

    private Colors color;

    public Shape(Colors color) {
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public abstract double area();

}
