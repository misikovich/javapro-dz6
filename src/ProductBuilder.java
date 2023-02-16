import java.time.LocalDateTime;
import java.util.Objects;

public class ProductBuilder {
    private String id;
    private String type;
    private int price;
    private double saleFactor;
    private LocalDateTime creationDate;

    public ProductBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ProductBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ProductBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setSaleFactor(double saleFactor) {
        this.saleFactor = saleFactor;
        return this;
    }

    public ProductBuilder setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Product build() {
        Product product = new Product();
        if (Objects.isNull(id)) id = "0";
        product.setId(id);
        if (Objects.isNull(type)) type = "Basic";
        product.setType(type);
        if (Objects.isNull(price)) price = 0;
        product.setPrice(price);
        if (Objects.isNull(saleFactor)) saleFactor = 0;
        product.setSaleFactor(saleFactor);
        if (Objects.isNull(creationDate)) creationDate = LocalDateTime.MIN;
        product.setCreationDate(creationDate);
        return product;
    }
}
