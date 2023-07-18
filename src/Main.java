import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    private String type;
    private double price;
    private boolean discount;

    public Product(String type, double price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public void applyDiscount() {
        if (discount) {
            price = price * 0.9;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Book", 200, false),
                new Product("Book", 300, true),
                new Product("Book", 400, true),
                new Product("Toy", 100, false)
        );

        List<Product> discountedProducts = products.stream()
                .filter(p -> p.getType().equals("Book") && p.hasDiscount())
                .peek(Product::applyDiscount)
                .collect(Collectors.toList());

        discountedProducts.forEach(p -> System.out.println("Type: " + p.getType() + ", Price: " + p.getPrice()));
    }
}
