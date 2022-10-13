/**
 * Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates the number of times she breaks her season record for most points and least points in a game. Points scored in the first game establish her record for the season, and she begins counting from there.
 *
 * Example
 *
 * Scores are in the same order as the games played. She tabulates her results as follows:
 *
 *                                      Count
 *     Game  Score  Minimum  Maximum   Min Max
 *      0      12     12       12       0   0
 *      1      24     12       24       0   1
 *      2      10     10       24       1   1
 *      3      24     10       24       1   1
 * Given the scores for a season, determine the number of times Maria breaks her records for most and least points scored during the season.
 *
 * Function Description
 *
 * Complete the breakingRecords function in the editor below.
 *
 * breakingRecords has the following parameter(s):
 *
 * int scores[n]: points scored per game
 * Returns
 *
 * int[2]: An array with the numbers of times she broke her records. Index  is for breaking most points records, and index  is for breaking least points records.
 * Input Format
 *
 * The first line contains an integer , the number of games.
 * The second line contains  space-separated integers describing the respective values of .
 *
 * Constraints
 *
 */

/**
 * Simple Description: User needs to find the Count of Maximum and Minimum times she breaks the record for the highest and lowest score.
 * Input:
 * 9
 * 10 5 20 20 4 5 2 25 1
 *
 * Output:
 * 2 4 [Record for Highers score | Record for lowest score]
 *
 *
 */

package ThreeMonthPreparationKit.October_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Week1_04_BreakingRecord {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num_of_seasons = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> list_seasons_score = Stream.of(bufferedReader.readLine().split(" ")).map(obj -> Integer.parseInt(obj)).collect(Collectors.toList());

        System.out.println(list_seasons_score);
        solution.findRecordsBreakingCount(list_seasons_score);
    }//EOF MAIN
}// EOF Class

class solution{
    public static void findRecordsBreakingCount(List<Integer> seasonsScore){
        int highestScoreRecord = seasonsScore.get(0);
        int lowestScoreRecord = seasonsScore.get(0);
        int highestCount = 0;
        int lowestCounter = 0;

        List<Integer> updatedSeasonScores = new ArrayList<>();

        for(int score : seasonsScore){
            if(score > highestScoreRecord){
                highestScoreRecord = score;
                highestCount++;
            }
            if(score < lowestScoreRecord){
                lowestScoreRecord = score;
                lowestCounter++;
            }
        }//EOF FOR
        List<Integer> answer = new ArrayList<>();
        answer.add(highestCount);
        answer.add(lowestCounter);
    }//EOF find method
}//EOF CLASS