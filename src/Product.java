import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;
    private String category;

    // Конструктор с параметрами
    public Product(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("Товар[артикул=%d, название=%s, цена=%d, категория=%s]",
                id, name, price, category);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;
        return id == product.id &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }
}