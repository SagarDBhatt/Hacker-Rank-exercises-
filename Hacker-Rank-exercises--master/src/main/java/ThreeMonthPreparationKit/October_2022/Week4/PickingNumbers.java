package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PickingNumbers {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            List<Integer> inputArray = Arrays.stream(br.readLine().split(" ")).map(i -> Integer.parseInt(i)).sorted().collect(Collectors.toList());

            int maxSubArray = ResultPickingupNumber.pickingNumbers(inputArray);
            System.out.println(maxSubArray);
        } catch (Exception e) {
            System.out.println("Unable to read input stream!");
        }


    }//EOF MAIN
}//EOF CLASS
