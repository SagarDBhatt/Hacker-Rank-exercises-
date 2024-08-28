package EasyLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BreakingTheRecord {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            List<Integer> scoresList = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println(BRSolution.findTheMaxMinRecordBreak(scoresList));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class BRSolution{
    public static List<Integer> findTheMaxMinRecordBreak(List<Integer> scores){
        int MaxScore = scores.get(0);
        int MinScores = scores.get(0);

        List<Integer> records = new ArrayList<>();
        records.add(0,0);
        records.add(1,0);

        for(int score : scores){

            if(score > MaxScore){
                records.set(0, records.get(0) + 1);
                MaxScore = score;
            }
            if (score < MinScores){
                records.set(1, records.get(1)+1);
                MinScores = score;
            }

        }

        return records;
    }
}
