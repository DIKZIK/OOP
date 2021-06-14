public abstract class Shape {

    private String color;

    public Shape(String color) {

        this.color = color;
    }

    public abstract void draw();

    public boolean equals(Shape shape) {

        return shape.color == color;
    }

    public String getColor() {

        return color;
    }
}