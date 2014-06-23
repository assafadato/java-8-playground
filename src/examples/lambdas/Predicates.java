package examples.lambdas;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by adissaf on 6/24/2014.
 */
public class Predicates {

    public static Predicate<Shoe> runningShoesPredicate = shoe -> shoe.getType() == Shoe.Type.RUNNING;
    public static Predicate<Shoe> sturdyShoesPredicate = shoe -> shoe.getWeight() > 350;
    public static Predicate<Shoe> expensiveShoesPredicate = shoe -> shoe.getPrice() > 150;

    public static void filter(List<Shoe> unfiltered, String description, Predicate<Shoe> predicate) {
        System.out.println("\nfiltering by " + description);
        System.out.println("------------------------------------------------------");
        // stream api, introduced in java 8, covered in a different package
        unfiltered.stream().filter(predicate).forEach(System.out::println);
        System.out.println("------------------------------------------------------");
    }
}
