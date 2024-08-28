/**
 * Task is to given the adjacent buildings with the heights, Find the maximum size of rectangle of len and width
 * return len * width.
 */

//SI
//5
//1 2 3 4 5

//SO
//9
package ThreeMonthPreparationKit.October_2022.Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestRectangle {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            int testCases = Integer.parseInt(br.readLine());
            List<Integer> inpList = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println(ResultLargestRectangle.largestRectangle(inpList));
        }catch(IOException e){
            e.printStackTrace();
        }

    }//end of main

}//end of LargestRectangle

class ResultLargestRectangle {

    public static long largestRectangle(List<Integer> h) {
        //1. Iterate the list of height. Set the max height of the building as first element.
        // then check the height difference to the adjacent building.
        // If the height is same or more, then go to next building.
        //Each time find the max rectangle and update the value.
        long maxRectangle = 0L;

        for(int i = 0; i < h.size(); i++){
            int maxHt = h.get(i);
            int maxlen = 1;
            for(int j = i+1; j < h.size(); j++){
                if(h.get(j) - h.get(j-1) < 0){
                    if(maxHt > h.get(j))maxHt = h.get(j);
                }
                maxlen+= 1;
                if(maxRectangle < maxHt*maxlen) maxRectangle = maxHt*maxlen;
            }
        }
        return maxRectangle;
    }

}
