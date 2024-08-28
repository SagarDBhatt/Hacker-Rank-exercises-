/**
 * For any given year, the 256th day is considered as the day of the Programmer. Given the year, find the 256th day and retrun as DD.MM.YYYY format.
 *
 * We are given 2 calendar systems - Julian (1700 - 1917) & Gregorian (1918 - now)
 * In Julian calendar Leap year = Any year / 4.
 * In Gregorian Calendar Leap year = Any year / 400 OR year/4 but not 100;
 */


package ProblemSolvingModuleHackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class DayOfTheProgrammer {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int year = Integer.parseInt(br.readLine());
            System.out.println(DayOfTheProgrammerResult.getDayOfTheProgrammer(year));
        }catch (IOException e){
            e.printStackTrace();
        }

    }//main
}//class

class DayOfTheProgrammerResult{
    public static String getDayOfTheProgrammer(int year){
        final int FIRST_SIX_MONTH_DAYS_NON_LEAP_YEAR = 243;
        final int FIRST_SIX_MONTH_DAYS_LEAP_YEAR = 244;
        final int FIRST_SIX_MONTH_DAYS_LEAP_YEAR_1918 = 230;
        String result = "";

        //Find the year is Julian or Gregorian.
        Predicate<Integer> isGregorianCalendar = y -> y > 1918;

        //Find if the year is leap year in Gregorian calendar.
        Predicate<Integer> isGregorianLeapYear = y -> (y % 4 == 0 && y % 100 != 0)  || (y % 400 == 0);

        Predicate<Integer> isJulianLeapYear = y -> y%4==0;

        if(year == 1918){
            result = 256 - FIRST_SIX_MONTH_DAYS_LEAP_YEAR_1918 + "." + "09." + year;
        }
        else if(isGregorianCalendar.and(isGregorianLeapYear).test(year) || (isJulianLeapYear.test(year) && isGregorianCalendar.negate().test(year))) {
            result = 256 - FIRST_SIX_MONTH_DAYS_LEAP_YEAR + "." + "09." + year;
        }
        else {
            result = 256 - FIRST_SIX_MONTH_DAYS_NON_LEAP_YEAR + "." + "09." + year;
        }

        return result;
    }
}
