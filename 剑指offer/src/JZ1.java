
// 二维数组中的查找
public class JZ1 {
    //只能从左下或右上角开始查找
    public boolean Find(int target, int [][] array) {
        int col, row;
        row = array.length - 1;
        col = 0;
        while(row >=0 && col < array[0].length){
            if(target == array[row][col]){
                return true;
            }else if(target > array[row][col]){
                col ++;
            }else {
                row --;
            }
        }
        return false;
    }
    public boolean Find_2(int target, int [][] array) {
        int col, row;
        row = array.length - 1;
        col = array[0].length - 1;

        for (int i = 0; i <= row; i++) {
            if(array[i][0]> target || array[i][col] < target){
                continue;
            }

            boolean flag = BinarySearch(array[i],target);
            if(flag) return true;
        }
        return false;
    }

    private boolean BinarySearch(int[] ints, int target) {
        int lo = 0;
        int hi = ints.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(ints[mid] == target) return true;
            else if(ints[mid] > target){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;

    }
}
