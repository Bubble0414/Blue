import java.util.Scanner;

public class Player {
    // 枚举所有 Player 的类型
    enum TYPE {
        英雄, 近战小兵, 远程小兵, 跑车, 超级兵
    }

    ;

    private String Name;
    private int HP;// 生命值
    private int Attack;// 攻击力
    private int Defence;// 防御力
    private TYPE PlayerType;

    private void CollectInfo(Scanner reader) {
        System.out.printf("请输入「%s」属性(以回车结束输入): \n", PlayerType.toString());

        System.out.println("名称：(英文)");
        Name = reader.next();
        System.out.println("生命：");
        HP = reader.nextInt();
        System.out.println("攻击力：");
        Attack = reader.nextInt();
        System.out.println("防御力：");
        Defence = reader.nextInt();
        System.out.println();
        // reader.close();
    }

    public TYPE getType() {
        return PlayerType;
    }

    // 构造函数
    public Player(TYPE PlayerType, Scanner reader) {
        this.PlayerType = PlayerType;
        CollectInfo(reader);
    }

    // 攻击 player ot，返回 true 表示 ot 已经死亡
    public boolean AttackAnother(Player ot) {
        int Attack_num = this.Attack - ot.Defence;
        System.out.printf("'%s' 对 '%s' 造成了\n", this.Name, ot.Name, Attack_num);
        ot.HP -= Attack_num;// 掉血
        System.out.printf("现在 '%s' 的生命值为「%d」\n", ot.Name, ot.HP);
        if (ot.HP <= 0) {
            System.out.printf("玩家「%s」已经死亡\n", ot.Name);
            return true;
        }
        // System.out.println("=============================");
        return false;
    }
}