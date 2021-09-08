package NC;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// NC41 最长无重复子数组
public class NC41 {
    public int maxLength(int[] arr) {
        int max_len = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int tar = arr[j];
                if (!set.contains(tar)) {
                    set.add(tar);
                   if(set.size()>max_len){
                       max_len = set.size();
                   }
                } else {
                    for (; i < j && arr[i] != tar; i++) {
                        set.remove(arr[i]);
                    }
                    i ++;
                }

            }
        }

        return max_len;
    }
}
