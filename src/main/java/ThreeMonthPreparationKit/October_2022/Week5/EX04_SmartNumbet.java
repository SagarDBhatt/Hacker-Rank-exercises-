/**
 * The number is considered as a smart number if it has odd number of factors.
 *
 * Pseudocode:
 * 1. fetch the input.
 * 2. Find the factors of the given number.
 * 3. Factors % 2 == 0. Print NO. Else Yes.
 */

package ThreeMonthPreparationKit.October_2022.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX04_SmartNumbet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        List<Integer> inpTestCases = new ArrayList<Integer>();
       IntStream.range(0,testcases).forEach(i -> {
            try {
                inpTestCases.add(Integer.parseInt(br.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

       for(Integer i : inpTestCases){
           System.out.println(FindSmartNumber.isSmartNumber(i));
       }
    }//eof main

}//end of class

class FindSmartNumber{
    protected static String isSmartNumber(int n){
        List<Integer> factors = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0)factors.add(i);
        }
        if(factors.size() % 2 == 0)return "NO";
        else return "YES";
    }
}
