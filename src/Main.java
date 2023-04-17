
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int T = Integer.valueOf(s);
        for (int i = 0; i < T; i++) {
            String[] str = scanner.nextLine().split(" ");
            int n = Integer.valueOf(str[0]);
            int a = Integer.valueOf(str[1]);
            int b = Integer.valueOf(str[2]);
            if(n == a+b) {
                System.out.println(1);
                continue;
            }
            int avg = (a + b) / n;
            if(avg >= a || avg >= b){
                System.out.println(avg >= a ? a : b);
                continue;
            }
            if(a < b){
                System.out.println(a % avg < avg ? avg : a%avg);
                continue;
            }
            System.out.println(b % avg < avg ? avg : b%avg);
        }
    }

}