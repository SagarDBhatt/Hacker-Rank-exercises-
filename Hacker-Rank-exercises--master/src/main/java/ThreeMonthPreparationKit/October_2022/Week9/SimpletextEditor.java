/**
 * Follow the operations on the String (Initialize blank at the beginning)
 * 1 abc : Append "abc" to the string.
 * 2 5 : Delete last 5 characters
 * 3 7: Print the 7th character of the String S
 * 4: Undo the last operation happened to String (Mainly 1 & 2).
 *
 * //SI:
 * 8
 * 1 abc
 * 3 3
 * 2 3
 * 1 xy
 * 3 2
 * 4
 * 4
 * 3 1
 *
 * //SO:
 * c
 * y
 * a
 *
 * //
 * 1) Create a function for 1,2, & 3 index.
 */

package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class SimpletextEditor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < q; j++) {
            int choose = input.nextInt();
            switch(choose) {
                case 1:
                    stack.push(sb.toString());
                    String newText = input.next();
                    sb.append(newText);
                    break;
                case 2:
                    stack.push(sb.toString());
                    int k = input.nextInt();
                    sb.delete(sb.length() - k, sb.length());
                    break;
                case 3:
                    int kth = input.nextInt();
                    System.out.println(sb.charAt(kth - 1));
                    break;
                case 4:
                    sb.setLength(0);
                    sb.append(stack.pop());
                    break;
            }
        }
    }

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try{
//            int n = Integer.parseInt(br.readLine());
//            String S = "";
//            Map<Integer, String> resultMap = new HashMap<Integer,String>();
//            resultMap.put(0,"");
//
//
////            IntStream.range(0,n).forEach(i -> {
////                try{
////                    int cnt = 2;
////                    String[] inpArray = br.readLine().split(" ");
////                    switch (Integer.parseInt(inpArray[0])){
////                        case 1:
////                            resultMap.put(i, resultMap.getOrDefault(resultMap.size()-1,"").concat(inpArray[1]));
////                            break;
////                        case 2:
////                            String s = resultMap.get(resultMap.size()-1);
////                            resultMap.put(i,s.substring(0,s.length()-Integer.parseInt(inpArray[1])));
////                            break;
////                        case 3:
////                            System.out.println(resultMap.get(i-1).charAt(Integer.parseInt(inpArray[1])-1));
////                            cnt++;
////                            break;
////                        case 4:
////                            resultMap.put(i, resultMap.get(resultMap.size()-cnt));
////                            break;
////                    }
////                    // performTextEditorOps(inpArray[0], inpArray[1], S);
////                }catch (IOException e){
////                    e.printStackTrace();
////                }
////            });
//            int cnt = 2;
//
//            for(int i =1; i <= n; i++) {
//                try{
//                    String[] inpArray = br.readLine().split(" ");
//                    System.out.println("Input arr = " + Arrays.toString(inpArray));
//                    System.out.println("map begin- " + resultMap.get(i-1));
//                    switch (Integer.parseInt(inpArray[0])){
//                        case 1:
//                            resultMap.put(i, resultMap.getOrDefault(resultMap.size()-1,"").concat(inpArray[1]));
//                            cnt = 2;
//                            break;
//                        case 2:
//                            String s = resultMap.getOrDefault(resultMap.size()-1,"");
////                            System.out.println("String - " + s);
//                            resultMap.put(i,s.substring(0,s.length()-Integer.parseInt(inpArray[1])));
//                            cnt = 2;
//                            break;
//                        case 3:
//                            System.out.println(resultMap.get(resultMap.size()-1).charAt(Integer.parseInt(inpArray[1])-1));
//                            resultMap.put(i,resultMap.get(resultMap.size()-1));
//                            cnt++;
//                            break;
//                        case 4:
//                            resultMap.put(i, resultMap.get(resultMap.size()-cnt));
//                            cnt = 2;
//                            break;
//                    }
//                    System.out.println("map end- " + resultMap.get(i));
//                    // performTextEditorOps(inpArray[0], inpArray[1], S);
//                }catch (IOException e){
//                    e.printStackTrace();
//                }//catch
//            }//for i
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }//main
//
//    private static void performTextEditorOps(String s1, String s2, String S){
//        switch (Integer.parseInt(s1)){
//            case 1:
//                S = appendTheString(S, s2);
//                break;
//            case 2:
//                S = deleteLastNCharacters(S, s2);
//        }
//    }
//
//    private static String appendTheString(String S, String app) {
//        return S.concat(app);
//    }
//
//    private static String deleteLastNCharacters(String S, String len){
//        return S.substring(- Integer.parseInt(len));
//    }

}//class

