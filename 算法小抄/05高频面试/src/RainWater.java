public class RainWater {
    public int trap(int[] height) {
        int N = height.length;
        if (N == 0) return 0;
        int[] l_max = new int[N];
        int[] r_max = new int[N];
        l_max[0] = height[0];
        r_max[N - 1] = height[N - 1];
        for (int i = 1; i < N; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i - 1]);
        }
        for (int i = N - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Math.min(l_max[i],r_max[i]) - height[i];
        }
        return ans;
    }
}
