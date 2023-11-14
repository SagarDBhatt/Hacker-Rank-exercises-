package CodingInteview;

import lombok.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.temporal.ChronoUnit;

public class WovenCodingInteviewToCalcInvoice {
    public static void main(String[] args) {

        User[] users = {
                new User(1, 1, "a", LocalDate.of(2020, 1, 1), LocalDate.of(2019, 12, 20)),
                new User(1, 1, "a", LocalDate.of(2020, 1, 1), LocalDate.of(2020,1,9))
        };

//        System.out.println(users);
//        List<User> userList = new ArrayList<>();
//        userList.add(new User(1, 1, "a", new Date(2020, 10, 1), new Date(2020, 10, 1)));
//        userList.add(new User(1, 1, "a", new Date(2020, 10, 1), new Date(2020, 10, 1)));
//
//        System.out.println(userList);

        Subscription subscription = new Subscription(1, 1, 4);

        System.out.println(Solution.calcTheInvoiceForTheMonth("2020-01", users, subscription));
    }
}

class Solution{
    public static double calcTheInvoiceForTheMonth(String month, User[] users, Subscription subscription){

        //1. Find the number of active users for the given month.
        long numOfdays = findNumOfDays(month);

        //1.a) Get the first day of the given month
        LocalDate firstDayOfTheMonth = getFirstDayOfTheMonth(month);

        //1.b) Get last day of the given month
        LocalDate lastDayOfTheMonth = getLastDayOfTheMonth(month);

        //1.c) Get the function to increment the day by 1.
        LocalDate increamentedDate = incrementTheDayByOne(firstDayOfTheMonth);

        //2. Find the cost per day.
        double costPerDay = (double) subscription.getMonthly_price_in_dollars() / numOfdays;

        LocalDate currentDate = firstDayOfTheMonth;
        LocalDate nextDayDate;
        double monthlyCost = 0;
        //3.  find the active users per day and multiply with cost per day.

        //3.1) Find the number of users active on the given day
        for(User u : users){
            LocalDate activationDate = u.getActivated_on();
            LocalDate deactivationDate = u.getDeactivated_on();

            //3.1 Scen 1: If the Deactiveation date is not null then check if deactivation date is after the last day of the month.
            if(deactivationDate != null){
                if( (activationDate.isBefore(firstDayOfTheMonth) || activationDate.isEqual(firstDayOfTheMonth))
                        && (deactivationDate.isAfter(lastDayOfTheMonth) || deactivationDate.isEqual(lastDayOfTheMonth))){
                    monthlyCost += costPerDay * numOfdays;
                }
                //3.1.1 Scen 3: If the deactivation date is the middle of the month then increment the date and validate if the incremented date is before deactivated date.
                else{
//                    increamentedDate = incrementTheDayByOne(currentDate);
                    while(deactivationDate.isAfter(currentDate) || deactivationDate.isEqual(currentDate)){
                        monthlyCost += costPerDay;
                        currentDate = incrementTheDayByOne(currentDate);
                    }
                }

            }
            //3.2 Scen 2: If the deactivation date is null then get the whole month charge.
            else{
                if( (activationDate.isBefore(firstDayOfTheMonth) || activationDate.isEqual(firstDayOfTheMonth))){
                    monthlyCost += costPerDay * numOfdays;
                }
            }

//            else if
//
//            nextDayDate = incrementTheDayByOne(currentDate);
//
//            while(deactivationDate.isAfter(nextDayDate)){
//
//            }
//
//            currentDate = incrementTheDayByOne(currentDate);
        }

        //3.2) Get the cost on the given day.


        //4. return the sum of the total cost.
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(monthlyCost));
    }

    public static LocalDate incrementTheDayByOne(LocalDate date){
        return date.plus(1, ChronoUnit.DAYS);
    }

    public static LocalDate getLastDayOfTheMonth(String month){
        DateTimeFormatter dTF_Month = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth ym = YearMonth.parse(month, dTF_Month);
        return ym.atEndOfMonth();
    }

    public static LocalDate getFirstDayOfTheMonth(String month){
        DateTimeFormatter dTF_FOM = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth ym = YearMonth.parse(month, dTF_FOM);
        return ym.atDay(1);
    }

    // Helper Functions:
    public static long findNumOfDays(String month){
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth ym = YearMonth.parse(month, dTF);
        LocalDate firstDate = ym.atDay(1);
        LocalDate lastDate = ym.atEndOfMonth();
        long daysBetween = firstDate.until(lastDate, ChronoUnit.DAYS) + 1;
        return daysBetween;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User{

    @Getter @Setter
    private long id;

    @Getter @Setter
    private long customerId;

    @Getter @Setter
    private String customerName;

    @Getter @Setter
    private LocalDate activated_on;

    @Getter @Setter
    private LocalDate deactivated_on;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Subscription {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private long customer_id;

    @Getter @Setter
    private int monthly_price_in_dollars;
}