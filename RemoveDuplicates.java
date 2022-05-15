import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 1;
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] != nums[j + 1]) {
                nums[index++] = nums[j+1];
            }
        }
        return index;
    }
    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();
        int[] nums = {1,1,2,1,3,4};
        System.out.println(sol.removeDuplicates(nums));
        for(int i : nums)
        System.out.println(i);
    }
}
