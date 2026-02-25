import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;
    private String category;

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
        // Проверка на равенство ссылок
        if (this == obj) return true;

        // Проверка на null и совпадение классов
        if (obj == null || getClass() != obj.getClass()) return false;

        // Приведение типа
        Product product = (Product) obj;

        // Сравнение примитивного поля id
        if (id != product.id) return false;

        // Сравнение строки category с обработкой null через Objects.equals
        return Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }

    // Метод main для тестирования класса Product
    public static void main(String[] args) {
        System.out.println("=== Тестирование класса Product ===");

        // Создаем тестовые объекты
        Product product1 = new Product(1, "Ноутбук", 50000, "Электроника");
        Product product2 = new Product(1, "Ноутбук Pro", 55000, "Электроника"); // тот же id и category
        Product product3 = new Product(2, "Смартфон", 30000, "Электроника"); // другой id
        Product product4 = new Product(1, "Планшет", 25000, "Гаджеты"); // другая категория
        Product product5 = new Product(3, "Книга", 500, null); // тест с null категорией
        Product product6 = new Product(3, "Журнал", 300, null); // тот же id и null категория

        // Выводим объекты
        System.out.println("product1: " + product1);
        System.out.println("product2: " + product2);
        System.out.println("product3: " + product3);
        System.out.println("product4: " + product4);
        System.out.println("product5: " + product5);
        System.out.println("product6: " + product6);

        System.out.println("\n=== Результаты сравнения ===");

        // Тест 1: одинаковые id и category
        System.out.println("product1.equals(product2): " + product1.equals(product2) +
                " (должно быть true - одинаковые id и category)");

        // Тест 2: разные id
        System.out.println("product1.equals(product3): " + product1.equals(product3) +
                " (должно быть false - разные id)");

        // Тест 3: разные category
        System.out.println("product1.equals(product4): " + product1.equals(product4) +
                " (должно быть false - разные category)");

        // Тест 4: сравнение с null
        System.out.println("product1.equals(null): " + product1.equals(null) +
                " (должно быть false)");

        // Тест 5: сравнение с самим собой
        System.out.println("product1.equals(product1): " + product1.equals(product1) +
                " (должно быть true)");

        // Тест 6: оба с null категорией и одинаковым id
        System.out.println("product5.equals(product6): " + product5.equals(product6) +
                " (должно быть true - одинаковые id и оба null в category)");

        // Тест 7: сравнение объектов разных классов
        System.out.println("product1.equals(\"строка\"): " + product1.equals("строка") +
                " (должно быть false)");
    }
}