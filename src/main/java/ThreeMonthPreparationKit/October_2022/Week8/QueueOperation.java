/**
 * Sample input:
 * 10
 * 1 42
 * 2
 * 1 14
 * 3
 * 1 28
 * 3
 * 1 60
 * 1 78
 * 2
 * 2
 *
 * Sample Output:
 * 14
 * 14
 */

package ThreeMonthPreparationKit.October_2022.Week8;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class QueueOperation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            int queries = Integer.parseInt(br.readLine());
            String[] queue = new String[queries];

            IntStream.range(0,queries).forEach(i -> {
                try{
                    String[] operation = br.readLine().split(" ");
                    SolutionQueueOps.queueOps(operation, queue);
                }catch(IOException e){
                    e.printStackTrace();
                }
            });
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

class SolutionQueueOps{
    public static int head = -1;
    public static int tail = -1;

    public static void queueOps(String[] inpArray, String[] queue){
        //System.out.println(Arrays.toString(inpArray));

        //enque ops
        if(inpArray[0].equals("1")){
            if(tail == queue.length){
                System.out.println("Queue is full.");
            }else if(head == -1 && tail == -1){
                head = 0;
                tail = 0;
                queue[head] = inpArray[1];
            }
            else{
                tail++;
                queue[tail] = inpArray[1];
            }
        }//enque ops

        //deque ops
        if(inpArray[0].equals("2")){
            if(head == -1){
                System.out.println("Queue is empty");
            }
            else if(head == tail){
                head = -1;
                tail = -1;
            }
            else{
                head++;
            }
        }

        //peek element
        if(inpArray[0].equals("3")){
            System.out.println(queue[head]);
        }
        //System.out.println(Arrays.toString(queue));
    }//queueOps

    // public static void enQueueOps(String val, String[] queue, int head, int tail){
    //     if(SolutionQueueOps.isFull(queue, head, tail)){
    //         System.out.println("Queue full.");
    //     }
    // }//enQueueOps

    // public static boolean isFull(String[]queue, int head, int tail){
    //     if(tail == )
    // }

}//class