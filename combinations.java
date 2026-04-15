import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k <= 0 || n < k) return ans;
        backtrack(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int start, int n, int k, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = start; i <= n - (k - cur.size()) + 1; i++) {
            cur.add(i);
            backtrack(i + 1, n, k, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine(4, 2)); 
        System.out.println(s.combine(1, 1)); 
    }
}
