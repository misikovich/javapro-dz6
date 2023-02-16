import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Product {
    private String id;
    private String type;
    private double price;
    private double saleFactor;
    private LocalDateTime creationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public long getCreationDateAsSeconds(){
        return creationDate.toEpochSecond(ZoneOffset.UTC);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaleFactor() {
        return saleFactor;
    }

    public void setSaleFactor(double saleFactor) {
        this.saleFactor = saleFactor;
    }

    public void applySale() {
        setPrice(getPrice() / saleFactor);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", saleFactor=" + saleFactor +
                ", creationDate=" + getCreationDateAsSeconds() +
                '}';
    }
}
