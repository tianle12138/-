package problem_7XX;

import java.util.Stack;

// 739. 每日温度
public class _739 {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> day_index = new Stack<>();
        int N = temperatures.length;
        int[] res = new int[N];
        for (int i = N-1; i >= 0 ; i--) {

            while(!day_index.isEmpty() && temperatures[day_index.peek()] < temperatures[i]){
                day_index.pop();
            }
            if(day_index.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = day_index.peek() - i;
            }
            day_index.push(i);

        }
        return  res;
    }
}
