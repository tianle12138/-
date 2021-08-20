package poblem_1XX;

import java.util.Arrays;

public class _3Sum {

    public static void main(String[] args) {
        _3Sum clazz = new _3Sum();
        int result = clazz.threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8);
        System.out.println(result);
    }

    long times = 0;

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            twoSum(arr, i + 1, target - arr[i]);
        }
        return (int) times;
    }

    private void twoSum(int[] arr, int start, int target) {
        int low = start;
        int hight = arr.length - 1;
        while (low < hight) {
            if (arr[low] + arr[hight] < target) {
                low++;
            } else if (arr[low] + arr[hight] > target) {
                hight--;
            } else {
                if (arr[low] != arr[hight]) {
                    int left = low;
                    int right = hight;
                    //找到值为arr[low]的下表右边界，arr[hight]的下表左边界
                    while (low + 1 < hight && arr[low + 1] == arr[low]) low++;
                    while (low < hight - 1 && arr[hight - 1] == arr[hight]) hight--;

                    times += (low - left + 1) * (right - hight + 1);
                    times %= 1000000007;
                    low++;
                    hight--;
                } else {
                    times += (hight - low + 1) * (hight - low) / 2;
                    times %= 1000000007;
                    break;
                }
            }
        }
    }

}

