import java.time.Duration;
import java.util.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new ProductBuilder().setType("Book").setPrice(251).build(),
                new ProductBuilder().setType("Book").setPrice(2500).build(),
                new ProductBuilder().setType("Book").setPrice(400).build(),
                new ProductBuilder().setType("Book").setPrice(250).build(),
                new ProductBuilder().setType("Shelf").setPrice(500).setSaleFactor(0.1).build(),
                new ProductBuilder().setType("Book").setPrice(240).setSaleFactor(0.1).build(),
                new ProductBuilder().setType("Book").setPrice(240).setSaleFactor(0.1).setCreationDate(LocalDateTime.MAX).build(),
                new ProductBuilder().setPrice(240).setSaleFactor(0.1).setCreationDate(LocalDateTime.now()).build(),
                new ProductBuilder().setPrice(140).setCreationDate(LocalDateTime.now()).build(),
                new ProductBuilder().setPrice(142).setCreationDate(LocalDateTime.now()).build(),
                new ProductBuilder().setPrice(12).setCreationDate(LocalDateTime.now()).build(),
                new ProductBuilder().setPrice(44).setCreationDate(LocalDateTime.now()).build(),
                new ProductBuilder().setPrice(1132).setCreationDate(LocalDateTime.now()).build(),
                new ProductBuilder().setPrice(140).setCreationDate(LocalDateTime.now()).build(),
                new ProductBuilder().setType("Book").setPrice(250).setSaleFactor(0.15).build()
        );

        List<Product> books250 = products
                .stream()
                .filter(e -> (Objects.equals(e.getType(), "Book") && e.getPrice() > 250))
                .toList();

        List<Product> booksSale = products
                .stream()
                .filter(e -> (Objects.equals(e.getType(), "Book") && e.getSaleFactor() == 0.1))
                .toList();

        Product booksCheapest = products
                .stream()
                .filter(e -> e.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException(String.format("Продукт [категорія: %s] не знайдено", "Book")));

        List<Product> booksLatest = products
                .stream()
                .sorted(Comparator.comparing(product -> Duration.between(product.getCreationDate(), LocalDateTime.MAX).toSeconds()))
                .limit(3)
                .toList();

        double books5 = products
                .stream()
                .filter(e -> e.getCreationDate().getYear() == LocalDateTime.now().getYear())
                .filter(e -> e.getType().equals("Book"))
                .filter(e -> e.getPrice() <= 75)
                .mapToDouble(e -> e.getPrice())
                .sum();

        books250.forEach(System.out::println);
        System.out.println();
        booksSale.forEach(System.out::println);
        System.out.println();
        System.out.println(booksCheapest);
        System.out.println();
        booksLatest.forEach(System.out::println);
        System.out.println();
        System.out.println(books5);
        System.out.println();
    }
}