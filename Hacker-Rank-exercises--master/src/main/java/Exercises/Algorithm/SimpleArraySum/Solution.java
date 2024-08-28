package Exercises.Algorithm.SimpleArraySum;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */
        int sum = 0;
        for(int i= 0; i<ar.length;i++)
            sum += ar[i];

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        System.out.println("Enter size of array = ");
        int arCount = Integer.parseInt(scanner.nextLine().trim());

        int[] ar = new int[arCount];

        System.out.println("Enter array elements - space separated");
        String[] arItems = scanner.nextLine().split(" ");

        for (int arItr = 0; arItr < arCount; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = simpleArraySum(ar);

        System.out.println("Sum of array elements = " + result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/
    }
}
