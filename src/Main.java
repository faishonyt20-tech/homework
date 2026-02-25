public class Main {
    public static void main(String[] args) {
        // Тестирование товаров
        System.out.println("=== Тестирование товаров ===");

        Product product1 = new Product(1, "Ноутбук", 50000, "Электроника");
        Product product2 = new Product(1, "Ноутбук", 50000, "Электроника");
        Product product3 = new Product(2, "Смартфон", 30000, "Электроника");

        System.out.println("Товар 1: " + product1);
        System.out.println("Товар 2: " + product2);
        System.out.println("Товар 3: " + product3);

        System.out.println("product1.equals(product2): " + product1.equals(product2));
        System.out.println("product1.equals(product3): " + product1.equals(product3));

        // Тестирование заказов
        System.out.println("\n=== Тестирование заказов ===");

        Product[] basket1 = {product1, product3};
        Product[] basket2 = {product1, product3};

        Order order1 = new Order("Иванов И.И.", basket1);
        Order order2 = new Order("Иванов И.И.", basket2);

        System.out.println("Заказ 1: " + order1);
        System.out.println("Заказ 2: " + order2);
        System.out.println("order1.equals(order2): " + order1.equals(order2));
    }
}