/**
 * Given the array find the highest element and remove the all elements right of it. Whoever has the last element, wins the game.
 *
 * Bob takes the first chance.
 *
 * Pseudocode:
 * 1. Find the highest element of the Array and array index. Remove the element till the end of the array.
 * 2. Perform  the same till the index 0. Who's turn is that wins.
 *
 * Sample input:
 * 2
 * 5
 * 5 2 6 3 4
 * 2
 * 3 1
 *
 * Sample Output:
 * ANDY
 * BOB
 */


package ThreeMonthPreparationKit.October_2022.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex04_GamingArray {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int tc = Integer.parseInt(br.readLine());
            IntStream.range(0, tc).forEach(i -> {
                try{
                    int n = Integer.parseInt(br.readLine());
                    List<Integer> inList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                    System.out.println(ResultGamingArray1.gamingArray(inList));
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

class ResultGamingArray1 {

    /*
     * Complete the 'gamingArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String gamingArray(List<Integer> arr) {
        // Write your code here
        int counter = 0;
        while(arr.size() != 1){
            int max = arr.stream().reduce((x,y) -> x > y ? x : y).get();
            int ind = arr.indexOf(max);
            if(arr.indexOf(max) == 0)break;
            IntStream.range(arr.indexOf(max), arr.size()).forEach(i -> arr.remove(ind));
            //arr = removeTheElement(arr, arr.indexOf(max));
            counter++;
        }

        if(counter%2==0)return "BOB";
        else return "ANDY";
    }

    public static List<Integer> removeTheElement(List<Integer> arr, int index){
        IntStream.range(index, arr.size()-1).forEach(i -> arr.remove(i));
        return arr;
    }
}

//2
//5
//5 2 6 3 4
//2
//3 1