/**
 * Simple problem explanation.
 *
 * Given a date in dd-mm-yyyy format, concatenate the date to ddmmyyyy format. Find all the possible dates
 * between the 2 given dates (both inclusive). Now, convert the each date string to number. If the resulting number can
 * be divide by 4 or 7 then the number is lucky date. Find the count of the total lucky dates between
 * the 2 dates.
 *
 * Pseudocode:
 * 1. Given the date, create the regex to fetch the dd, mm & yyyy.
 * 2. Based on the date, month and year, find all the possible dates between 2 dates inclusive.
 * 3.Then create the number from each string date.
 * 4. Divide the number and see if the number can be divisible by 4 or 7. If yes, find the total count
 * of the lucky date and print
 *
 * Sample Input:
 * 02-08-2025 04-09-2025
 *
 * Sample output:
 * 5
 */


package ThreeMonthPreparationKit.October_2022.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Week6_Ex1_PrimeDates {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            List<String> inputDates = Stream.of(br.readLine().split(" ")).collect(Collectors.toList());

            List<Integer> firstDate = Arrays.stream(inputDates.get(0).split("-")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> secondDate = Arrays.stream(inputDates.get(1).split("-")).map(Integer::parseInt).collect(Collectors.toList());

            int result = LuckyDate.findPrimeDates(firstDate.get(0), firstDate.get(1), firstDate.get(2),
                    secondDate.get(0), secondDate.get(1), secondDate.get(2));

            System.out.println(result);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

class LuckyDate{

    public static int month[] = new int[13];

    public static void updateLeapYear(int year) {
        if(year % 400 == 0) {
            month[2] = 28;
        } else if(year % 100 == 0) {
            month[2] = 29;
        } else if(year % 4 == 0) {
            month[2] = 29;
        } else {
            month[2] = 28;
        }
    }

    public static void storeMonth() {
        month[1] = 31;
        month[2] = 28;
        month[3] = 31;
        month[4] = 30;
        month[5] = 31;
        month[6] = 30;
        month[7] = 31;
        month[8] = 31;
        month[9] = 30;
        month[10] = 31;
        month[11] = 30;
        month[12] = 31;
    }

    public static int findPrimeDates(int d1, int m1, int y1, int d2, int m2, int y2) throws ParseException {
        int counter = 0;

        String date1 = String.valueOf(d1).concat("-").concat(String.valueOf(m1)).concat("-").concat(String.valueOf(y1));
        String date2 = String.valueOf(d2).concat("-").concat(String.valueOf(m2)).concat("-").concat(String.valueOf(y2));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat newSDF = new SimpleDateFormat("ddMMyyyy");
        Date newDate1 = simpleDateFormat.parse(date1);
        Date newDate2 = simpleDateFormat.parse(date2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate1);

        while(newDate1.compareTo(newDate2) <= 0){
            int int1 =  Integer.valueOf(newSDF.format(newDate1));
            if(int1 % 4 ==0 || int1 % 7 ==0)counter+=1;
            calendar.add(Calendar.DATE, 1);
            newDate1 = calendar.getTime();
        }
        return counter;
    }

//    public static int findPrimeDates(int d1, int m1, int y1, int d2, int m2, int y2){
//        storeMonth();
//        updateLeapYear(y1);
//        int counter = 0;
//
//        if(y1==y2){
//            if(m1==m2){
//                if(d1==d2){
//                    int date = Integer.parseInt(String.valueOf(d1).concat(String.valueOf(m1).concat(String.valueOf(y1))));
//                    if(date%4==0 || date%7==0)counter+=1;
//                }
//                else{
//                    while (d1 <= d2){
//                        int date = Integer.parseInt(String.valueOf(d1).concat(String.valueOf(m1).concat(String.valueOf(y1))));
//                        if(date%4==0 || date%7==0)counter+=1;
//                        d1+=1;
//                    }
//                }
//            }
//        }
//
//
//        return 0;
//    }


}