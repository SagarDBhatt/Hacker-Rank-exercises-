package ThreeMonthPreparationKit.October_2022.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Week2_FinalTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q= Integer.parseInt(bufferedReader.readLine());
        int n = Integer.parseInt(bufferedReader.readLine());

        List<Integer> integerList = new ArrayList<>();
        List<List<Integer>> finalMatrixList = new ArrayList<List<Integer>>();

        for(int i =0; i <2*n; i++){
            integerList = Stream.of(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            finalMatrixList.add(integerList);
        }

        int sum = ResultMatrix.findMaxResult(finalMatrixList);
        System.out.println(sum);
    }
}//EOF CLASS

class ResultMatrix{
    public static int findMaxResult(List<List<Integer>> matrix){

        int n = matrix.size();
        int maxSum = 0;

        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.size(); j++){

                if(i<n/2 && j<n/2){
                    int initialValue = matrix.get(i).get(j);

                    if(initialValue < matrix.get(i).get(n-1-j))
                        initialValue = matrix.get(i).get(n-1-j);

                    if(initialValue < matrix.get(n-1-i).get(n-1-j))
                        initialValue = matrix.get(n-1-i).get(n-1-j);

                    if(initialValue < matrix.get(n-1-i).get(j))
                        initialValue = matrix.get(n-1-i).get(j);

                    matrix.get(i).set(j, initialValue);

                    maxSum+= matrix.get(i).get(j);
                }

            }//END OF J
        }//ENF OF I

        return maxSum;
    }
}
