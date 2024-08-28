/**
 * INPUT:
 * 5
 * 1 2 1 3 2
 * 3 2
 *
 * EXPECTED OUTPUT:
 * 2
 */

package ThreeMonthPreparationKit.October_2022.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX02_SubarrayDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        List<Integer> integerList = Stream.of(br.readLine().split(" ")).map(s ->Integer.parseInt(s)).collect(Collectors.toList());

        String[] arry =  br.readLine().split(" ");
        int d = Integer.parseInt(arry[0]);
        int m = Integer.parseInt(arry[1]);

        int resultValue = ResultEx03.birthday(integerList,d,m);
        System.out.println(resultValue);
    }
}//END OF CLASS:

class ResultEx03 {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        int counter = 0;
        // Write your code here
        for(int i = 0; i <= s.size()-m; i++){

            //APPROACH 1
//            int sum = 0;

//            for(int j = 0; j< m; j++){
//                sum += s.get(i+j);
//            }

            //APPROACH 2 with Streams:
            int sum = IntStream.range(i, i+m).map(e -> s.get(e)).sum();

            if(sum == d) counter++;
        }

        return counter;
    }

}//END OF RESULT CLASS:
