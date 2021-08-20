import java.util.Arrays;

public class KoKo {


    public static void main(String[] args) {
        KoKo koKo = new KoKo();
        int[] piles = new int[]{30,11,23,4,20};

        System.out.println(koKo.minEatingSpeed(piles, 4));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int N = piles.length;
        Arrays.sort(piles);
        // 搜索符合要求的k的左边界
        int right = piles[N - 1];
        int left = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left > piles[N-1]) return -1;
        return left;
    }

    private boolean canEatAll(int[] piles, int mid, int deadline) {
        int day = 0;
        for (int pile : piles) {
            day += (pile / mid) + (pile % mid == 0 ? 0 : 1);
        }

        return day <= deadline;
    }
}
