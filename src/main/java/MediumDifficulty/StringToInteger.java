package MediumDifficulty;

/**
 * 1. Read in and ignore any leading whitespace.
 * 2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * 3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * 6. Return the integer as the final result.
 */
public class StringToInteger {
    enum State{
        START, NONDIGIT, DIGIT, LETTER, WHITESPACE
    }

    public static int myAtoi(String s){
        State state = State.START;
        char[] arr = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean isMeetZero = false;
        boolean zeroFromNONDIGIT = false;
        boolean fromZeroCondition = false;
        
        for (int i = 0; i < arr.length; i++) {
            if (state == State.START) {
                if (arr[i] >= 48 && arr[i] <= 57) {
                    if (arr[i] == 48){
                        isMeetZero = true;
                        fromZeroCondition = true;
                    }else {
                        state = State.DIGIT;
                        builder.append(arr[i]);
                    }
                } else if (arr[i] == 43 || arr[i] == 45) {
                    if (isMeetZero){
                        return 0;
                    }else{
                        state = State.NONDIGIT;
                        builder.append(arr[i]);
                    }
                } else if (!(arr[i] == ' ')) {
                    state = State.LETTER;
                }else {
                    state = State.WHITESPACE;
                }
            } else if (state == State.DIGIT) {
                if (arr[i] >= 48 && arr[i] <= 57) {
                    if (arr[i] == 48){
                        if (!zeroFromNONDIGIT){
                            builder.append(arr[i]);
                        }
                    }else {
                        builder.append(arr[i]);
                        zeroFromNONDIGIT = false;
                    }
                } else if (arr[i] == ' ' || arr[i] == '.' || arr[i] == ',') {
                    break;
                } else {
                    break;
                }
            } else if (state == State.NONDIGIT) {
                if (arr[i] == 43 || arr[i] == 45) {
                    return 0;
                } else if (arr[i] >= 48 && arr[i] <= 57) {
                    if (arr[i] == 48){
                        builder.append(arr[i]);
                        builder = new StringBuilder(builder.substring(0, builder.length() - 1));
                        zeroFromNONDIGIT = true;
                    }else{
                        builder.append(arr[i]);
                    }
                    state = State.DIGIT;
                }else if (arr[i] == ' '){
                    state = State.WHITESPACE;
                    fromZeroCondition = true;
                }else {
                    state = State.LETTER;
                }
            } else if (state == State.LETTER) {
                if (arr[i] == ' '){
                    return 0;
                } else if (arr[i] >= 49 && arr[i] <= 57) {
                    break;
                } else if (arr[i] == 43 || arr[i] == 45) {
                    return 0;
                }
            } else if (state == State.WHITESPACE) {
                if (arr[i] >= 48 && arr[i] <= 57){
                    if (fromZeroCondition){
                        return 0;
                    }
                    if (arr[i] == 48){
                        isMeetZero = true;
                    }else {
                        state = State.DIGIT;
                        builder.append(arr[i]);
                    }
                }
                else if (arr[i] == 43 || arr[i] == 45){
                    state = State.NONDIGIT;
                    builder.append(arr[i]);
                }
                else if (!(arr[i] == ' ')) {
                    state = State.LETTER;
                }
            }
        }

        if (builder.isEmpty() || builder.toString().equals("+") || builder.toString().equals("-")){
            return 0;
        }

        if (builder.length() > 11){
            if (builder.substring(0,1).equals("-")){
                return (int) -Math.pow(2,31);
            }
            return (int) (Math.pow(2,31) - 1);
        }

        long checker = Long.parseLong(builder.toString());
        if (checker > Math.pow(2, 31) - 1){
            return (int) (Math.pow(2,31) - 1);
        }
        if (checker < -Math.pow(2, 31) ){
            return (int) -Math.pow(2,31);
        }
        return Integer.parseInt(builder.toString());
    }

    public static void main(String[] args) {
        String s = "  +b12102370352";
        System.out.println(myAtoi(s));
    }
}
