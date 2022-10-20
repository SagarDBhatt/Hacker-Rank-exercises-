/**
 * Explanation
 *
 * Take 1 for example, as unsigned 32-bits is 00000000000000000000000000000001 and doing the flipping we get 11111111111111111111111111111110 which in turn is 4294967294.
 *
 * 1. Convert the given Long number into 32 bits binary.
 * 2. Flip the binary 0->1 and 1->0 at each index level.
 * 3. Convert the binary into equivalent base 10 number.
 *
 * SAMPLE INPUT:
 * 1
 *
 * SAMPLE OUTPUT:
 * 4294967294
 */

package ThreeMonthPreparationKit.October_2022.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ex03_FlippingBits {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        String line = "";
        List<Long> input = new ArrayList<Long>();

        while (!(line = bufferedReader.readLine()).equals("")){
            input.add(Long.parseLong(line));
        }

        for(Long num : input){
            System.out.println(ResultFlipping.flippingBits(num));
        }

    }//EOF MAIN
}//EOF CLASS

class ResultFlipping {

    public static long flippingBits(long n) {
        // Write your code here
        Stack<Long> stack = new Stack<>();
        for(int i = 0; n > 0; i++){
            stack.push((n % 2) );
            n = n / 2;
        }
        String binaryNum = "";
        while (!stack.empty()){
            binaryNum += stack.pop();
        }
        binaryNum = String.format("%32s", binaryNum).replace(" ","0");

        char[] binaryArray = binaryNum.toCharArray();
        for(int i = 0; i < binaryArray.length; i++){
            if(binaryArray[i] == '0')
                binaryArray[i] = '1';
            else
                binaryArray[i] = '0';
        }

        String flippedBinary = "";
        for(char i : binaryArray){
            flippedBinary += i;
        }

        return getDecimalOfFlippedBinaryString(flippedBinary);
    }//EOF flipbits

    public static long getDecimalOfFlippedBinaryString(String S){

        long flippedDecimal = 0L;
        long base = 1L;

        for(int i = S.length()-1; i >= 0; i--){
            flippedDecimal += base * Character.getNumericValue(S.charAt(i));
            base *= 2;
        }
        return flippedDecimal;
    }//EOF METHOD

}
