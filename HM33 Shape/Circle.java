public class Circle extends Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int R;

    public Circle(String color, int x1, int y1, int x2, int y2, int R) {

        super(color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.R = R;
    }

    public void draw() {
        System.out.println("нарисован " + getColor() + " круг c координатами: " + x1 + ":" + y1 + " " + x2 + ":" + y2 + " Радиус: " + R);
    }

    public boolean equals(Circle shape) {

        return ((shape.getColor() == getColor()) && (shape.x1 == x1) && (shape.x2 == x2) && (shape.y1 == y1) && (shape.y2 == y2) && (shape.R == R));
    }

    public int getY2() {

        return y2;
    }

    public int getY1() {

        return y1;
    }

    public int getX2() {

        return x2;
    }

    public int getX1() {

        return x1;
    }

    public int getR() {

        return R;
    }
}