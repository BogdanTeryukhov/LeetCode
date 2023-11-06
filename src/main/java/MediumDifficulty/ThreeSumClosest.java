package MediumDifficulty;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 */

public class ThreeSumClosest {
    public static int threeSumClosest(int[] num, int target){
        Arrays.sort(num);
        int closestSum = num[0] + num[1] + num[2];

        for (int i = 0; i < num.length -2; i++) {
            int left = i + 1;
            int right = num.length - 1;

            while (left < right){
                int currentSum = num[i] + num[left] + num[right];

                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] num = new int[]{40,-53,36,89,-38,-51,80,11,-10,76,
                -30,46,-39,-15,4,72,83,-25,33,-69,-73,-100,-23,-37,-13,
                -62,-26,-54,36,-84,-65,-51,11,98,-21,49,51,78,-58,-40,95,-81,41,
                -17,-70,83,-88,-14,-75,-10,-44,-21,6,68,-81,-1,41,-61,-82,-24,45,
                19,6,-98,11,9,-66,50,-97,-2,58,17,51,-13,88,-16,-77,31,35,98,-2,0,
                -70,6,-34,-8,78,22,-1,-93,-39,-88,-77,-65,80,91,35,-15,7,-37,-96,
                65,3,33,-22,60,1,76,-32,22};
        int target = 292;
        System.out.println(threeSumClosest(num, target));
    }
}