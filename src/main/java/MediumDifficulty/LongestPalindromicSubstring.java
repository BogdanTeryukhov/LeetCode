package MediumDifficulty;


/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {

    public static boolean isPalindrome(char[] word){
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

    public static String longestPalindrome(String s){
        char[] strArr = s.toCharArray();
        StringBuilder grandBuilder = new StringBuilder();

        if (s.equals("")){
            return "";
        }

        for (int i = 0; i < strArr.length - 1; i++) {
            StringBuilder builder = new StringBuilder().append(strArr[i]);

            for (int j = i + 1; j < strArr.length; j++) {
                builder.append(strArr[j]);
                if (isPalindrome(builder.toString().toCharArray())){
                    if (builder.length() > grandBuilder.length()){
                        grandBuilder.setLength(0);
                        grandBuilder.append(builder);
                    }
                }
            }
            builder.setLength(0);
        }
        if (grandBuilder.isEmpty()){
            return s.substring(0,1);
        }
        return grandBuilder.toString();
    }

    public static void main(String[] args) {
        //String s = "babad";
        String s = "ccc";
        System.out.println(longestPalindrome(s));
    }
}
