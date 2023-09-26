//Use the counting sort to order a list of strings associated with integers. If two strings are associated with the same integer, they must be printed in their original order, i.e. your sorting algorithm should be stable. There is one other twist: strings in the first half of the array are to be replaced with the character - (dash, ascii 45 decimal).
//
//        Insertion Sort and the simple version of Quicksort are stable, but the faster in-place version of Quicksort is not since it scrambles around elements while sorting.
//
//        Design your counting sort to be stable.
//
//        Example
//
//        The first two strings are replaced with '-'. Since the maximum associated integer is , set up a helper array with at least two empty arrays as elements. The following shows the insertions into an array of three empty arrays.
//
//        i	string	converted	list
//        0				[[],[],[]]
//        1 	a 	-		[[-],[],[]]
//        2	b	-		[[-],[-],[]]
//        3	c			[[-,c],[-],[]]
//        4	d			[[-,c],[-,d],[]]
//        The result is then printed:  .
//
//        Function Description
//
//        Complete the countSort function in the editor below. It should construct and print the sorted strings.
//
//        countSort has the following parameter(s):
//
//        string arr[n][2]: each arr[i] is comprised of two strings, x and s
//        Returns
//        - Print the finished array with each element separated by a single space.
//
//        Note: The first element of each , , must be cast as an integer to perform the sort.
//
//        Input Format
//
//        The first line contains , the number of integer/string pairs in the array .
//        Each of the next  contains  and , the integers (as strings) with their associated strings.
//
//        Constraints
//
//
//        is even
//
//
//        consists of characters in the range
//
//        Output Format
//
//        Print the strings in their correct order, space-separated on one line.
//
//        Sample Input
//
//        20
//        0 ab
//        6 cd
//        0 ef
//        6 gh
//        4 ij
//        0 ab
//        6 cd
//        0 ef
//        6 gh
//        0 ij
//        4 that
//        3 be
//        0 to
//        1 be
//        5 question
//        1 or
//        2 not
//        4 is
//        2 to
//        4 the
//        Sample Output
//
//        - - - - - to be or not to be - that is the question - - - -
//        Explanation
//
//        The correct order is shown below. In the array at the bottom, strings from the first half of the original array were replaced with dashes.
//
//        0 ab
//        0 ef
//        0 ab
//        0 ef
//        0 ij
//        0 to
//        1 be
//        1 or
//        2 not
//        2 to
//        3 be
//        4 ij
//        4 that
//        4 is
//        4 the
//        5 question
//        6 cd
//        6 gh
//        6 cd
//        6 gh
//        sorted = [['-', '-', '-', '-', '-', 'to'], ['be', 'or'], ['not', 'to'], ['be'], ['-', 'that', 'is', 'the'], ['question'], ['-', '-', '-', '-'], [], [], [], []]
//

//Input:
//
//20
//0 ab
//6 cd
//0 ef
//6 gh
//4 ij
//0 ab
//6 cd
//0 ef
//6 gh
//0 ij
//4 that
//3 be
//0 to
//1 be
//5 question
//1 or
//2 not
//4 is
//2 to
//4 the
//
//Output:
//- - - - - to be or not to be - that is the question - - - -

/**
 * Explanation of the problem: Counting sort algorithm. Useful for the smaller values. Input is Integer and string associated with that integer.
 * Sort each input based on the associated integer and print the result.
 */

/**
 * pseudocode:
 * 1. Read the input counter.
 * 2. Iterate and read the input and convert the stream to List.
 * 3. [ ['0','a'], ['0','b'], ['1','c'], ['2','d'] ]
 * 3.1 Iterate each key and sort them asc. Use Comparator.sort() method and pass the
 * object of comparable interface. (This needs to override compare method).
 * 4. Create a Set DS and add the first half of the string input.
 * 5. Iterate the sorted arrayList and print each value.
 *   5.1 If the value contains in the Set DS then print "-".
 *   5.2 Else print the value.
 *
 * -- Wrong solution.
 * 3. Create a treeMap to convert the input into key,value pairs.
 * 4. Create a set data structure (HashSet<String>) of first half of the input (For 20 input, first 10 input string should be in the Set array).
 * 5. Print the result - Iterate the Map and print the value.
 *     4.1 If the value is included in the Set then print "-". Else print the string.
 */

package ThreeMonthPreparationKit.October_2022.Week5;

import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class EX06_FullCountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        List<List<String>> arr = new ArrayList<List<String>>();
        List<List<String>> firstHalfInpStringList = new ArrayList<List<String>>();

        for(int i = 0; i < n; i++){
            arr.add(Arrays.stream(bufferedReader.readLine().split(" ")).collect(Collectors.toList()));
            if( i < n/2)firstHalfInpStringList.add(arr.get(i));
        }

        findTheFullCountingSort.countSort(arr);
    }//eof main
}//eof class

class findTheFullCountingSort {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */
        public static void countSort(List<List<String>> arr) throws IOException {
            // Write your code here
            int n = arr.size();
            List<String> list = null;
            int ansIdx = -1;
            String current = "";

            BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));

            HashMap<Integer, StringBuffer> map = new HashMap<>();

            for (int i = 0; i < n; i ++) {
                if (i < n / 2) {
                    arr.get(i).set(1, ((char) 45) + "");
                }
                list = arr.get(i);
                ansIdx = Integer.parseInt(list.get(0));
                current = list.get(1);

                if (map.get(ansIdx) == null) {
                    map.put(ansIdx, new StringBuffer(current));
                }
                else {
                    map.get(ansIdx).append(" " + current);
                }
            }
            for (Map.Entry<Integer, StringBuffer> e : map.entrySet()) {
                writer.write(e.getValue().toString() + " ");
            }
            writer.flush();
            writer.close();
        }

}
