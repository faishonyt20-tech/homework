import java.util.Arrays;
import java.util.Objects;

public class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }

    // Геттеры (для удобства)
    public String getCustomer() { return customer; }
    public Product[] getBasket() { return basket; }

    @Override
    public String toString() {
        return String.format("Заказ[клиент=%s, корзина=%s]",
                customer, Arrays.toString(basket));
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на равенство ссылок
        if (this == obj) return true;

        // 2. Проверка на null и совпадение классов
        if (obj == null || getClass() != obj.getClass()) return false;

        // 3. Приведение типа
        Order order = (Order) obj;

        // 4. Сравнение customer с обработкой null
        if (!Objects.equals(customer, order.customer)) {
            return false;
        }

        // 5. Сравнение массивов товаров
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

            // Если оба null - пропускаем (считаем равными на этой позиции)
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

    // Тестирование в отдельном main (как требуется в задании)
    public static void main(String[] args) {
        System.out.println("\n=== Тестирование класса Order (метод equals) ===");
        System.out.println();

        // Создаем товары для тестирования
        Product laptop = new Product(1, "Ноутбук", 50000, "Электроника");
        Product phone = new Product(2, "Смартфон", 30000, "Электроника");
        Product tablet = new Product(1, "Планшет", 25000, "Гаджеты"); // тот же id, но другая категория

        // Создаем различные корзины
        Product[] basket1 = {laptop, phone};
        Product[] basket2 = {laptop, phone}; // та же корзина
        Product[] basket3 = {phone, laptop}; // другой порядок
        Product[] basket4 = {laptop, tablet}; // другие товары
        Product[] basket5 = {laptop, null}; // с null элементом
        Product[] basket6 = {laptop, null}; // такая же корзина с null
        Product[] basket7 = null; // null корзина

        // Создаем заказы
        Order order1 = new Order("Иванов И.И.", basket1);
        Order order2 = new Order("Иванов И.И.", basket2);
        Order order3 = new Order("Иванов И.И.", basket3);
        Order order4 = new Order("Петров П.П.", basket1); // другой клиент
        Order order5 = new Order("Иванов И.И.", basket4);
        Order order6 = new Order("Иванов И.И.", basket5);
        Order order7 = new Order("Иванов И.И.", basket6);
        Order order8 = new Order("Сидоров С.С.", basket7); // null корзина
        Order order9 = null; // null заказ

        // Выводим все заказы
        System.out.println("Созданные заказы:");
        System.out.println("order1: " + order1);
        System.out.println("order2: " + order2);
        System.out.println("order3: " + order3);
        System.out.println("order4: " + order4);
        System.out.println("order5: " + order5);
        System.out.println("order6: " + order6);
        System.out.println("order7: " + order7);
        System.out.println("order8: " + order8);
        System.out.println("order9: null");
        System.out.println();

        // Тестируем сравнение заказов
        System.out.println("Результаты сравнения заказов:");
        System.out.println("1. order1.equals(order1): " + order1.equals(order1) +
                " (ссылается на себя - должно быть true)");

        System.out.println("2. order1.equals(order2): " + order1.equals(order2) +
                " (одинаковые корзины и клиент - должно быть true)");

        System.out.println("3. order1.equals(order3): " + order1.equals(order3) +
                " (разный порядок товаров - должно быть false)");

        System.out.println("4. order1.equals(order4): " + order1.equals(order4) +
                " (разные клиенты - должно быть false)");

        System.out.println("5. order1.equals(order5): " + order1.equals(order5) +
                " (разные товары - должно быть false)");

        System.out.println("6. order6.equals(order7): " + order6.equals(order7) +
                " (оба с null в корзине - должно быть true)");

        System.out.println("7. order1.equals(order9): " + order1.equals(order9) +
                " (сравнение с null - должно быть false)");

        System.out.println("8. order8.equals(new Order(\"Сидоров С.С.\", null)): " +
                order8.equals(new Order("Сидоров С.С.", null)) +
                " (обе null корзины - должно быть true)");

        System.out.println("9. order1.equals(\"строка\"): " + order1.equals("строка") +
                " (разные классы - должно быть false)");
    }
}
