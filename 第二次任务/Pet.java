public abstract class Pet {
    private String name;
    private String sex;

    public Pet(String name, String sex) {
        this.name = name;
        this.sex = sex;
        System.out.println("这里有只" + sex + name);
    }

    void talk() {
        System.out.println("狗吃");
    }

    void eat() {
        System.out.println("狗跑");
    }

}

class Dog extends Pet {
    private String color;

    public Dog(String name, String sex, String color) {
        super(name, sex);
        this.color = color;
        System.out.println("它是" + color + "的");
    }

    void talk() {
        System.out.println("汪......汪......");
    }

    void eat() {
        System.out.println("吃骨头");
    }
}

class Cat extends Pet {
    private double weight;

    public Cat(String name, String sex, double weight) {
        super(name, sex);
        this.weight = weight;
        System.out.println("它重" + weight + "kg");
    }

    void talk() {
        System.out.println("喵......喵......");
    }

    void eat() {
        System.out.println("吃鱼");
    }
}

