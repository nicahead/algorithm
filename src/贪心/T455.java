package 贪心;

import java.util.Arrays;

//455. 分发饼干
public class T455 {
    //为了尽可能满足最多数量的孩子，从贪心的角度考虑，应该按照孩子的胃口从小到大的顺序依次满足每个孩子，
    //且对于每个孩子，应该选择可以满足这个孩子的胃口且尺寸最小的饼干。
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        // i指向孩子数组g，j指向饼干数组s
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            // s[j]满足孩子胃口g[i]
            if (g[i] <= s[j]) {
                res++;
                i++;
            }
            j++;
        }
        return res;
    }
}
