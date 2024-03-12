//  LeetCode1588_所有奇数长度的子数组的和

public class LeetCode1588_所有奇数长度的子数组的和 {
    public static void main(String[] args) {
        SolutionArrSum solutionArrSum = new SolutionArrSum();

        int[] arr = {1, 4, 2, 5, 3};

        int result = solutionArrSum.sumOddLengthSubarrays(arr);

        System.out.println("Sum of all odd length subarrays: " + result);
        System.out.println("所有奇数长度的子数组的和: " + result);
    }
}

class SolutionArrSum {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int contribution = ((i + 1) * (arr.length - i) + 1) / 2;
            sum += arr[i] * contribution;
        }
        return sum;
    }
}
