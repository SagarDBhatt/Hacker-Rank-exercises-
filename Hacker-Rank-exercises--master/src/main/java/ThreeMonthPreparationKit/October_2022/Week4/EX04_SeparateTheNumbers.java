/**
 * A numeric string, , is beautiful if it can be split into a sequence of two or more positive integers, , satisfying the following conditions:
 *
 *  for any  (i.e., each element in the sequence is  more than the previous element).
 * No  contains a leading zero. For example, we can split  into the sequence , but it is not beautiful because  and  have leading zeroes.
 * The contents of the sequence cannot be rearranged. For example, we can split  into the sequence , but it is not beautiful because it breaks our first constraint (i.e., ).
 * The diagram below depicts some beautiful strings:
 *
 * image
 *
 * Perform  queries where each query consists of some integer string . For each query, print whether or not the string is beautiful on a new line. If it is beautiful, print YES x, where  is the first number of the increasing sequence. If there are multiple such values of , choose the smallest. Otherwise, print NO.
 *
 * Function Description
 *
 * Complete the separateNumbers function in the editor below.
 *
 * separateNumbers has the following parameter:
 *
 * s: an integer value represented as a string
 * Prints
 * - string: Print a string as described above. Return nothing.
 *
 * Input Format
 *
 * The first line contains an integer , the number of strings to evaluate.
 * Each of the next  lines contains an integer string  to query.
 *
 * Constraints
 */

/**
 * Sample I/P:
 *  7
 * 1234
 * 91011
 * 99100
 * 101103
 * 010203
 * 13
 * 1
 *
 * Sample O/P:
 *
 *  YES 1
 * YES 9
 * YES 99
 * NO
 * NO
 * NO
 * NO
 */

package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EX04_SeparateTheNumbers {

//7
//1234
//91011
//99100
//101103
//010203
//13
//1
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        List<Integer> inputArray = new ArrayList<Integer>();
//
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){

            String s = br.readLine();

            findSeaprateString.separateNumbers(s);

//            inputArray.addAll(Stream.of(br.readLine()).map(Integer::parseInt).toList());
        }
//        inputArray.stream().forEach(System.out::println);
    }//EOF MAIN

}//EOF CLASS

class findSeaprateString{

    public static void separateNumbers(String s) {
        // Write your code here
        for(int i = 1; i < (s.length() + 2) / 2; i++){
            StringBuilder shot = new StringBuilder(s.substring(0, i));
            long number = Long.parseLong(shot.toString());
            long firstNumber = number;
            while(shot.length() < s.length()){
                shot.append("" + ++number);
            }
            if(s.equals(shot.toString())){
                System.out.println("YES " + firstNumber);
                return;
            }
        }
        System.out.println("NO");
    }

}
