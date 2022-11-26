public class Animal {
    private String name;
    private String color;
    private int weight;

    public Animal(String name, String color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }
    public String getName(){
        return name;
    }
    public void print(){
        System.out.printf("name:%s,color:%s,weight:%dkg",name,color,weight);
    }
}
