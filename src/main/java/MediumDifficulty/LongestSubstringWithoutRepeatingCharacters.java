package MediumDifficulty;

/**
 * 2. Given a string s, find the length of the longest substring without repeating characters.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        char[] arrStr = s.toCharArray();
        if (s.isEmpty()){
            return 0;
        }

        int grandMax = 1;
        for (int i = 0; i < arrStr.length - 1; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(arrStr[i]);
            int max = 1;
            for (int j = i + 1; j < arrStr.length; j++) {
                if (!builder.toString().contains(String.valueOf(arrStr[j]))){
                    builder.append(arrStr[j]);
                    max++;
                }else{
                    break;
                }
            }
            if (max > grandMax){
                grandMax = max;
            }
            builder.setLength(0);
        }
        return grandMax;
    }

    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "bbbbb";
        String s = "pwwkew";
        //String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
