package 数组;

//11. 盛水最多的容器
public class T11 {
    public static void main(String[] args) {
        int[] height = {1, 2, 1};
        T11 t = new T11();
        System.out.println(t.maxArea(height));
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        int hgt = 0; // 容器高度
        int newArea = 0;
        while (i != j) {
            // 容器面积取决于短的高度
            hgt = height[i] < height[j] ? height[i] : height[j];
            newArea = (j - i) * hgt;
            if (newArea > maxArea) {
                maxArea = newArea;
            } else {
                // 短的那一边移动指针
                if (height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return maxArea;
    }
}
