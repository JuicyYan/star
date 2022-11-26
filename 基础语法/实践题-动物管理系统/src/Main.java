import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private ArrayList<Animal> animallist=new ArrayList<>();

    public void add(Dog dog){
        animallist.add(dog);
    }
    public void add(Cat cat){
        animallist.add(cat);
    }
    public void list() {
        for (Animal each : animallist) {
            each.print();
        }
        if(animallist.isEmpty()){
            System.out.println("暂无小动物！请先添加！");
        }else{
            System.out.println("小动物列举如上！");
        }
    }
    public void ListOneAnimal(){
        if(animallist.isEmpty()){
            System.out.println("暂无小动物！请先添加！");
            return;
        }
        System.out.println("请输入小动物姓名：");
        Scanner names=new Scanner(System.in);
        try{
            String target = names.next();
            int i;
            int find=0;
            for (i = 0; i < animallist.size(); i++) {
                Animal present = (Animal) animallist.get(i);
                if (present.getName().equals(target)) {
                    present.print();
                    find=1;
                    break;
                }
                if(find==0){
                    System.out.println("不存在此小动物！");
                }
            }
        }catch (NumberFormatException target){
            System.out.println("请输入正确格式的名字！");
        }
    }
    public void addAnimal(Main db){
        Scanner name=new Scanner(System.in);
        System.out.println("请选择要添加的动物类型：1（dog）；2（cat）");
        int choice=name.nextInt();
        switch (choice){
            case 1:
                System.out.println("请输入名字：");
                String newName=name.next();
                System.out.println("请输入颜色：");
                String newColor=name.next();
                System.out.println("请输入体重：");
                int newWeight=name.nextInt();
                System.out.println("请输入运动能力：");
                String newSport=name.next();
                db.add(new Dog(newName,newColor,newWeight,newSport));
                System.out.println("输入完毕，添加新dog成功！");
                return;
            case 2:
                System.out.println("请输入名字：");
                String newName2=name.next();
                System.out.println("请输入颜色：");
                String newColor2=name.next();
                System.out.println("请输入体重：");
                int newWeight2=name.nextInt();
                System.out.println("请输入爱好");
                String newHobby=name.next();
                db.add(new Cat(newName2,newColor2,newWeight2,newHobby));
                System.out.println("输入完毕，添加新cat成功！");
                return;
        }
    }
    public static void main(String[] args){
        Main db=new Main();
        for(;;){
            System.out.println("----------------------");
            System.out.println("欢迎使用小动物管理系统！");
            System.out.println("请选择操作：1.添加动物；2.显示所有动物；3.查找某动物信息；4.退出系统；" );
            Scanner ChoiceScanner=new Scanner(System.in);
            int choice=ChoiceScanner.nextInt();
            switch (choice) {
                case 1:
                    db.addAnimal(db);
                    break;
                case 2:
                    db.list();
                    break;
                case 3:
                    db.ListOneAnimal();
                    break;
                case 4:
                    return;
            }
        }
    }
}
