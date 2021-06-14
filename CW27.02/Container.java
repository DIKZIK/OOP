public class Container extends Box
{
    double weight;

    public Container(){
        super(1, 2, 3);

    }
    public Container(double width, double heigth, double depth, double weight){
        super(width, heigth, depth);
        this.weight = weight;

    }

    public double getWeight(){
        return weight;
    }
    @Override
    public void print(){
        super.print();
        System.out.println("weight is "+weight);
    }

}