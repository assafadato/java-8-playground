package examples.lambdas;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static examples.lambdas.Predicates.*;

/**
 * Created by adissaf on 6/23/2014.
 */
public class Tester {

    public static void main(String[] args) {
        Shoe shoe1 = new Shoe(Shoe.Brand.ASICS, Shoe.Type.RUNNING, 320F, "GEL-KAYANO® 20", 9, 160F);
        Shoe shoe2 = new Shoe(Shoe.Brand.ADIDAS, Shoe.Type.SOCCER, 388F, "PREDATOR LZ TRX FG", 8, 220F);
        Shoe shoe3 = new Shoe(Shoe.Brand.SALOMON, Shoe.Type.HIKING, 450F, "X ULTRA", 10.5F, 120F);
        Shoe shoe4 = new Shoe(Shoe.Brand.MIZUNO, Shoe.Type.RUNNING, 300F, "WAVE PARADOX", 9F, 180F);
        List<Shoe> shoes = Lists.newArrayList(shoe1, shoe2, shoe3, shoe4);

        // passing comparator as lambda expression
        Comparator<Shoe> weightDesc = (s1, s2) -> Float.compare(s2.getWeight(), s1.getWeight());
        Collections.sort(shoes, weightDesc);
        System.out.println("shoes by descending weight: " + shoes);

        // passing Predicate as lambda expression
        filter(shoes, "running shoes (Type == RUNNING)", runningShoesPredicate);
        filter(shoes, "sturdy shoes (weight > 350 gr)", sturdyShoesPredicate);
        filter(shoes, "expensive shoes (price > 150$)", expensiveShoesPredicate);

        // passing old school Predicate with anonymous class
        filter(shoes, "brand starting with 'A'", new Predicate<Shoe>() {
            @Override
            public boolean test(Shoe shoe) {
                return shoe.getBrand().name().startsWith("A");
            }
        });
    }

}
