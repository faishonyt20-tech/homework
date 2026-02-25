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

        if (!Objects.equals(customer, order.customer)) {
            return false;
        }

        return compareBaskets(order.basket);
    }

    private boolean compareBaskets(Product[] otherBasket) {
        if (basket == null && otherBasket == null) return true;
        if (basket == null || otherBasket == null) return false;
        if (basket.length != otherBasket.length) return false;

        for (int i = 0; i < basket.length; i++) {
            Product p1 = basket[i];
            Product p2 = otherBasket[i];

            if (p1 == null && p2 == null) continue;
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
}