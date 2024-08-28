/**
 * Given the list of foods, find out if Anna got charged correctly OR she should receive money back.
 * First line contains number of food items and the food Anna didnt eat.
 * 2nd line contains the list of items.
 * Third line contains the bill that Anna got charged.
 */

//4 1
//3 10 2 9
//12

//5

//4 1
//3 10 2 9
//7

//Bon Appetit


package ProblemSolvingModuleHackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BillDivision {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Integer min = Integer.MAX_VALUE;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        int n = stack.pop();
//        int n1 = stack.peek();
//        int i = stack.stream().min((i1,i2) -> i1-i2).get();

//        int[] arr = {1,2,3,4,5,6,7,8,9};
//        Integer[] intArr = Arrays.stream(arr).boxed().toArray(i -> new Integer[i]);
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        };
//        Arrays.sort(intArr, comparator);
//        Arrays.stream(intArr).forEach(System.out::println);
//
//        Comparator comparator1 = (i1, i2) -> Integer.parseInt(i1.toString()) - Integer.parseInt(i2.toString());
//        Arrays.sort(intArr, Collections.reverseOrder());

        try{
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            List<Integer> foodBills = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
            int billCharged = Integer.parseInt(br.readLine());

            BillDivisionResult.bonAppetit(foodBills, k, billCharged);
        }catch (IOException e){
            e.printStackTrace();
        }
    }//main
}//class

class BillDivisionResult {

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int expectedCost = 0;

        for(int i = 0; i < bill.size(); i++){
            if(i!=k)expectedCost+=bill.get(i);
        }

        if(b != expectedCost/2) System.out.println(b - expectedCost/2);
        else System.out.println("Bon Appetit");
    }

}
