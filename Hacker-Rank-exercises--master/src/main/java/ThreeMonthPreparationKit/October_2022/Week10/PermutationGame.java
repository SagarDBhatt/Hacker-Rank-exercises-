package ThreeMonthPreparationKit.October_2022.Week10;

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

class ResultPermutationGame {

    static HashMap<ArrayList<Integer>, String> result = new HashMap<ArrayList<Integer>, String>();
    public static String permutationGame(List<Integer> arr) {
        // Write your code here
        if(result.containsKey(arr))
            return result.get(arr);
        int l = arr.size();
        for(int i=0; i<l; i++){
            int val = arr.remove(i);
            if(isSorted(arr)){
                arr.add(i, val);
                result.put(new ArrayList<>(arr),"Alice");
                return "Alice";
            }
            if(permutationGame(arr).equals("Bob")){
                arr.add(i, val);
                result.put(new ArrayList<>(arr),"Alice");
                return "Alice";
            }
            arr.add(i, val);
        }
        result.put(new ArrayList<>(arr),"Bob");
        return "Bob";
    }

    public static boolean isSorted(List<Integer> list){
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i)>list.get(i+1))
                return false;
        }
        return true;
    }

}

public class PermutationGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = ResultPermutationGame.permutationGame(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
