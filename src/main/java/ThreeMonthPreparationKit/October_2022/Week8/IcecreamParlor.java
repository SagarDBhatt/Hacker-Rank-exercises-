package ThreeMonthPreparationKit.October_2022.Week8;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultIcecreamParlor {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // iterate the array with 2 loops to identify each elements combination to
        // fetch the total of the ice cream.
        List<Integer> resultList = new ArrayList<Integer>();
        for(int i = 0; i < arr.size()-1; i++){
            for(int j = i+1; j < arr.size(); j++){
                int temp = 0;
                temp += arr.get(i) + arr.get(j);
                if(temp == m){
                    resultList.add(i+1);
                    resultList.add(j+1);
                    break;
                }
            }
        }//end of i

        return resultList;
    }//end of method
}

public class IcecreamParlor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(bufferedReader.readLine());

        IntStream.range(0,testcases).forEach(i -> {
            try{
                int money = Integer.parseInt(bufferedReader.readLine());
                int n = Integer.parseInt(bufferedReader.readLine());
                List<Integer> inputList = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                List<Integer> resultList = ResultIcecreamParlor.icecreamParlor(money, inputList);

                for(int val : resultList){
                    System.out.print(val);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        });


//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                int m = Integer.parseInt(bufferedReader.readLine().trim());
//
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                List<Integer> result = Result.icecreamParlor(m, arr);
//
//                bufferedWriter.write(
//                        result.stream()
//                                .map(Object::toString)
//                                .collect(joining(" "))
//                                + "\n"
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
