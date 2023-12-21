package ThreeMonthPreparationKit.October_2022.Week7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Week7_FinalTest {

    public static void main(String[] args) {
        List<String> inputStr = new ArrayList<String>(List.of("1","200","50"
                , "3", "31415926535897932384626433832795"
                ,"581194376","6402415616","8931048918", "51", "52", "53", "44","82"
        ,"91478800","63593696","86212388"));
//
//        System.out.println(ResultFindBigSort.bigSorting(inputStr));
//        System.out.println(ResultFindBigSort.bigSorting2(inputStr));
        System.out.println(ResultFindBigSort.bigSorting3(inputStr));
    }//main
}//endofclass

class ResultFindBigSort {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    public static List<String> bigSorting(List<String> unsorted) {
        // Write your code here
        //Convert each character to Array.
        List<BigInteger> longList = unsorted.stream()
                .map(BigInteger::new)
                .sorted()
                .collect(Collectors.toList());

//        System.out.println(longList);

        List<String> resultString = longList.stream().map(i -> String.valueOf(i)).collect(Collectors.toList());

        return resultString;
    }

    /**
     * This is efficient solution with fewer lines of codes but the time complexity is higher.
     * Need to find the additional solution with the less time complexity.
     * @param unsorted
     * @return
     */
    public static List<String> bigSorting2(List<String> unsorted) {
        // Write your code here
        //Convert each character to Array.
        List<String> resultString = unsorted.stream()
                .map(BigInteger::new)
                .sorted()
                .map(i -> String.valueOf(i))
                .collect(Collectors.toList());

        return resultString;
    }

    public static List<String> bigSorting3(List<String> unsorted) {
        // Write your code here
        //Create a comparator class to compare the length of the string and sort them.
//        Comparator<String> comparator1 = (o1, o2) -> {
//            if(o1.length() != o2.length()){
//                return o1.length() - o2.length();
//            }
//            else{
//                return new BigInteger(o1).equals(new BigInteger(o2));
//            }
//        };

        Comparator<String> comparator1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                }
                else{
                    return new BigInteger(o1).compareTo(new BigInteger(o2));
                }
            }
        };

        unsorted.sort(comparator1);
        System.out.println(unsorted);

        return unsorted;
    }

}