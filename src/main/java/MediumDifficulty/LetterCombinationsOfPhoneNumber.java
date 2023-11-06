package MediumDifficulty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */

public class LetterCombinationsOfPhoneNumber {
    enum PhoneNumberLetters{

        TWO(Map.of(2, List.of("a","b","c"))),
        THREE(Map.of(3,List.of("d","e","f"))),
        FOUR(Map.of(4, List.of("g","h","i"))),
        FIVE(Map.of(5, List.of("j","k","l"))),
        SIX(Map.of(6, List.of("m","n","o"))),
        SEVEN(Map.of(7, List.of("p","q","r","s"))),
        EIGHT(Map.of(8, List.of("t","u","v"))),
        NINE(Map.of(9,List.of("w","x","y","z")));

        private Map<Integer, List<String>> map;

        PhoneNumberLetters(Map<Integer, List<String>> map) {
            this.map = map;
        }


        public static List<String> interpretator(int integer){
            switch (integer){
                case 2:
                    return PhoneNumberLetters.TWO.map.get(2);
                case 3:
                    return PhoneNumberLetters.THREE.map.get(3);
                case 4:
                    return PhoneNumberLetters.FOUR.map.get(4);
                case 5:
                    return PhoneNumberLetters.FIVE.map.get(5);
                case 6:
                    return PhoneNumberLetters.SIX.map.get(6);
                case 7:
                    return PhoneNumberLetters.SEVEN.map.get(7);
                case 8:
                    return PhoneNumberLetters.EIGHT.map.get(8);
                case 9:
                    return PhoneNumberLetters.NINE.map.get(9);
            }
            throw new IllegalArgumentException("Wrong digit");
        }

    }

    public static List<String> merging(List<String> stringList1, List<String> stringList2){
        List<String> result = new ArrayList<>();
        for (String string1: stringList1) {
            for (String string2: stringList2) {
                result.add(string1.concat(string2));
            }
        }
        return result;
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<>();
        }

        char[] arrStr = digits.toCharArray();
        List<List<String>> listIn = new ArrayList<>();
        for (int i = 0; i < arrStr.length; i++) {
            int integer = Integer.parseInt(String.valueOf(arrStr[i]));
            listIn.add(PhoneNumberLetters.interpretator(integer));
        }

        if (listIn.size() == 1){
            return listIn.get(0);
        }
        List<String> alreadyMerged = merging(listIn.get(0), listIn.get(1));
        for (int i = 2; i < listIn.size(); i++) {
            List<String> proxy = merging(alreadyMerged, listIn.get(i));
            alreadyMerged = proxy;
        }
        return alreadyMerged;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
