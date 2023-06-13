import com.sun.security.jgss.GSSUtil;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPositive(20));
        System.out.println(isPositiveLambda(-100));
        greetings("Ivan");
        greetingsLambda("Petr");
        System.out.println(task3(0.75));
        System.out.println(task3Lambda(4.28475));
        System.out.println(getRandom());
        System.out.println(getRandomLambda());

        //опциональное задание
        Predicate<Integer> condition = x -> x > 5;
        Function<Integer, String> ifTrue = x -> "Number is greater than 5";
        Function<Integer, String> ifFalse = x -> "Number is less than or equal to 5";

        Function<Integer, String> resultFunction = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(resultFunction.apply(10)); // будет Number is greater than 5
        System.out.println(resultFunction.apply(3));  // будет Number is less than or equal to 5

    }

    public static boolean isPositive(int i){
        //Задание 1 - предикат на положительное число
        //через анонимный класс
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        return predicate.test(i);
    }

    public static boolean isPositiveLambda(int i){
        //через лямбду
        Predicate<Integer> predicate = integer -> integer < 0;
        return predicate.test(i);
    }

    public static void greetings(String name) {
        //Задание 2 - консамер принимает имя человека и выводит приветствие
        //через анонимный класс
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hi, " + s + "!!!");
            }
        };
        consumer.accept(name);
    }
    public static void greetingsLambda(String name) {
        //Задание 2 - консамер принимает имя человека и выводит приветствие
        //через лямбду
        Consumer<String> consumer = s -> System.out.println("Привет тебе, " + s + "!!!");
        consumer.accept(name);
    }

    public static long task3(double d) {
        //Задание 3 - фанкшен принимает double, возвращает long
        //через анонимный класс

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        return function.apply(d);
    }
    public static long task3Lambda(double d) {
        //через лямбду
        Function<Double, Long> function = aDouble -> Math.round(aDouble);
        return function.apply(d);
    }

    public static short getRandom() {
        //Сапплиер возвращает случайное число 0 <= x <= 100
        //через анонимный
        Supplier<Short> shortSupplier = new Supplier<Short>() {
            @Override
            public Short get() {
                return (short)(Math.random() * 100 + 1);
            }
        };
        return shortSupplier.get();
    }
    public static short getRandomLambda() {
        //через лямбду

        Supplier<Short> shortSupplier = () -> (short)(Math.random() * 100 + 1);
        return shortSupplier.get();
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

}