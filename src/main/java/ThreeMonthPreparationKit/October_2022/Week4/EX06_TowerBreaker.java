/**
 * Two players are playing a game of Tower Breakers! Player  always moves first, and both players always play optimally.The rules of the game are as follows:
 *
 * Initially there are  towers.
 * Each tower is of height .
 * The players move in alternating turns.
 * In each turn, a player can choose a tower of height  and reduce its height to , where  and  evenly divides .
 * If the current player is unable to make a move, they lose the game.
 * Given the values of  and , determine which player will win. If the first player wins, return . Otherwise, return .
 *
 * Example.
 *
 * There are  towers, each  units tall. Player  has a choice of two moves:
 * - remove  pieces from a tower to leave  as
 * - remove  pieces to leave
 *
 * Let Player  remove . Now the towers are  and  units tall.
 *
 * Player  matches the move. Now the towers are both  units tall.
 *
 * Now Player  has only one move.
 *
 * Player  removes  pieces leaving . Towers are  and  units tall.
 * Player  matches again. Towers are both  unit tall.
 *
 * Player  has no move and loses. Return .
 *
 * Function Description
 *
 * Complete the towerBreakers function in the editor below.
 *
 * towerBreakers has the following paramter(s):
 *
 * int n: the number of towers
 * int m: the height of each tower
 * Returns
 *
 * int: the winner of the game
 * Input Format
 *
 * The first line contains a single integer , the number of test cases.
 * Each of the next  lines describes a test case in the form of  space-separated integers,  and .
 *
 * Constraints
 *
 * Sample Input
 *
 * STDIN   Function
 * -----   --------
 * 2       t = 2
 * 2 2     n = 2, m = 2
 * 1 4     n = 1, m = 4
 * Sample Output
 *
 * 2
 * 1
 * Explanation
 *
 * We'll refer to player  as  and player  as
 *
 * In the first test case,  chooses one of the two towers and reduces it to . Then  reduces the remaining tower to a height of . As both towers now have height ,  cannot make a move so  is the winner.
 *
 * In the second test case, there is only one tower of height .  can reduce it to a height of either  or .  chooses  as both players always choose optimally. Because  has no possible move,  wins.
 */

//Sample InpuT:
//        2
//        2 2
//        1 4
//
//        Sample Output:
//        1
//        1
//


package ThreeMonthPreparationKit.October_2022.Week4;

import java.io.*;
import java.util.stream.IntStream;

public class EX06_TowerBreaker {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = ResultBreakTower.towerBreakers(n, m);

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

class ResultBreakTower {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        // Write your code here
        if(m == 1){
            return 2;
        }
        return n % 2 == 0 ? 2 : 1;
    }

}