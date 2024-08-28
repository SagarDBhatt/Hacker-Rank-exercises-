package ThreeMonthPreparationKit.October_2022.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. Find the number of positives, negatives and zero elements.
 * 2. Find the total number of elements.
 * 3. find the ration of positive numbers = num of positives in the array / total elements in the array.
 * 4. Follow the same process for the negatives and zeros.
 * 5. Make sure to get the precision to upto 6 decimal points.
 *
 *
 * Sample input:
 * STDIN           Function
 * -----           --------
 * 6               arr[] size n = 6
 * -4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]
 */
public class Week_1_PlusMinus {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num_of_integer = scanner.nextInt();

        List<Integer> list_input_integer = new ArrayList<>(num_of_integer);

        // Approach 1:
//        for(int i = 0; i < num_of_integer; i++){
//            list_input_integer.add(scanner.nextInt());
//        }

        // Approach 2:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list_input_integer = Stream.of(br.readLine().split(" "))
                        .map(obj -> Integer.parseInt(obj))
                        .collect(Collectors.toList());

        Solution_class.displayRation(list_input_integer);

//        for(Integer val : list_input_integer){
//            System.out.println(val);
//        }
    }//END OF MAIN
}//END OF CLASS


class Solution_class{

    public static void displayRation(List<Integer> list){

        double num_of_positives=0, num_of_negatives=0, num_of_zeros=0;

        for(Integer val : list){
          if(val > 0)
              ++num_of_positives;
          else if(val < 0)
              ++num_of_negatives;
          else
              ++num_of_zeros;
        }

        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println(df.format(num_of_positives/list.size()));
        System.out.println(df.format(num_of_negatives/list.size()));
        System.out.println(df.format(num_of_zeros/list.size()));
    }

}