package ThreeMonthPreparationKit.October_2022.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StockMaximize {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int t = Integer.parseInt(br.readLine());

            IntStream.range(0,t).forEach(i -> {
                try{
                    int n = Integer.parseInt(br.readLine());
                    List<Integer> dailyListPrice = Arrays.stream(br.readLine().split(" "))
                            .map(j -> Integer.parseInt(j))
                            .collect(Collectors.toList());
                    long maxProfit = StockMaximizeResult.stockmax(dailyListPrice);
                    System.out.println(maxProfit);
                }catch (IOException e){
                    e.printStackTrace();
                }
            });
        }catch(IOException e){
            e.printStackTrace();
        }

    }//main

}//end of class

class StockMaximizeResult {

    /*
     * Complete the 'stockmax' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static long stockmax(List<Integer> prices) {
        // Write your code here
        // Find the max val of the list and find the index. If the index of max val is 0 then no profit can be made and return 0.
        // else profit can be made. Sell the stock at the max index.
        // Corner case, need to check the max index for the remaining sub-list after max index to verify the another opportunity.
        long profit = 0L;

        int maxIndex = prices.indexOf(Collections.max(prices));
        if(maxIndex == 0)return 0;
        else if(maxIndex == prices.size()-1){
            return getProfitFromSubList(prices);
        }
        else{
            List<Integer> subList1 = prices.subList(0,maxIndex+1);
            List<Integer> subList2 = prices.subList(maxIndex+1, prices.size());

            profit = getProfitFromSubList(subList1);
            profit += stockmax(subList2);
        }


        return profit;

    }//method

    public static long getProfitFromSubList(List<Integer> subList){
        long costPrice = 0L;
        int cnt = 0;

        for(int i =0; i < subList.size()-1; i++){
            costPrice += subList.get(i);
            cnt++;
        }
        long sellPrice = subList.get(subList.size()-1) * cnt;
        return sellPrice-costPrice;
    }

}
