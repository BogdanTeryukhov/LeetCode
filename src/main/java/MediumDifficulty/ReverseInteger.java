package MediumDifficulty;

/**
 * 7. Reverse Integer
 */
public class ReverseInteger {

    public static int reverse(int x){
        if (String.valueOf(x).length() == 1){
            return x;
        }

        StringBuilder builder = new StringBuilder();
        char[] strArr = String.valueOf(x).toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] >= 48 && strArr[i] <= 57){
                builder.append(strArr[i]);
            }
        }

        StringBuilder pr = new StringBuilder();
        if (strArr[0] == 45){
            pr.append(strArr[0]).append(builder.reverse());
            long l = Long.parseLong(pr.toString());
            if (l > Math.pow(2, 31) || l < -Math.pow(2, 31)){
                return 0;
            }else{
                return Integer.parseInt(pr.toString());
            }
        }
        long l = Long.parseLong(builder.reverse().toString());
        if (l > Math.pow(2, 31) || l < -Math.pow(2, 31)){
            return 0;
        }else{
            return Integer.parseInt(builder.toString());
        }
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }
}