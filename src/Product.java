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

    // Геттеры (для удобства)
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Товар[артикул=%d, название=%s, цена=%d, категория=%s]",
                id, name, price, category);
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на равенство ссылок
        if (this == obj) return true;

        // 2. Проверка на null и совпадение классов
        if (obj == null || getClass() != obj.getClass()) return false;

        // 3. Приведение типа
        Product product = (Product) obj;

        // 4. Сравнение полей id и category (с использованием Objects.equals для обработки null)
        return id == product.id &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }

    // Тестирование в отдельном main (как требуется в задании)
    public static void main(String[] args) {
        System.out.println("=== Тестирование класса Product (метод equals) ===");
        System.out.println();

        // Создаем тестовые объекты
        Product product1 = new Product(1, "Ноутбук", 50000, "Электроника");
        Product product2 = new Product(1, "Ноутбук Pro", 55000, "Электроника"); // тот же id и category
        Product product3 = new Product(2, "Смартфон", 30000, "Электроника"); // другой id
        Product product4 = new Product(1, "Планшет", 25000, "Гаджеты"); // другая категория
        Product product5 = new Product(3, "Книга", 500, null); // тест с null категорией
        Product product6 = new Product(3, "Журнал", 300, null); // тот же id и null категория
        Product product7 = null; // null объект

        // Выводим все товары
        System.out.println("Созданные товары:");
        System.out.println("product1: " + product1);
        System.out.println("product2: " + product2);
        System.out.println("product3: " + product3);
        System.out.println("product4: " + product4);
        System.out.println("product5: " + product5);
        System.out.println("product6: " + product6);
        System.out.println("product7: null");
        System.out.println();

        // Тестируем сравнение
        System.out.println("Результаты сравнения:");
        System.out.println("1. product1.equals(product1): " + product1.equals(product1) +
                " (ссылается на себя - должно быть true)");

        System.out.println("2. product1.equals(product2): " + product1.equals(product2) +
                " (одинаковые id и category - должно быть true)");

        System.out.println("3. product1.equals(product3): " + product1.equals(product3) +
                " (разные id - должно быть false)");

        System.out.println("4. product1.equals(product4): " + product1.equals(product4) +
                " (разные category - должно быть false)");

        System.out.println("5. product1.equals(product7): " + product1.equals(product7) +
                " (сравнение с null - должно быть false)");

        System.out.println("6. product5.equals(product6): " + product5.equals(product6) +
                " (оба null в category, одинаковые id - должно быть true)");

        System.out.println("7. product5.equals(product1): " + product5.equals(product1) +
                " (разные id и категории - должно быть false)");

        System.out.println("8. product1.equals(\"строка\"): " + product1.equals("строка") +
                " (разные классы - должно быть false)");

        // Дополнительные тесты для наглядности
        System.out.println("\n=== Дополнительные тесты ===");
        System.out.println("product2 id=" + product2.getId() + ", category=" + product2.getCategory());
        System.out.println("product4 id=" + product4.getId() + ", category=" + product4.getCategory());
        System.out.println("product2.equals(product4): " + product2.equals(product4) +
                " (разные category - должно быть false)");
    }
}