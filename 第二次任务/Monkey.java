public class Monkey {
    String name;
    String color;

    public Monkey(String name, String color) {
        this.name = name;
        this.color = color;
        System.out.println("这里有只"+color+"的"+name);
    }

    public void act() {
        System.out.println("它倒挂在树上");
    }

    public void eat() {
        System.out.println("在吃香蕉!");
    }
}
    class Xing extends Monkey {
        private String gesture;

        public Xing(String name, String color) {
            super(name, color);
            System.out.println("这里还有只"+color+"的"+name);
        }


        public void act() {
            System.out.println("它在奔跑");
        }

    }

