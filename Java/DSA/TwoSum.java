import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Returns indices of two distinct elements that sum to target.
 * Expected O(n) time and O(n) auxiliary space.
 * Returns an empty array when no pair exists.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("nums cannot be null");
        }

        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Use long so subtraction cannot overflow an int before lookup.
            long complement = (long) target - nums[i];
            if (complement >= Integer.MIN_VALUE && complement <= Integer.MAX_VALUE) {
                Integer previousIndex = indexByValue.get((int) complement);
                if (previousIndex != null) {
                    return new int[]{previousIndex, i};
                }
            }
            indexByValue.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
