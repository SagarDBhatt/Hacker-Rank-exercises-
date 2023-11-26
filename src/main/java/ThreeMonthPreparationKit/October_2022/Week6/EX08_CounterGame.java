//Given a number, validate if the number is power of 2. If yes then divide by 2 and keep going until the answer is 1.
//Check the counter and return the "Richard" Or "Louise".

//Sample Input:
//1
//6
//
//Sample Output:
//Richard

package ThreeMonthPreparationKit.October_2022.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class EX08_CounterGame {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(br.readLine());
            IntStream.range(0,n).forEach(i -> {
                try{
                    long number = Long.parseLong(br.readLine());
                    System.out.println(ResultCounterGame.counterGame(number));
                }catch(IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }//EOM
}//EOC

class ResultCounterGame {
    public static String counterGame(long n) {
        int counter = 0;
        if(n==1)return "Richard";

        while(n > 1){
            if ((n & (n - 1)) == 0) {
                n /= 2;
            } else {
                n = n - Long.highestOneBit(n);
            }
            counter++;
        }
        if(counter%2==0)return "Richard";
        else return "Louise";

//Below solution is NOT efficient and excedd the time limit. Need the new solution.

//        //Edge case: If n == 1 then return Richard.
//        if(n==1)return "Richard";
//
//        //1. Check if the number is the power of 2.
//        //If yes then divide by 2 and increment the counter + 1. Then repeat the same until the answer is 1.
//        if(isPowerOfTwo(n)){
//            while (n != 1){
//                n = n / 2;
//                counter++;
//            }
//        }
//
//        //2. If the number is not a perfect square then find the difference between the number and the nearest
//        //perfect square of 2.
//        else{
//            long diff = findTheDiff(n);
//            while(diff != 0){
//                if(isPowerOfTwo(diff)){
//                    while (diff != 1){
//                        diff = diff / 2;
//                        counter++;
//                    }
//                    break;
//                }
//                else{
//                    counter++;
//                    diff = findTheDiff(diff);
//                }
//            }
//        }
//
//        if(counter%2==0)return "Richard";
//        else return "Louise";
    }

    public static boolean isPowerOfTwo(long n){
        if(n==0)return false;

        while( n != 1){
            if(n % 2 != 0)return false;
            n = n/2;
        }
        return true;
    }//EofMethod

    public static long findTheDiff(long n){
        int power = (int) Math.sqrt(n);
        return (long)(n - Math.pow(power,2));
    }
}