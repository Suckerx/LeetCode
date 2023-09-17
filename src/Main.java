
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {

  static List<String> all = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long maxDiff = in.nextLong();
    long[][] tup = new long[n][2];
    for (int i = 0; i < n; i++) {
      tup[i][0] = in.nextLong();
      tup[i][1] = in.nextLong();
    }
    Arrays.sort(tup, Comparator.comparingLong(tuple -> tuple[0]));
    long maxP = 0;
    long currP = 0;
    int left = 0;
    for (int i = 0; i < n; i++) {
      currP += tup[i][1];
      while (tup[i][0] - tup[left][0] > maxDiff){
        currP -= tup[left][1];
        left++;
      }
      maxP = Math.max(maxP,currP);
    }
    System.out.println(maxP);
  }

}