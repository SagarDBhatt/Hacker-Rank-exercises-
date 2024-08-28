/**
 * Find an integer from the list of integer inputs with only 1 occurrence.
 *
 * input:
 * 5
 * 0 0 1 2 1
 *
 * output:
 * 2
 */

package ThreeMonthPreparationKit.October_2022.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex01_LonelyInteger {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());

        List<Integer> inputNumList = Stream.of(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int uniqueNum = Result.lonelyinteger(inputNumList);
        System.out.println(uniqueNum);
    }//EOF Maim
}// EOF Class

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        if (a.size() == 1)
            return a.get(0);
        else {
            for (int i = 0; i < a.size(); i++) {
                int counter = 0;
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(i) == a.get(j) && i!=j) counter++;
                }
                if (counter == 0)
                    return a.get(i);
            }
        }
        return 0;
    }
}