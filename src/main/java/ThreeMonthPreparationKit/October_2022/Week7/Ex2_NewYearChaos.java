/**
 * Given the queue with index, check how many swaps are needed to change the queue with the given value.
 */


package ThreeMonthPreparationKit.October_2022.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex2_NewYearChaos {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int testCases = Integer.parseInt(br.readLine());
            IntStream.range(0,testCases).forEach(i -> {
                try{
                    int n = Integer.parseInt(br.readLine());
                    try {
                        List<Integer> integerList = Arrays.stream(br.readLine().split(" "))
                                    .map(Integer::parseInt).collect(Collectors.toList());
                            ResultNYChaos.minimumBribes(integerList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch (IOException e){
                    e.getMessage();
                }
            });
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }//main
}//class

class ResultNYChaos {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int[] persons = {1, 2, 3};
        int brides = 0;
        for(int i = 0; i < q.size(); i++){
            if(q.get(i) == persons[0]){
                persons[0] = persons[1];
                persons[1] = persons[2];
                persons[2]++;
            }else if(q.get(i) == persons[1]){
                persons[1] = persons[2];
                persons[2]++;
                brides++;
            }else if(q.get(i) == persons[2]){
                persons[2]++;
                brides += 2;
            }else{
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(brides);
    }

}
//2
//5
//2 1 5 3 4
//5
//2 5 1 3 4