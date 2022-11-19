//public class Main {
   /* public static void main(String[] args) {

        Monkey monkey = new Monkey();
        People people = new People();
        monkey.speak();
        people.speak();
        people.think();

    }

    public static class Monkey {
        //public static Object speak;
        String name;

        public void speak() {
            System.out.println("咿咿呀呀......");
        }
    }

    public static class People extends Monkey {

        //  public static Object think;

        public void speak() {
            System.out.println("小样儿,不错嘛!会说话了!");
        }

        public void think() {
            System.out.println("别说话!认真思考!");
        }
    }
}*/
  /*public class Main {
       public static void main(String[] args) {
           String[] strs = new String[]{"flower", "flow", "flight"};
           System.out.println(Main.longestCommonPrefix(strs));
       }

       public static String longestCommonPrefix(String[] strs) {
           // 判断是否有空字符串
           if (strs.length == 0) {
               return "";
           }
           String ans = strs[0];
           for (int i = 1; i < strs.length; i++) {
               int j = 0;
               for (; j < ans.length() && j < strs[i].length(); j++) {
                   if (ans.charAt(j) != strs[i].charAt(j)) {
                       break;
                   }
               }
               ans = ans.substring(0, j);
               // 判断共同前缀是否为空
               if (ans.equals("")) {
                   return ans;
               }
           }
           return ans;
       }
   }
*/


/*public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("小明","男",18);
        st1.age= 18;
        st1.name = "小明";
        st1.gender= "男";
      //  System.out.println(st1.getAge());
        System.out.println(st1.age);
        //System.out.println(st1.getName());
        System.out.println(st1.name);
       // System.out.println(st1.getGender());
        System.out.println(st1.gender);

    }
}

class Student {
    String name;
    String gender;
    int age;


    public Student() {
    }

   public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    /*public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


}*/

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("修狗儿", "公", "棕色");

        dog.talk();
        dog.eat();
        Cat cat = new Cat("修猫儿", "母", 5);
        cat.eat();
        cat.talk();
        Monkey mon = new Monkey("猴儿", "金色");
        mon.act();
        mon.eat();
        Xing xin = new Xing("大猩猩", "黑色");
        xin.act();


    }
}