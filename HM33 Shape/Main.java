public class Main {

    public static void main(String[] args) {

        final int numberOfShape = 2;
        Shape[] shapes = new Shape[numberOfShape];
        shapes[0] = new Rectangle("синий", 3, 4, 5, 2, 1, 0);
        shapes[1] = new Circle("зеленый", 0, 0, 3, 4, 5);
        for (int i = 0; i < numberOfShape; ++i) {

            shapes[i].draw();
            System.out.println();
        }
    }
}