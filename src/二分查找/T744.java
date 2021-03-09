package 二分查找;

//744. 寻找比目标字母大的最小字母
//寻找左侧边界
public class T744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        char res = letters[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] > target) {
                res = letters[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        T744 t744 = new T744();
        System.out.println(t744.nextGreatestLetter(letters, 'c'));
    }
}
