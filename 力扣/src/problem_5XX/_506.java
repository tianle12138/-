package problem_5XX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class _506 {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,String> map=new HashMap<>();
        int[] c=score.clone();
        String[] a=new String[score.length];
        Arrays.sort(c);
        for(int i=a.length-1;i>=0;i--){
            if(i==a.length-1){
                a[i] ="Gold Medal";
                map.put(c[i],a[i]);
            }
            else if(i==a.length-2){
                a[i] ="Silver Medal";
                map.put(c[i],a[i]);
            }
            else if(i==a.length-3){
                a[i] ="Bronze Medal";
                map.put(c[i],a[i]);
            }else {
                a[i] = a.length-i + "";
                map.put(c[i],a[i]);
            }
        }
        for(int i=0;i<score.length;i++) a[i]= map.get(score[i]);
        return a;

    }
}
