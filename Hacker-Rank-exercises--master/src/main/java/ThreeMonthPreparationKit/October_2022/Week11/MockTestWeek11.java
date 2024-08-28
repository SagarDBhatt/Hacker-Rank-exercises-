package ThreeMonthPreparationKit.October_2022.Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockTestWeek11 {

    public static void main(String[] args) {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        try{
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            List<List<Integer>> list = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                try {
                    List<Integer> inp = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                    list.add(inp);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            int result = MockTestWeek11Result.connectedCell(list);
        }catch (IOException e){
            e.printStackTrace();
        }


    }//main

}//class

class MockTestWeek11Result {
    //5
    //5
    //1 1 0 0 0
    //0 1 1 0 0
    //0 0 1 0 1
    //1 0 0 0 1
    //0 1 0 1 1

    //SO = 5

    public static int connectedCell(List<List<Integer>> matrix) {
        //Given the matrix, create the map
        return 0;
    }

}