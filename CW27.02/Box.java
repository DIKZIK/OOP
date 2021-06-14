public class Box{
    double width;
    double heigth;
    double depth;

    public Box(){

    }
    public Box(double width, double heigth, double depth){
        this.width = width;
        this.heigth = heigth;
        this.depth = depth;
    }

    public double getWidth(){
        return width;
    }

    public double getHeigth(){
        return heigth;
    }

    public double getDepth(){
        return depth;
    }

    public double getVolume(){
        return width*heigth*depth;
    }
    public void print(){
        System.out.println("width is "+width);
        System.out.println("heigth is "+heigth);
        System.out.println("depth is "+depth);

    }
}