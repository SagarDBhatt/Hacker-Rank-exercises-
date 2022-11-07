/**
 * s = SOSSPSSQSSOR, and signal length . Sami sent  SOS messages (i.e.: ).
 *
 * Expected signal: SOSSOSSOSSOS
 * Recieved signal: SOSSPSSQSSOR
 *
 * We print the number of changed letters, which is 3.
 *
 * I/p: SOSTOT
 * O/p: 2
 */


package ThreeMonthPreparationKit.October_2022.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX08_MarsExploration {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String message = bufferedReader.readLine();

        System.out.println(ResultMarsExploration.marsExploration(message));
    }
}//EOF CLASS

class ResultMarsExploration {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        // Write your code here
        int receivedMessageCount = (s.length())/3;
        int index=0, changes =0;
        for(int i = 0; i < receivedMessageCount; i++){
            String decodeValue = s.substring(index,index+3);

            if (decodeValue.charAt(0) != 'S')
                changes++;
            if(decodeValue.charAt(1) != 'O')
                changes++;
            if(decodeValue.charAt(2) != 'S')
                changes++;

            index += 3;
        }
        return changes;
    }

}
