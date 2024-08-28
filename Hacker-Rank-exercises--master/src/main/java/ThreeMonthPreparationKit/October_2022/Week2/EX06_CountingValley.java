/**
 * Find the number of times a hikes traverse the valley.
 *
 * i/p:
 * 8
 * UDDDUDUU
 *
 * o/p:
 * 1
 */

package ThreeMonthPreparationKit.October_2022.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX06_CountingValley {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String path = reader.readLine();

        int valleyCounter = ResultValleyCounter.countingValleys(n,path);
        System.out.println(valleyCounter);
    }
}

class ResultValleyCounter {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int mslCounter = 0;
        int valleyCounter = 0;
        boolean flag = false;

        for(int i = 0; i < path.length(); i++){
            flag=false;
            if(path.charAt(i) == 'U')
                mslCounter++;
            else {
                if (mslCounter == 0) {
                    flag = true;
                }
                mslCounter--;

                if (mslCounter < 0 && flag) {
                    valleyCounter++;
                }
            }
        }//EOF FOR

        return valleyCounter;
    }

}