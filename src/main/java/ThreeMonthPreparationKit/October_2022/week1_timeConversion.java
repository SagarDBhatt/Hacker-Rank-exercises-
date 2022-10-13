/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 *
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 *
 * Example
 *
 *
 * Return '12:01:00'.
 *
 *
 * Return '00:01:00'.
 *
 * Function Description
 *
 * Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
 *
 * timeConversion has the following parameter(s):
 *
 * string s: a time in  hour format
 * Returns
 *
 * string: the time in  hour format
 * Input Format
 *
 * A single string  that represents a time in -hour clock format (i.e.:  or ).
 *
 * Constraints
 *
 * All input times are valid
 * Sample Input
 *
 * 07:05:45PM
 * Sample Output
 *
 * 19:05:45
 */


package ThreeMonthPreparationKit.October_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week1_timeConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputtime = bufferedReader.readLine();

        Result.convertMilitaryTime(inputtime);
    }//EOF Main
}//EOF class


class Result{

    public static void convertMilitaryTime(String inputTime){

        String[] splitTime = inputTime.split(":");

        String hourClock = splitTime[0];
        String minuteClock = splitTime[1];
        String secondClock = splitTime[2].substring(0,2);

        String timePreference = splitTime[splitTime.length-1].substring(2);
//        System.out.println(timePreference);

        String newHour = "";
        if(timePreference.equals("AM")){
            if(Integer.parseInt(hourClock) == 12) newHour = "00";
            //else newHour = String.valueOf(Integer.parseInt(hourClock));
            else newHour = hourClock;
            String newMilitaryTime = newHour + ":" + minuteClock +":" + secondClock;
            System.out.println(newMilitaryTime);
        }
        else{
            if(Integer.parseInt(hourClock) == 12) newHour = hourClock;
            else newHour= String.valueOf(Integer.parseInt(hourClock) + 12);
            String newMilitaryTime = newHour + ":" + minuteClock +":" + secondClock;
            System.out.println(newMilitaryTime);
        }

    }
}
