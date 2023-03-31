package SwordForOfferTwo.day25;

//relativeSortArray
public class RelativeSortArray {

    //计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxNum = 0;
        int index = 0;
        int[] res = new int[arr1.length];
        for (int i : arr1) {
            maxNum = Math.max(maxNum,i);
        }
        int[] number = new int[maxNum + 1];
        for (int i : arr1) {
            number[i]++;
        }
        for (int i : arr2) {
            for (int j = 0; j < number[i]; j++) {
                res[index++] = i;
            }
            number[i] = 0;
        }
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                res[index++] = i;
            }
        }
        return res;
    }

}
