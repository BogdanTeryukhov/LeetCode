package MediumDifficulty;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 */
public class IntegerToRoman {
    enum RomanLetters{
        M("M"), CM("CM"), D("D"), CD("CD"),
        XC("XC"), C("C"), XL("XL"), L("L"),
        IX("IX"), X("X"), IV("IV"), V("V"),
        I("I");


        RomanLetters(String str) {
        }
    }

    public static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0){
            if (num - 1000 >= 0){
                builder.append(RomanLetters.M);
                num -= 1000;
            }
            else if (num - 900 >= 0){
                builder.append(RomanLetters.CM);
                num -= 900;
            }
            else if (num - 500 >= 0){
                builder.append(RomanLetters.D);
                num -= 500;
            }
            else if (num - 400 >= 0){
                builder.append(RomanLetters.CD);
                num -= 400;
            }
            else if (num - 100 >= 0){
                builder.append(RomanLetters.C);
                num -= 100;
            }
            else if (num - 90 >= 0){
                builder.append(RomanLetters.XC);
                num -= 90;
            }
            else if (num - 50 >= 0){
                builder.append(RomanLetters.L);
                num -= 50;
            }
            else if (num - 40 >= 0){
                builder.append(RomanLetters.XL);
                num -= 40;
            }
            else if (num - 10 >= 0){
                builder.append(RomanLetters.X);
                num -= 10;
            }
            else if (num - 9 >= 0){
                builder.append(RomanLetters.IX);
                num -= 9;
            }
            else if (num - 5 >= 0){
                builder.append(RomanLetters.V);
                num -= 5;
            }
            else if (num - 4 >= 0){
                builder.append(RomanLetters.IV);
                num -= 4;
            }
            else {
                builder.append(RomanLetters.I);
                num -= 1;
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        int num  = 65;
        System.out.println(intToRoman(num));
    }
}
