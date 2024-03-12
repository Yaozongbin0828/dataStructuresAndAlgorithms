// LeetCode66_加一

public class LeetCode66_加一 {
    public static void main(String[] args) {
        // 测试加一
        int[] digits = {1, 2, 3};
        int[] result = plusOne(digits); // 调用加一的方法
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
