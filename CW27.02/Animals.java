public abstract class Animals implements Sound, Transport{

    public abstract void voice();

    private String name;
    public Animals(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    public void run(){
        System.out.println("I am running");
    }

    public void walk(){
        System.out.println("I am walk");
    }

}