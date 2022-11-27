import java.util.Scanner;

public class Main {
    static private NPC CreatNPC(Scanner reader) {
        System.out.println("正在创建「NPC」角色");
        System.out.println("可选择的「NPC」角色：");
        for (Player.TYPE t : Player.TYPE.values()) {
            System.out.printf("   %d. %s\n", t.ordinal() + 1, t);
        }
        System.out.println("请输入你要创建的角色的编号，以回车键结束输入(如「1」)");

        int ID = reader.nextInt();
        NPC npc = new NPC(Player.TYPE.values()[ID - 1], reader);

        return npc;
    }

    static private Hero CreatHero(Scanner reader) {
        System.out.println("正在创建'英雄'角色");
        return new Hero(reader);
    }

    // 开始战斗
    static private void Battle(Hero hero, NPC npc) {
        int cnt = 0;
        while (true) {
            System.out.printf("========= 回合 %d =========\n", ++cnt);
            System.out.printf("现在是「%s」的回合\n", hero.getType().toString());
            if (hero.AttackAnother(npc)) {
                return;
            }
            System.out.printf("========= 回合 %d =========\n", ++cnt);
            System.out.printf("现在是「%s」的回合\n", npc.getType().toString());
            if (npc.AttackAnother(hero)) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("游戏开始：\n");
        System.out.println("*********************************");

        Hero hero = CreatHero(reader);
        NPC npc = CreatNPC(reader);
        Battle(hero, npc);
        reader.close();
    }
}
