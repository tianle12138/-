import java.util.ArrayList;
import java.util.List;

public class Combination {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        backtrack(n,k, 1,ans);
        return result;
    }

    private void backtrack(int n, int k, int start, List<Integer> ans) {
        if(ans.size() == k){
            result.add( new ArrayList<>(ans));
        }
        for (int i = start; i <= n; i++) {
            ans.add(i);
            backtrack(n,k,i+1,ans);
            ans.remove(ans.size()-1);
        }
    }
}
