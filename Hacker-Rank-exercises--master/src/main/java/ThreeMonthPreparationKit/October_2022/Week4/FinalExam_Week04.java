/**
 * Find anagram:
 *
 * 1. Given a string -> Divide into 2 equal sub-strings. (length/2). If not even numbers then return -1.
 * 2. if even number -> Check how many characters are matching in both sub strings.
 * 2.1 If the character is matching then remove is from list so it wont count again.
 * 3. If none characters are matching then return the length of the string.
 * 4. If 1 char matches -> return length - 1 ect...
 *
 */


package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class FinalExam_Week04 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = ResultAnagram.anagram(s);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}

    class ResultAnagram {

        /*
         * Complete the 'anagram' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts STRING s as parameter.
         */

        public static int anagram(String s) {
            // Write your code here

            if(s.length()%2!=0){
                return  -1;
            }
            else{
                String subStr = s.substring(0, s.length()/2);
                String subStr2 = s.substring(s.length()/2, s.length());
                int counter = 0;

                for(int i = 0; i < subStr.length(); i++){
                    if(subStr2.contains(Character.toString(subStr.charAt(i)))){
                        subStr2 = subStr2.replaceFirst(Character.toString(subStr.charAt(i)),"");
                        counter++;
                    }
                }
                return subStr.length()-counter;
            }
        }
    }