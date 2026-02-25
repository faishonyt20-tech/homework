import java.util.Arrays;
import java.util.Objects;

public class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }

    @Override
    public String toString() {
        return String.format("Заказ[клиент=%s, корзина=%s]",
                customer, Arrays.toString(basket));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Order order = (Order) obj;

        // Сравниваем customer с обработкой null
        if (!Objects.equals(customer, order.customer)) {
            return false;
        }

        // Сравниваем массивы товаров
        return compareBaskets(order.basket);
    }

    private boolean compareBaskets(Product[] otherBasket) {
        // Проверка на null для обоих массивов
        if (basket == null && otherBasket == null) return true;
        if (basket == null || otherBasket == null) return false;

        // Проверка длины массивов
        if (basket.length != otherBasket.length) return false;

        // Поэлементное сравнение с учетом порядка
        for (int i = 0; i < basket.length; i++) {
            Product p1 = basket[i];
            Product p2 = otherBasket[i];

            // Если оба null - пропускаем
            if (p1 == null && p2 == null) continue;

            // Если один null или товары не равны через equals()
            if (p1 == null || p2 == null || !p1.equals(p2)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(customer);
        result = 31 * result + Arrays.hashCode(basket);
        return result;
    }

    // Метод main для тестирования класса Order
    public static void main(String[] args) {
        System.out.println("\n=== Тестирование класса Order ===");

        // Создаем товары для тестирования
        Product laptop = new Product(1, "Ноутбук", 50000, "Электроника");
        Product phone = new Product(2, "Смартфон", 30000, "Электроника");
        Product tablet = new Product(1, "Планшет", 25000, "Гаджеты");

        // Создаем заказы
        Product[] basket1 = {laptop, phone};
        Product[] basket2 = {laptop, phone};
        Product[] basket3 = {phone, laptop};
        Product[] basket4 = {laptop, tablet};

        Order order1 = new Order("Иванов И.И.", basket1);
        Order order2 = new Order("Иванов И.И.", basket2);
        Order order3 = new Order("Иванов И.И.", basket3);
        Order order4 = new Order("Петров П.П.", basket1);
        Order order5 = new Order("Иванов И.И.", basket4);

        // Выводим заказы
        System.out.println("order1: " + order1);
        System.out.println("order2: " + order2);
        System.out.println("order3: " + order3);
        System.out.println("order4: " + order4);
        System.out.println("order5: " + order5);

        System.out.println("\n=== Результаты сравнения заказов ===");
        System.out.println("order1.equals(order2): " + order1.equals(order2) + " (одинаковые корзины)");
        System.out.println("order1.equals(order3): " + order1.equals(order3) + " (разный порядок товаров)");
        System.out.println("order1.equals(order4): " + order1.equals(order4) + " (разные клиенты)");
        System.out.println("order1.equals(order5): " + order1.equals(order5) + " (разные товары)");
    }
}