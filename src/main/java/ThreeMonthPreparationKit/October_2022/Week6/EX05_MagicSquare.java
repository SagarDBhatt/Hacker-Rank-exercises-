//The problem here is to identify the magic square / sudoku square. Given the array 3*3, find the minimum
//        cost to convert the array to magic square. The cost is calculated by finding the absolute difference
//        between the elements between the previous elements and new elements.
//
//Sample input:
//4 9 2
//3 5 7
//8 1 5
//Sample output:
//        1

// All the possible magic squares for the 3*3 matrix.
//[
//[[8, 1, 6], [3, 5, 7], [4, 9, 2]],
//[[6, 1, 8], [7, 5, 3], [2, 9, 4]],
//[[4, 9, 2], [3, 5, 7], [8, 1, 6]],
//[[2, 9, 4], [7, 5, 3], [6, 1, 8]],
//[[8, 3, 4], [1, 5, 9], [6, 7, 2]],
//[[4, 3, 8], [9, 5, 1], [2, 7, 6]],
//[[6, 7, 2], [1, 5, 9], [8, 3, 4]],
//[[2, 7, 6], [9, 5, 1], [4, 3, 8]]
//]

package ThreeMonthPreparationKit.October_2022.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX05_MagicSquare {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> inputList = new ArrayList<>();
        IntStream.range(0,3).forEach(i -> {
            try {
                inputList.add(Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println(ResultMagicSquare.formingMagicSquare(inputList));
    }//enf main
}//eof class

class ResultMagicSquare {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here

        //1. Initialize the all possible MagicSquare of type 3*3
        int [][] squares = new int [][]{
                {8, 3, 4, 1, 5, 9, 6, 7, 2},
                {4, 3, 8, 9, 5, 1, 2, 7, 6},
                {8, 1, 6, 3, 5, 7, 4, 9, 2},
                {6, 1, 8, 7, 5, 3, 2, 9, 4},
                {2, 9, 4, 7, 5, 3, 6, 1, 8},
                {4, 9, 2, 3, 5, 7, 8, 1, 6},
                {2, 7, 6, 9, 5, 1, 4, 3, 8},
                {6, 7, 2, 1, 5, 9, 8, 3, 4}
        };
        List<Integer> simplifiedInputArray = new ArrayList<>();

        //2. Iterate the input Array and convert to simplified array. Alternate solution to eliminate
        // the need of iterating the square.
//        for(List<Integer> ls : s){
//            for(int a : ls){
//                simplifiedInputArray.add(a);
//            }
//        }

        //3. Iterate both simplified array and possible magic array to find the differences.
        int minAbsoluteDiff = Integer.MAX_VALUE;
        int tempAbsDiff = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < simplifiedInputArray.size(); j++){
                if(s.get(j/3).get(j%3) != squares[i][j]){
                    tempAbsDiff += Math.abs(simplifiedInputArray.get(j) - squares[i][j]);
                }
//                if(simplifiedInputArray.get(j) != squares[i][j]){
//                    tempAbsDiff += Math.abs(simplifiedInputArray.get(j) - squares[i][j]);
//                }
            }
            if(minAbsoluteDiff > tempAbsDiff)minAbsoluteDiff = tempAbsDiff;
            tempAbsDiff = 0;
        }

        return minAbsoluteDiff;
    }//eofmethod

}