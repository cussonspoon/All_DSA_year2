package solutions.pack7;

public class EqualSubsets_660988 {

    public static boolean canPartition_Recur(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        return canPartition(arr, targetSum, arr.length - 1);
    }

    private static boolean canPartition(int[] arr, int targetSum, int index) {
        if (targetSum == 0) {
            return true;
        }
        if (index < 0 || targetSum < 0) {
            return false;
        }

        return canPartition(arr, targetSum - arr[index], index - 1) || 
               canPartition(arr, targetSum, index - 1);
    }
    public static boolean canPartition_Memoiz(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        Boolean[][] memo = new Boolean[arr.length][targetSum + 1];

        return canPartitionMemo(arr, targetSum, arr.length - 1, memo);
    }

    private static boolean canPartitionMemo(int[] arr, int targetSum, int index, Boolean[][] memo) {
        if (targetSum == 0) {
            return true;
        }
        if (index < 0 || targetSum < 0) {
            return false;
        }

        if (memo[index][targetSum] != null) {
            return memo[index][targetSum];
        }

        boolean result = canPartitionMemo(arr, targetSum - arr[index], index - 1, memo) || 
                         canPartitionMemo(arr, targetSum, index - 1, memo);

        memo[index][targetSum] = result;
        return result;
    }
    public static boolean canPartition_DP(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;

        boolean[] dp = new boolean[targetSum + 1];

        dp[0] = true;

        for (int num : arr) {
            for (int i = targetSum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[targetSum];
    }
}
