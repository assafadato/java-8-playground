package examples.lambdas;

import com.google.common.base.Objects;

/**
 * Created by adissaf on 6/23/2014.
 */
public class Shoe implements Comparable<Shoe>{

    public enum Brand {
        NIKE, ASICS, ADIDAS, MIZUNO, SALOMON, PUMA, SAUCONY;
    }

    public enum Type {
        RUNNING, SOCCER, HIKING;
    }
    private final Brand brand;
    private final Type type;
    private final float weight;
    private final String model;
    private final float size;
    private final float price;

    public Shoe(Brand brand, Type type, float weight, String model, float size, float price) {
        this.brand = brand;
        this.type = type;
        this.weight = weight;
        this.model = model;
        this.size = size;
        this.price = price;
    }

    @Override
    public int compareTo(Shoe other) {
        return Float.compare(price, other.price);
    }

    public Brand getBrand() {
        return brand;
    }

    public Type getType() {
        return type;
    }

    public float getWeight() {
        return weight;
    }

    public String getModel() {
        return model;
    }

    public float getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("brand", brand)
                .add("type", type)
                .add("weight", weight)
                .add("model", model)
                .add("size", size)
                .add("price", price)
                .toString();
    }
}
