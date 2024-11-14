/**
 * We are given the string of Binary. First need to convert it to associated decimal number.
 * Now, perform the operation - if even then divide by 2. If odd then subtract 1; and count the number of ops.
 * Do the ops until we get zero. Return the number of ops.
 */

package CodingInteview.Misc;

public class IntegerReductionCount {
    public static void main(String[] args) {
        System.out.println("Test");
        String S = "011100";
        String S1 = "1111010101111";
        String S2 = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        double decimalNum = SolutionIntegerReductionCount.getDecimalNumber(S2);
        System.out.println(SolutionIntegerReductionCount.getCountOfOps(decimalNum));
    }
}

class SolutionIntegerReductionCount{
    /**
     * Iterate the String in descending order. Multiply each number with Math.pow(2,i) and sum it.
     * @param S
     * @return
     */
    public static double getDecimalNumber(String S){
        double result = 0;
        for(int i = S.length()-1; i >= 0; i--){
            String s1 = S.substring(i,i+1);
            int n = S.length() - i - 1;
            //System.out.println(s1 + " - " + n);
            result += Integer.parseInt(s1) * Math.pow(2,S.length()-i-1);
        }
        System.out.println(result);
        return result;
    }

    /**
     * If num is even => /2
     * If odd => sub 1
     * Continue until number becomes 0.
     * @param n
     * @return
     */
    public static int getCountOfOps(double n){
        int counter = 0;

        if(n == 0)return counter;

        while(n!=0){
            if(n % 2 == 0){
                n /= 2;
                counter++;
            }else{
                n -= 1;
                counter++;
            }
        }
        return counter;
    }
}
