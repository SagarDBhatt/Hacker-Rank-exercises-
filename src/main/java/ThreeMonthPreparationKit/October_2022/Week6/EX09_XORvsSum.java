package ThreeMonthPreparationKit.October_2022.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX09_XORvsSum {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            long n = Long.parseLong(br.readLine());
            System.out.println(ResultXORSum.sumXor(n));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }//main
}//class

class ResultXORSum {

    public static long sumXor(long n) {
        //Binary of 10 is 1010, the difference between xor and sum in bit operations is that if both bits are 1 their xor is 0 and for sum it is 10, so the number of values x that satisfies the condition can not have 1 on the positions our integer n has 1, it can only be 0, on the positions our integer has 0, that can be either 1 or 0 doesnt matter, so for one zero possible combinations of number is 2, for 2 zero possible combination is 2*2 and so forth for more zeros so the solution is 2 to the power of number of zeros in the binary representation of our integer n
        if(n==0) return 1;

        //1. Convert the long number in the Binary.
        String binary= Long.toBinaryString(n);

        //2. Count number of zeros in the binary.
        long count = binary.chars()
                .filter(s -> s=='0')
                .count();

        //3. All the possible solution of condition n+x == n^x passes with Math.pow(2,count).
        return (long) Math.pow(2,count);

//Time limit Exceeds. Needs an efficient solution.

//1. Loop through the 0 - n-1 and check for instance the cond satisfied. Return the counter.

//        int counter = 0;
//
//        for(int i = 0; i < n; i++){
//            long xor = n ^ i;
//            if(n+i == xor)counter++;
//        }
//        return counter;
    }

}