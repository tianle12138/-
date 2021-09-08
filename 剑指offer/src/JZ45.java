import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class JZ45 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        JZ45 cls = new JZ45();
        System.out.println(cls.minNumber(nums));
    }


    public String minNumber(int[] nums) {
        // bubbleSort(nums);
        // qSort(nums, 0, nums.length - 1);

        Queue<String> q = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for (int num : nums) {
            q.add(Integer.toString(num));
        }
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            res.append(q.poll());
        }

        return res.toString();

    }

    private void qSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int pivot = l;
        int left = l;
        int right = r;
        while (left < right) {
            while (right > left && compared(nums[pivot], nums[right]) < 0) right--;
            while (left < right && compared(nums[pivot], nums[left]) >= 0) left++;
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, l, left);
        qSort(nums, l, left - 1);
        qSort(nums, left + 1, right);
    }

    private void bubbleSort(int[] nums) {
        int len = nums.length;
        boolean swap = true;
        for (int i = 0; i < len; i++) {
            if (!swap) return;
            swap = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (compared(nums[j], nums[j + 1]) > 0) {
                    swap(nums, j, j + 1);
                    swap = true;
                }
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private int compared(int num, int num1) {
        String str1 = "" + num + num1;
        String str2 = "" + num1 + num;
        int i = str1.compareTo(str2);
        return i;
    }
}
