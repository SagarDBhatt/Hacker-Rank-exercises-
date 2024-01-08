/**
 * Given the brackets find the brackets are balance i.e. Opening and
 * closing of the brackets are matching.
 *
 * For eg:
 * [ ( ) ] : This is balanced as the opening and closing brackets are matching.
 *
 * Sample input:
 * 3
 * {[()]}
 * {[(])}
 * {{[[(())]]}}
 *
 * Sample output:
 * YES
 * NO
 * YES
 */

package ThreeMonthPreparationKit.October_2022.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class BalancedBrackets {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            IntStream.range(0, n).forEach(i -> {
                try{
                    String s = br.readLine();
                    System.out.println(ResultBalancedBrackets.isBalanced(s));
                }catch (IOException e){
                    e.printStackTrace();
                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }//end main
}//end class

class ResultBalancedBrackets {

    public static String isBalanced(String s) {
        //1. If len of s is odd then return NO
        if(s.length() % 2 != 0)return "NO";

        //Create a Map to match the open and close bracket:
        Map<String,String> map = new HashMap<String,String>();
        map.put("(", ")");
        map.put("{","}");
        map.put("[","]");

        //Create a stack to enter a opening brackets.
        Stack<Character> stack = new Stack<>();

//        for(int i = (s.length()/2)-1; i >= 0; i--) {
        for(int i = 0; i < s.length(); i++) {
            char open = s.charAt(i);

            //Add the open brackets in the stack
            if (map.containsKey(String.valueOf(open))) stack.push(open);

                //If the char is close bracket then validate if the latest value in stack is matching open bracket or not.
                //If yes then remove the matching open bracket else leave.
            else if (!stack.empty() && map.get(String.valueOf(stack.peek())).equals(String.valueOf(open))) {
                stack.pop();
            }
        }
            //if the stack is empty then return "YES" else "NO"
            String result = stack.empty() ? "YES" : "NO";

            return result;
//            if(String.valueOf(close).equals(map.get(String.valueOf(open))))continue;
//            else{
//                return "NO";
//            }
//        }
//        return "YES";
    }

}
