/**
 * Question:
 *  1) Given the number of words, convert them into characters and sort in ascending order.
 *  2) If the all the rows and all the columns are ascending order then print Yes else no.
 *
 *  Sample input:
 */

//1
//5
//ebacd
//fghij
//olmkn
//trpqs
//xywuv

//Sample Output:
// YES


/**
 * Pseduo code:
 *  1) Read the number of test cases and number of input. Read the words and generate
 *  List<String>.
 *  2) Iterate each word of the List<String>object and convert into CharArray.
 *  3) Sort the Character Array. Perform the same for all the words.
 *  4) Create the 2 for loop to fetch the char[index] and verify if the order is ascending.
 *  5) If all the index works then Return YES. Else Return NO and break.
 */
package ThreeMonthPreparationKit.October_2022.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class EX07_GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            List<String> inputList = new ArrayList<String>();
            int n = Integer.parseInt(br.readLine());
            IntStream.range(0,n).forEach(obj -> {
                try {
                    inputList.add(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(FindGridChallenge.gridChallenge(inputList));
        }

    }//end of main
}//end of class

class FindGridChallenge {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        List<List<Character>> charList = new ArrayList<>();

        for(String s : grid){
            List<Character> lsCh = new ArrayList<>();
            for(char c : s.toCharArray()){
                lsCh.add(c);
            }
            Collections.sort(lsCh, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1.compareTo(o2);
                }
            });
            charList.add(lsCh);
        }
        //System.out.println(charList);

        for(int i = 0; i < charList.get(0).size(); i++){
            for(int j = 0; j < charList.size()-1; j++){
//                System.out.println(charList.get(j).get(i));
                if(charList.get(j).get(i) > charList.get(j+1).get(i)){
                    return "NO";
                }
            }
        }
        return "YES";
    }

}