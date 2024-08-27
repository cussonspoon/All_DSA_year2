package solutions.pack7;

import java.util.ArrayList;
import java.util.List;

public class Subsets_660988 {

    public static void printSubsetsRecursive(List<Integer> set) {
        List<Integer> currentSubset = new ArrayList<>();
        List<String> result = new ArrayList<>();
        generateSubsets(set, 0, currentSubset, result);
        System.out.println(String.join(",", result));
    }

    private static void generateSubsets(List<Integer> set, int index, List<Integer> currentSubset, List<String> result) {
        if (index == set.size()) {
            if (!currentSubset.isEmpty()) {
                StringBuilder subsetString = new StringBuilder("[");
                for (int i = 0; i < currentSubset.size(); i++) {
                    subsetString.append(currentSubset.get(i));
                    if (i < currentSubset.size() - 1) {
                        subsetString.append(",");
                    }
                }
                subsetString.append("]");
                result.add(subsetString.toString());
            }
            return;
        }

        generateSubsets(set, index + 1, currentSubset, result);

        currentSubset.add(set.get(index));
        generateSubsets(set, index + 1, currentSubset, result);

        currentSubset.remove(currentSubset.size() - 1);
    }
    public static void printSubsetsDP(List<Integer> set) {
        List<List<Integer>> dp = new ArrayList<>(); //DP
        dp.add(new ArrayList<>()); //DP base case

        for (Integer num : set) {
            int size = dp.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(dp.get(i));
                newSubset.add(num);
                dp.add(newSubset);
            }
        }

        // Print all subsets
        for (List<Integer> subset : dp) {
            System.out.print("[");
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i));
                if (i < subset.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("],");
        }
        System.out.println();
    }

}
