package ThreeMonthPreparationKit.October_2022.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EX03_XOR_Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inpStr1 = bufferedReader.readLine().toString();
        String inpStr2 = bufferedReader.readLine().toString();

        //APPROACH 1:
        int[] strArray = IntStream.range(0,inpStr1.length())
                                .map(i -> inpStr1.charAt(i)==inpStr2.charAt(i)?0:1)
                                .toArray();

        //APPROACH 2:
//        int[] strArray = IntStream.range(0,inpStr1.length())
//                .map(i -> {
//                    if(inpStr1.charAt(i) == inpStr2.charAt(i)) return 0;
//                    else return 1;
//                })
//                .toArray();

        Arrays.stream(strArray).forEach(System.out::print);
    }
}
