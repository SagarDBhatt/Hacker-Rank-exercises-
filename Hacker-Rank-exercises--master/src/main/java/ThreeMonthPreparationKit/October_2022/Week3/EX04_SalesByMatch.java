/**
 * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 *
 * Example
 *
 *
 * There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
 *
 * Function Description
 *
 * Complete the sockMerchant function in the editor below.
 *
 * sockMerchant has the following parameter(s):
 *
 * int n: the number of socks in the pile
 * int ar[n]: the colors of each sock
 * Returns
 *
 * int: the number of pairs
 * Input Format
 *
 * The first line contains an integer , the number of socks represented in .
 * The second line contains  space-separated integers, , the colors of the socks in the pile.
 *
 * Constraints
 *
 *  where
 * Sample Input
 *
 * STDIN                       Function
 * -----                       --------
 * 9                           n = 9
 * 10 20 20 10 10 30 50 10 20  ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]
 * Sample Output
 *
 * 3
 * Explanation
 *
 * sock.png
 *
 * There are three pairs of socks.
 */

package ThreeMonthPreparationKit.October_2022.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX04_SalesByMatch {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> sockList = Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(ResultSockMerch.sockMerchant(n,sockList));

    }//END OF MAIN

}//END OF CLASS

class ResultSockMerch {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // APPROACH 1: 2 FOR LOOP -> TIME & SPACE COMPLEXITY : O(N2)
//        int pairs = 0;
//        for(int i = 0; i < ar.size() - 1; i++){
//            for(int j = i+1; j < ar.size(); j++){
//                if(ar.get(i) == ar.get(j)){
//                    pairs += 1;
//                    ar.remove(j);
//                    break;
//                }
//            }
//        }
//        return pairs;

        //APPROACH 2: Create a Map and calc occurrence of each element. Divide the occurrence by 2 to find the pairs.
        // TIME AND SPACE COMPLEXITY: O(N)
        Map<Integer, Integer> occurrenceMap = new HashMap<>();

        ar.stream().forEach(obj -> {
            if (occurrenceMap.containsKey(obj)) {
                occurrenceMap.put(obj,occurrenceMap.get(obj)+1);
            }
            else{
                occurrenceMap.put(obj,1);
            }
        });

        int pairs = 0;

        for(Integer key : occurrenceMap.keySet()){
            pairs = pairs + occurrenceMap.get(key) / 2;
        }

        return pairs;
    }

}