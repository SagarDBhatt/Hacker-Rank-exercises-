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

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        //1. Create a list of sub-strings.
        List<String> lsStrings = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                lsStrings.add(s.substring(i, j));
            }
        }
        System.out.println(lsStrings);

        List<String> sortedSubStrings = new ArrayList<String>();
        //2. Sort each substring
        for (String s1 : lsStrings) {
            char[] temp = s1.toCharArray();
            Arrays.sort(temp);
            sortedSubStrings.add(new String(temp));
        }

        System.out.println(sortedSubStrings);
        //3. Match the sorted substring and count.
        int count = 0;
        for (int i = 0; i < sortedSubStrings.size() - 1; i++) {
            for (int j = i + 1; j < sortedSubStrings.size(); j++) {
                if (sortedSubStrings.get(i).equals(sortedSubStrings.get(j))) count++;
            }
        }

        return count;
    }//end of sherlockAndAnagrams

}

public class SherlockAndAnagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

