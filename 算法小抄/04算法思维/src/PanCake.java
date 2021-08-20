import java.util.ArrayList;
import java.util.List;

public class PanCake {
    public static void main(String[] args) {
        PanCake clazz = new PanCake();
        List<Integer> list = clazz.pancakeSort(new int[]{3,2,4,1});
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }



    List<Integer> res = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {

        backtrack(arr, arr.length);
        return res;
    }

    private void backtrack(int[] arr, int n) {
        if (n == 1) return;
        int maxIndex = 0;
        int maxCake = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxCake) {
                maxCake = arr[i];
                maxIndex = i;
            }
        }
        if (maxIndex == n - 1) {
            backtrack(arr, n - 1);
        } else {
            if (0 != maxIndex) {
                swap(arr, 0, maxIndex);
                res.add(maxIndex + 1);
            }
            swap(arr, 0, n - 1);
            res.add(n);
            backtrack(arr, n - 1);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        //翻转煎饼堆
        while (index1 < index2)
        {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
            index1 ++;
            index2 --;
        }
    }
}
