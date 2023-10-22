/**
 * Find the modified Fibonacci sequence.
 *
 * n1 =0
 * n2 = 1
 * n3 = n1 + (n2 * n2)
 * n4 = n2 + Math.pow(n3,2) [n3 square]
 * ....
 *
 * find the nth number of the sequence
 */

/**
 * Sample input
 *
 * 0 1 5
 *
 * Sample output:
 * 5
 *
 * n1 = 0
 * n2 = 1
 * n3 = 1
 * n4 = 2
 * n5 = 5
 * ...
 *
 * Here, 5th element of the sequence is 5
 */

package ThreeMonthPreparationKit.October_2022.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Week5Final {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(findFibonnaciClass.getFibonnaci(inputList.get(0), inputList.get(1), inputList.get(2)));
    }//end main
}//end of class

class findFibonnaciClass{
    public static BigInteger getFibonnaci(int t1, int t2, int n){

        List<BigInteger> l1 = new ArrayList<>();
        l1.add(BigInteger.valueOf(t1));
        l1.add(BigInteger.valueOf(t2));

        for(int i = 0; i < n-2; i++){
            l1.add( l1.get(i).add(l1.get(i+1).pow(2)));
        }
        System.out.println(l1);
        return l1.get(n-1);
    }
}