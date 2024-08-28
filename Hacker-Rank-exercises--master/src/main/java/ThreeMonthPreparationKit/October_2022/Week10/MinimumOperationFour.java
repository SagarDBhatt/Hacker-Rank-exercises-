/**
 * We are given n number of boxes and each box has certain numbers of R G B color balls. We need to shift one boll at a time to
 * shift in such a way, all boxes has only single color.
 */

//SI
//3
//1 1 1
//1 1 1
//1 1 1

//SO
//6

//4
//4 7 6
//6 4 5
//5 6 3
//7 3 8

//SO
//37

package ThreeMonthPreparationKit.October_2022.Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

public class MinimumOperationFour {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> boxes = new LinkedList<>();

        try {
            int n = Integer.parseInt(br.readLine());
            IntStream.range(0,n).forEach(i -> {
                try{
                    boxes.add(
                            Arrays.stream(br.readLine().split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList())
                    );
                }catch (IOException e){
                    e.printStackTrace();
                }
            });

            System.out.println(MinimumOpsUitilty.getMinimumOps(boxes));
        }catch(IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class MinimumOpsUitilty{

    public static int getMinimumOps(List<List<Integer>> box){
        if(box.size() < 3)return -1;

        int result = 0;

        for(int i = 0; i < box.size(); i++){

            for(int j = 0; j < box.get(i).size(); j++){

                //Reduce the G and B balls
                if( i != j){
                    while (box.get(i).get(j) != 0) {
                        //Remove the ball and update the count.
                        box.get(i).add(j, box.get(i).get(j) - 1);
                        box.get(i).remove(j + 1);

                        box.get(i).add(i, box.get(i).get(i) + 1);
                        box.get(i).remove((i%3) + 1);

                        result++;
                    }
                }


            }//J

        }//I

        if(result == 0)return -1;
        return result;
    }

}
