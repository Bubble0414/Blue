import java.util.Random;

public class Level2 {
    public static void main(String[] args) {
        Role r1 = new Role("乔峰", 100, '男');
        Role r2 = new Role("鸠摩智", 100, '男');

        r1.showRoleInfo();
        r2.showRoleInfo();

        while (true) {
            r1.attack(r2);
            if (r2.getBlood() == 0) {
                System.out.println(r1.getName() + " K.O了" + r2.getName());
                break;
            }

            r2.attack(r1);
            if (r1.getBlood() == 0) {
                System.out.println(r2.getName() + " K.O了" + r1.getName());
                break;
            }
        }
    }

}
class Role {
    private String name;
    private int blood;
    private char gender;
    private String face;

    String[] boyfaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    String[] girlfaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};

    //attack 攻击描述：
    String[] attacks_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };

    //injured 受伤描述：
    String[] injureds_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"};


    public Role() {
    }

    public Role(String name, int bloold, char gender) {
        this.name = name;
        this.blood = bloold;
        this.gender = gender;
        setFace(gender);
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(char gender) {
        Random r = new Random();
        if (gender == '男') {
            int index = r.nextInt(boyfaces.length);
            this.face = boyfaces[index];
        } else if (gender == '女') {
            int index = r.nextInt(girlfaces.length);
            this.face = girlfaces[index];
        } else {
            this.face = "面目狰狞";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void attack(Role role) {
        Random r = new Random();
        int index = r.nextInt(attacks_desc.length);
        String KungFu = attacks_desc[index];


        System.out.printf(KungFu, this.getName(), role.getName());
        System.out.println();


        int hurt = r.nextInt(20) + 1;

        int remainBoold = role.getBlood() - hurt;
        remainBoold = remainBoold < 0 ? 0 : remainBoold;
        role.setBlood(remainBoold);


        if (remainBoold > 90) {
            System.out.printf(injureds_desc[0], role.getName());
        } else if (remainBoold > 80 && remainBoold <= 90) {
            System.out.printf(injureds_desc[1], role.getName());
        } else if (remainBoold > 70 && remainBoold <= 80) {
            System.out.printf(injureds_desc[2], role.getName());
        } else if (remainBoold > 60 && remainBoold <= 70) {
            System.out.printf(injureds_desc[3], role.getName());
        } else if (remainBoold > 40 && remainBoold <= 60) {
            System.out.printf(injureds_desc[4], role.getName());
        } else if (remainBoold > 20 && remainBoold <= 40) {
            System.out.printf(injureds_desc[5], role.getName());
        } else if (remainBoold > 10 && remainBoold <= 20) {
            System.out.printf(injureds_desc[6], role.getName());
        } else {
            System.out.printf(injureds_desc[7], role.getName());
        }
        System.out.println();


    }



    public void showRoleInfo() {
        System.out.println("姓名为：" + getName());
        System.out.println("血量为：" + getBlood());
        System.out.println("性别为：" + getGender());
        System.out.println("长相为：" + getFace());
    }

}

