/**
 * Task: Given an array with +ve, -ve and zero elements. Find the ration of all +ve, -ve and zero elements. The answer should be in 6 decimal plces.
 *
 * eg:
 * SI: arr = [1,1,0,-1,-1]
 * SO:
 * 0.400000
 * 0.400000
 * 0.200000
 *
 */

package Fresh_3_Months_Prep.Week_1;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            int n = Integer.parseInt(br.readLine());

            List<Integer> arr = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).toList();

            ResultPlusMinus.getRatio(arr);
        }catch (IOException e){
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            bufferedWriter.write(e.getMessage());
        }
    }
}

class ResultPlusMinus{

    public static void getRatio(List<Integer> arr){

        double countOfPositive = arr.stream().filter(i -> i>0).count();
        double countOfNegative = arr.stream().filter(i -> i<0).count();
        double countOfZero = arr.size() - ( countOfPositive + countOfNegative);

        DecimalFormat decimalFormat = new DecimalFormat("0.000000");
        // Print the ratio:
        System.out.println( decimalFormat.format(countOfPositive/arr.size()) );
        System.out.println( decimalFormat.format(countOfNegative/arr.size()));
        System.out.println( decimalFormat.format(countOfZero/arr.size()));

    }
}
