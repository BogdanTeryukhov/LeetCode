package MediumDifficulty;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a string array words,
 * return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
 * If no such two words exist, return 0
 */

public class MaximumProductOfWordLengths{

    public static boolean isContains(String str1, String str2){
        char[] arr = str2.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (str1.contains(String.valueOf(arr[i]))){
                return true;
            }
        }
        return false;
    }

    public static int maxProduct(String[] words) {
        List<String> sortedList = Arrays.stream(words)
                .sorted(Comparator.comparingInt(String::length).reversed()).toList();

        int max = 0;
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (!isContains(sortedList.get(i), sortedList.get(j))){
                    if (sortedList.get(i).length() * sortedList.get(j).length() > max){
                        max = sortedList.get(i).length() * sortedList.get(j).length();
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        //String[] words = new String[]{"a","ab","abc","d","cd","bcd","abcd"};
        //String[] words = newString[]{"a","aa","aaa","aaaa"};
        System.out.println(maxProduct(words));
    }
}
