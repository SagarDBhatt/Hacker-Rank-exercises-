package Exercises.SingletonClass;

public class Singleton {

    private static Singleton singletonObject = null;

    private Singleton(){
    }

    public static Singleton getSingletonObject(){
        if(singletonObject==null)
            singletonObject = new Singleton();

        return singletonObject;
    }

    public void printMessage(){
        System.out.println("This is PrintMessage() in singleton class");
    }

}
