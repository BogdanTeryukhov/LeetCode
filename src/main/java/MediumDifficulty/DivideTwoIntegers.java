package MediumDifficulty;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        long answer = (long)dividend/divisor;
        if (answer > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(answer < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)answer;
        }
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }
}
