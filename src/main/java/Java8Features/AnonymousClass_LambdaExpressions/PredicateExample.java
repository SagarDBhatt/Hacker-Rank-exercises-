package Java8Features.AnonymousClass_LambdaExpressions;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<Integer> age = List.of(20,29,40,20,49,19,10,8,6);

        Predicate<Integer> predicate = (Integer ageNumber) -> ageNumber > 18;

//        Predicate<Integer> predicate = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer age) {
//                if(age > 18)
//                    return true;
//                else
//                    return false;
//            }
//        };

        System.out.println("18 years or older == ");
        for(Integer ageNumber : age){
            if(predicate.test(ageNumber))
                System.out.println("Age passed == " + ageNumber);
        }
    }
}
