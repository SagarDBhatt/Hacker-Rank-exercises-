/**
 * HackerLand University has the following grading policy:
 *
 * Every student receives a  in the inclusive range from  to .
 * Any  less than  is a failing grade.
 * Sam is a professor at the university and likes to round each student's  according to these rules:
 *
 * If the difference between the  and the next multiple of  is less than , round  up to the next multiple of .
 * If the value of  is less than , no rounding occurs as the result will still be a failing grade.
 * Examples
 *
 *  round to  (85 - 84 is less than 3)
 *  do not round (result is less than 40)
 *  do not round (60 - 57 is 3 or higher)
 * Given the initial value of  for each of Sam's  students, write code to automate the rounding process.
 *
 * Function Description
 *
 * Complete the function gradingStudents in the editor below.
 *
 * gradingStudents has the following parameter(s):
 *
 * int grades[n]: the grades before rounding
 * Returns
 *
 * int[n]: the grades after rounding as appropriate
 * Input Format
 *
 * The first line contains a single integer, , the number of students.
 * Each line  of the  subsequent lines contains a single integer, .
 *
 * Constraints
 *
 * INPUT:
 * 4
 * 73
 * 67
 * 38
 * 33
 *
 * OUTPUT:
 * 73
 * 67
 * 38
 * 33
 *
 */


package ThreeMonthPreparationKit.October_2022.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex02_RoundingGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String val ="";

        List<Integer> gradesList = new ArrayList<Integer>();

        while (!(val = bufferedReader.readLine()).equals("")){
            gradesList.add(Integer.parseInt(val));
        }

        gradesList = Solution.roundGrades(gradesList);

        for(Integer i : gradesList){
            System.out.println(i);
        }

    }//EOF Main
}//EOF Class

class Solution{

    public static List<Integer> roundGrades(List<Integer> grades){

        for(int i =0; i< grades.size(); i++){

            if(grades.get(i) >= 38){
                if(grades.get(i) % 5 != 0){
                    if(grades.get(i) % 5 == 3){
                        grades.set(i, grades.get(i)+2);
                    }
                    if(grades.get(i) % 5 == 4){
                        grades.set(i, grades.get(i)+1);
                    }
                }
            }
        }

        return grades;
    }
}