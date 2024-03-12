// LeetCode7——————整数反转 int reversed

public class LeetCode7_整数反转 {
    public static void main(String[] args) {
        int input = 12345;
        int output = reverse(input);
        System.out.println("输入整数 " + input + " 反转后的结果为：" + output);
    }

    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }
}

