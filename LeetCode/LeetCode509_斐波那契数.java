class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int a = 0, b = 1;
        int result = 0;
        for (int i = 2; i <= N; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }
}

public class LeetCode509_斐波那契数 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.fib(100);

    }
}

/** 这段代码是针对LeetCode 509题的斐波那契数问题编写的解决方案。它使用了迭代的方法来计算第N个斐波那契数。

 在这段代码中，我们定义了一个Solution类，其中包含了一个fib方法，该方法接收一个整数N作为参数，并返回第N个斐波那契数。

 在fib方法中，我们首先对N进行了小于等于1的判断，如果N小于等于1，直接返回N。接着，我们定义了两个变量a和b，

 分别表示斐波那契数列中的前两个数。然后，我们使用一个for循环从2开始迭代到N，

 每次迭代计算当前的斐波那契数，并更新a和b的值。 最后返回b，即为第N个斐波那契数。

 这段代码的时间复杂度为O(N)，空间复杂度为O(1)，因为只使用了常量级别的额外空间。*/
