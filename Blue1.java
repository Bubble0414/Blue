import java.util.Scanner;

public class Blue1 {
    //回文数
    public static void main(String[] args) {
       int sum = 0;
        System.out.printf("x=");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("false");
        } else {
            int temp = n;     //储存原始数值
            while (n != 0) {
                int x = n % 10;   //取出各个位置的数
                n = n / 10;
                sum = sum * 10 + x;

            }
            System.out.println(sum == temp);  //判断是否相等
        }


        //两数之和
        System.out.printf("nums = ");
        Scanner sc1 = new Scanner(System.in);
        String str = sc1.next().toString();
        String[] arr = str.split(",");
        System.out.printf("target =");
        int[] b = new int[arr.length];
        Scanner sc3 = new Scanner(System.in);
        int target = sc3.nextInt();
        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (b[i] + b[j] == target) {
                    System.out.println("["+i+","+j+"]");
                }
            }
        }
    }
}