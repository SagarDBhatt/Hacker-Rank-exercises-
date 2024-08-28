package ThreeMonthPreparationKit.October_2022.Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MockTestQ1ArrayDifferences {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String[] inpArr = br.readLine().split(" ");
            int n = Integer.parseInt(inpArr[0]);
            int k = Integer.parseInt(inpArr[1]);

            List<Integer> al = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(MockTestQ1Solution.pairs(k,al));
        }catch (IOException e){
            e.fillInStackTrace();
        }

    }//main
}//class

class MockTestQ1Solution{

    public static int pairs(int k, List<Integer> arr) {
        // Iterate each element to find the differnece.
        int result = 0;

        //Approach 1: Simplified solution with iterating using 2 for loop,
//        for(int i = 0; i < arr.size()-1; i++){
//            for(int j = i+1; j < arr.size(); j++){
//                if(arr.get(i) < arr.get(j))continue;
//                if( Math.abs(arr.get(i) - arr.get(j)) == k)result++;
//            }
//        }

        //Approach 2 using the Arrays.BinarySearch method.
        int[] array = arr.stream().mapToInt(i-> i).toArray();
        Arrays.sort(array);

        for(int a : array){

            int id = Arrays.binarySearch(array, a - k);
            if(id >= 0)result++;

        }

        return result;
    }


}//class