public class Cat extends Animal{
    private String hobby;

    public Cat(String name, String color, int weight,String hobby) {
        super(name,color,weight);
        this.hobby=hobby;
    }
    public void print(){
        System.out.printf("cat ");
        super.print();
        System.out.printf(",hobby:%s%n",hobby);
    }
}
