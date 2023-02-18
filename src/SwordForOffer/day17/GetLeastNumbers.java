package SwordForOffer.day17;

import java.util.Arrays;

//剑指 Offer 40. 最小的k个数
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //快速排序
    public void quickSort(int[] arr,int l,int r){
        if(l>=r) return;// 子数组长度为 1 时终止递归
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l,j = r;
        while(i<j){
            while(i<j && arr[j] >= arr[l] ) j--;
            while(i<j && arr[i] <= arr[l] ) i++;
            swap(arr,i,j);
        }
        //当i=j
        //将基准数位移到中间
        swap(arr,i,l);
        //递归左右子数组
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,r);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
