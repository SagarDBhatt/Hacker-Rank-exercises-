/**
 * Provided the array, take the XOR operation to all the sub-array elements and share the result.
 * For eg: given the array [3,4,5]. Take the XOR ops to (3) ^ (4) ^ (5) ^ (3^4) ^ (3^5) ^ (4^5) ^ (3^4^5)
 */

//Sample Input and Output:

//2
//3
//1 2 3
//4
//4 5 7 5
//

//Sample output
//2
//0

/**
 * Psedocode:
 *
 * 1. Read the input and generate the List<Integer>.
 * 2. Use collections.subList method to fetch the sub-elements.
 * 3. Create another List<List<Interger>> to fetch the sub-arrays.
 * 4. Iterate elements of sub-array to find the XOR value of each sub-array.
 * 5. Finally calculate the Final XOR result value.
 */


package ThreeMonthPreparationKit.October_2022.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX08_XOR {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        IntStream.range(0, n).forEach(j -> {
            try {
                int t = Integer.parseInt(br.readLine());
                List<Integer> inputList = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

                System.out.println(inputList);

                int result = getXOROps.sansaXor(inputList);
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }//end of main

}//end of class

class getXOROps {

    /*
     * Complete the 'sansaXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int sansaXor(List<Integer> arr) {
        List<List<Integer>> tempList = new ArrayList<>();

        // Write your code here
        int result = arr.get(0);
        for(int i = 2; i < arr.size(); i += 2){
            result ^= arr.get(i);
        }
        return arr.size() % 2 == 0 ? 0 : result;
    }

}//end of class
