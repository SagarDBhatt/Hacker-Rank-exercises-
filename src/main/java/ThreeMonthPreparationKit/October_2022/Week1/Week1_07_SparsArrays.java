/**
 * There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.
 *
 * Example
 *
 *
 *
 * There are  instances of ',  of '' and  of ''. For each query, add an element to the return array, .
 *
 * Function Description
 *
 * Complete the function matchingStrings in the editor below. The function must return an array of integers representing the frequency of occurrence of each query string in strings.
 *
 * matchingStrings has the following parameters:
 *
 * string strings[n] - an array of strings to search
 * string queries[q] - an array of query strings
 * Returns
 *
 * int[q]: an array of results for each query
 * Input Format
 *
 * The first line contains and integer , the size of .
 * Each of the next  lines contains a string .
 * The next line contains , the size of .
 * Each of the next  lines contains a string .
 *
 * Constraints
 *
 *
 *
 *  .
 *
 * Sample Input 1
 *
 * CopyDownload
 * 4
 * aba
 * baba
 * aba
 * xzxb
 * 3
 * aba
 * xzxb
 * ab
 * Sample Output 1
 *
 * 2
 * 1
 * 0
 *
 * Sample Input 2
 *
 * CopyDownload
 * 3
 * def
 * de
 * fgh
 * 3
 * de
 * lmn
 * fgh
 * Sample Output 2
 *
 * 1
 * 0
 * 1
 *
 * Sample Input 3
 *
 * CopyDownload
 * 13
 * abcde
 * sdaklfj
 * asdjf
 * na
 * basdn
 * sdaklfj
 * asdjf
 * na
 * asdjf
 * na
 * basdn
 * sdaklfj
 * asdjf
 * 5
 * abcde
 * sdaklfj
 * asdjf
 * na
 * basdn
 * Sample Output 3
 *
 * 1
 * 3
 * 4
 * 3
 * 2
 */

package ThreeMonthPreparationKit.October_2022.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Week1_07_SparsArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> listInputString = new ArrayList<>();
        int inputNum = Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<inputNum;i++){
            listInputString.add(i, bufferedReader.readLine());
        }

        List<String> listQueryString = new ArrayList<>();
        int queryNum = Integer.parseInt(bufferedReader.readLine());
        for(int j = 0; j < queryNum; j++){
            listQueryString.add(j, bufferedReader.readLine());
        }

        List<Integer> calcCounter = MatchingStringFinder.findMatchingQueryCount(listInputString, listQueryString);

        for(Integer i : calcCounter){
            System.out.println(i);
        }

        bufferedReader.close();
    }
}

class MatchingStringFinder{
    public static List<Integer> findMatchingQueryCount(List<String> listInputString, List<String> listQueryString){
        List<Integer> calcMatchingCounter = new ArrayList<>();

        for(int i = 0; i < listQueryString.size(); i++){
            int counter = 0;
            for(String inpStr : listInputString){
                if(listQueryString.get(i).equals(inpStr))
                    counter++;
            }//EOF FOR EACH

            calcMatchingCounter.add(i,counter);
        }//EOF LOOP I

        return calcMatchingCounter;
    }
}
