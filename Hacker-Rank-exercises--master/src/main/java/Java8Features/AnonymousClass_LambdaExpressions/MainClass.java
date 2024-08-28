package Java8Features.AnonymousClass_LambdaExpressions;

public class MainClass{

    public static void main(String[] args) {

        //APPROACH 2:
        functionalInterfaceCalc obj1 = (a,b) -> (a+b);
        System.out.println("No need to metion the datatype and return value as well!!!" + obj1.sum(5,8));

        functionalInterfaceCalc f = (int a, int b) -> {
                return a*2 + b*2;
        };
        System.out.println(f.sum(5,10) );

        //APPROACH 1:
        functionalInterfaceCalc obj = (int a, int b) -> { return (a + b); };
        System.out.println("Sum of two numbers = " + obj.sum(4,5));


        //SOL 2: USING LAMBDA EXPRESSION:
        AnonymousInterface anonymousLambda = (String str) -> { System.out.println("This is lambda expression == " + str); };
        anonymousLambda.showMessage("Lambda message");

        //SOL 1: USING INNER ANONYMOUS CLASS
        AnonymousInterface interfaceObject = new AnonymousInterface() {
            @Override
            public void showMessage(String message) {
                System.out.println("Anonymous interface creation == " + message);
            }
        };
        interfaceObject.showMessage("Interface message");
    }

//    @Override
//    public void showMessage(String message) {
//        System.out.println("The provided message == " + message);
//    }

}//END OF CLASS.
