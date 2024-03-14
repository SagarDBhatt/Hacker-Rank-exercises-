/**
 * Given the list of operations.Perform the below query.
 *
 * There are  types of query:
 *
 * "1 v" - Add an element  to the heap.
 * "2 v" - Delete the element  from the heap.
 * "3" - Print the minimum of all the elements in the heap.
 *
 * We need to use "PriorityQueue" and pass the comparator to perform the ascending ops.This will help us Find the minimum element of the heap memory.
 */

//SI
//5
//1 4
//1 9
//3
//2 4
//3

//SO
//4
//9

package ThreeMonthPreparationKit.October_2022.Week10;

import java.io.*;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class PriorityQueurOps {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        try {
            int queries = Integer.parseInt(br.readLine());
            IntStream.range(0,queries)
                    .forEach(i -> {
                        try {
                            String[] inp = br.readLine().split(" ");
                            if(Integer.parseInt(inp[0]) == 1){
                                addElementToPrioryQueue(priorityQueue,Integer.parseInt(inp[1]));
                            }
                            else if(Integer.parseInt(inp[0]) == 2){
                                removeElementFromPriorityQueue(priorityQueue, Integer.parseInt(inp[1]));
                            }else {
                                System.out.println(priorityQueue.peek());
                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    });
        }catch(IOException e){
            e.printStackTrace();
        }
    }//end of main

    public static PriorityQueue<Integer> addElementToPrioryQueue(PriorityQueue<Integer> pq, Integer ele){
        pq.add(ele);
        return pq;
    }

    public static PriorityQueue<Integer> removeElementFromPriorityQueue(PriorityQueue<Integer> pq, Integer ele){
        if(pq.contains(ele)){
            pq.remove(ele);
        }
        return pq;
    }

}//end of class
