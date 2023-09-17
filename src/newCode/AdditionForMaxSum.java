package newCode;

import java.util.Scanner;

public class AdditionForMaxSum {

  // 这段代码的目的是找到一个相邻元素相乘后替换其中一个元素，从而使整个数组元素和最大的方式，并输出最大的和。
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long[] arr = new long[n];
    long sum = 0;
    long res = 0,left = 0,right = 0;
    long max = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextLong();
      sum += arr[i];
    }
    for (int i = 0; i < n - 1; i++) {
      res = arr[i] * arr[i + 1];
      if(res > max){
        max = res;
        left = arr[i];
        right = arr[i+1];
      }
    }
    System.out.println(sum - left - right + max);
  }

}
