import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class A {
    int x = 1;
    public void method1() {
        System.out.println("A");
    }
}

class B extends A {
    int y = 1;
    public void method2() {
        System.out.println("B");
    }
}



public class Main {
    public static void main(String[] args) {

        A obj1 = new A();

        A obj2 = new B();

        B obj3 = new B();



        obj2 = (B) obj2;

        ((B) obj2).method2();

        List<String> A = new ArrayList<>();







    }
}