public class Rectangle extends Shape {

    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;

    public Rectangle(String color, int x1, int x2, int x3, int y1, int y2, int y3) {

        super(color);
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public void draw() {

        System.out.println("нарисован " + getColor() + " прямоугольник с координатами: " + x1 + ":" + y1 + " " + x2 + ":" + y2 + " " + x3 + ":" + y3);
    }

    public boolean equals(Rectangle shape) {

        return ((shape.getColor() == getColor()) && (shape.x1 == x1) && (shape.x2 == x2) && (shape.x3 == x3) && (shape.y1 == y1) && (shape.y2 == y2) && (shape.y3 == y3));
    }

    public int getX1() {

        return x1;
    }

    public int getX2() {

        return x2;
    }

    public int getX3() {

        return x3;
    }

    public int getY1() {

        return y1;
    }

    public int getY2() {

        return y2;
    }

    public int getY3() {

        return y3;
    }
}