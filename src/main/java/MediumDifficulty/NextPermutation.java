package MediumDifficulty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int[] image = new int[nums.length];

        if (nums.length - 1 >= 0) System.arraycopy(nums, 1, image, 0, nums.length - 1);
        image[nums.length - 1] = nums[0];

        int[] nextImage = new int[image.length];
        System.arraycopy(image, 1, nextImage, 0, image.length - 1);
        nextImage[image.length - 1] = image[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nextImage[i]);
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = nextImage[0];
        for (int i = 2; i < nums.length; i++) {
            result[i] = map.get(result[i - 1]);
        }
        System.out.println(Arrays.toString(result));
    }
    //127.0.0.1
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        nextPermutation(nums);
    }
}
