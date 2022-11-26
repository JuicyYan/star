public class Dog extends Animal{ ;
    private String sport;

    public Dog(String name, String color, int weight,String sport) {
        super(name,color,weight);
        this.sport=sport;
    }
    public void print(){
        System.out.printf("dog ");
        super.print();
        System.out.printf(",sport:%s%n",sport);
    }
}
