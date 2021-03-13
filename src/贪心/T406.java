package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//406. 根据身高重建队列
public class T406 {
    // 输入的数组是打乱顺序不符合要求的
    // 需要对其排序、整理，得到符合题目要求的数组
    // 遇到两个维度权衡的时候，一定要先确定一个维度，再确定另一个维度
    public int[][] reconstructQueue(int[][] people) {
        // 先按照h降序排列，再按照k升序排列
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        // 暂存排列结果
        List<int[]> temp = new ArrayList<>();
        // 先把高的放到指定位置，后面再往里面添加时，不会影响已添加元素，因为一定比已添加元素矮
        for (int i = 0; i < people.length; i++) {
            // 以k为index插入到列表
            // 若列表长度不够index，防止越界，直接append
            if (people[i][1] + 1 > temp.size()) {
                temp.add(people[i]);
            } else {
                temp.add(people[i][1], people[i]);
            }
        }
        return temp.toArray(new int[people.length][2]);
    }
}
