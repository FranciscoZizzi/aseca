import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
	@Test
	public void GetCartPriceShouldReturnCorrectValue() {
		Catalog catalog = createCatalog();
		PaymentProcessor paymentProcessor = createMockPaymentProcessor();
		Cashier cashier = new Cashier(catalog, paymentProcessor);

		Cart cart = new Cart(List.of(new Product("rice"), new Product("milk"), new Product("cheese")));

		assertEquals(28, cashier.getPrice(cart).unwrap());
	}

	private static Catalog createCatalog() {
		HashMap<Product, Integer> priceMap = new HashMap<>(Map.of(
				new Product("rice"), 10,
				new Product("milk"), 7,
				new Product("eggs"), 6,
				new Product("cheese"), 11,
				new Product("water"), 3
		));

		return new Catalog(new Date(), priceMap);
	}

	private static PaymentProcessor createMockPaymentProcessor() {
		return new MockPaymentProcessor();
	}
}