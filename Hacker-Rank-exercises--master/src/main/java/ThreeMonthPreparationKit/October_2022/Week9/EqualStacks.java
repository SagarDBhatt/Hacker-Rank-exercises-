//Given the three stacks identify the max height that all the stacks are of same height

//Sample input:
//5 3 4
//3 2 1 1 1
//4 3 2
//1 1 4 1

//sample output:
//5

//Please note, the stacks are in opposite direction so stacks should be
// 3
// 2        1
// 1    4   1
// 1    3   4
// 1    2   1


package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class EqualStacks {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] inpString = br.readLine().split(" ");

            List<Integer> h1 = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> h2 = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> h3 = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println(EqualStacksResult.equalStacks(h1,h2,h3));

        }catch(IOException e){
            e.printStackTrace();
        }

    }//end maim
}//

class EqualStacksResult {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

//    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
//        //Prepare 3 stacks from the input.
//        Stack<Integer> s1 = new Stack<>();
//        Collections.reverse(h1);
//        s1.addAll(h1);
////        for(int i = h1.size()-1; i >=0; i--){
////            s1.push(h1.get(i));
////        }
//
//        Stack<Integer> s2 = new Stack<>();
//        Collections.reverse(h2);
//        s2.addAll(h2);
////        for(int i = h2.size()-1; i>=0; i--){
////            s2.push(h2.get(i));
////        }
//
//        Stack<Integer> s3 = new Stack<Integer>();
//        Collections.reverse(h3);
//        s3.addAll(h3);
////        for(int i = h3.size()-1; i >= 0; i--){
////            s3.push(h3.get(i));
////        }
//
//        //set the minimum height:
//
////        int he1 = findTheHeightOfStack(s1);
////        int he2 = findTheHeightOfStack(s2);
////        int he3 = findTheHeightOfStack(s3);
//        int he1 = s1.stream().reduce(0, (x,y) -> x+y);
//        int he2 = s2.stream().reduce(0, (x,y) -> x+y);
//        int he3 = s3.stream().reduce(0, (x,y) -> x+y);
//
//        int minHeight = Math.min(Math.min(he1, he2),he3);;
//
//        // Create a function to find the height of the stack
//        while(he1 != he2 || he2 != he3) {
//            minHeight = Math.min(Math.min(he1, he2),he3);
//
//            while (he1 > minHeight) {
//                s1.pop();
//                he1 = s1.stream().reduce(0, (x,y) -> x+y);
//            }
//
//            while (he2 > minHeight) {
//                s2.pop();
//                he2 = s2.stream().reduce(0, (x,y) -> x+y);
//            }
//
//            while (he3 > minHeight) {
//                s3.pop();
//                he3 = s3.stream().reduce(0, (x,y) -> x+y);
//            }
//        }
//
//        return minHeight;
//
//    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Collections.reverse(h1);
        Collections.reverse(h2);
        Collections.reverse(h3);

        int he1 = h1.stream().reduce(0, (x,y) -> x+y);
        int he2 = h2.stream().reduce(0, (x,y) -> x+y);
        int he3 = h3.stream().reduce(0, (x,y) -> x+y);

        int minHeight = Math.min(Math.min(he1, he2),he3);

        // Create a function to find the height of the stack
        while(he1 != he2 || he2 != he3) {
            minHeight = Math.min(Math.min(he1, he2),he3);

            while (he1 > minHeight) {
                he1 -= h1.get(h1.size()-1);
                h1.remove(h1.size()-1);
            }

            while (he2 > minHeight) {
                he2 -= h2.get(h2.size()-1);
                h2.remove(h2.size()-1);
            }

            while (he3 > minHeight) {
                he3 -= h3.get(h3.size()-1);
                h3.remove(h3.size()-1);
            }
        }

        return minHeight;

    }

    public static int findTheHeightOfStack(Stack<Integer> s){
        return s.stream().reduce(0, (x,y) -> x+y);
    }
}