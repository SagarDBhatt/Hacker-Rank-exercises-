package Exercises.SingletonClass;

public class RunnerClass {

    public static void main(String[] args) {
        Singleton obj = Singleton.getSingletonObject();
        obj.printMessage();
    }
}
