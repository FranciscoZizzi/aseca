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

	@Test
	public void GetCartPricesWithNonRegisteredProductShouldReturnError() {
		Catalog catalog = createCatalog();
		PaymentProcessor paymentProcessor = createMockPaymentProcessor();
		Cashier cashier = new Cashier(catalog, paymentProcessor);

		Cart cart = new Cart(List.of(new Product("uno"), new Product("milk"), new Product("cheese")));

		assertThrows(CashierException.class, () -> cashier.getPrice(cart).unwrap());
	}

	@Test
	public void PayValidCartInCashShouldReturnPaymentResult() {
		Catalog catalog = createCatalog();
		PaymentProcessor paymentProcessor = createMockPaymentProcessor();
		Cashier cashier = new Cashier(catalog, paymentProcessor);

		Cart cart = new Cart(List.of(new Product("rice"), new Product("milk"), new Product("cheese")));

		PaymentDto paymentDetails = new CashPaymentDto(30);

		PaymentResult paymentResult = cashier.pay(cart, paymentDetails);
		assertTrue(paymentResult.isSuccessful());
		assertEquals(30, paymentResult.amount());
		assertEquals(2, paymentResult.change());
	}

	@Test
	public void PayWithInsufficientCashShouldReturnUnsuccessfulPaymentResult() {
		Catalog catalog = createCatalog();
		PaymentProcessor paymentProcessor = createMockPaymentProcessor();
		Cashier cashier = new Cashier(catalog, paymentProcessor);

		Cart cart = new Cart(List.of(new Product("rice"), new Product("milk"), new Product("cheese")));

		PaymentDto paymentDetails = new CashPaymentDto(23);

		PaymentResult paymentResult = cashier.pay(cart, paymentDetails);
		assertFalse(paymentResult.isSuccessful());
		assertEquals("Insufficient cash", paymentResult.message());
	}

	@Test
	public void PayValidCartWithCardShouldReturnPaymentResult() {
		Catalog catalog = createCatalog();
		PaymentProcessor paymentProcessor = createMockPaymentProcessor();
		Cashier cashier = new Cashier(catalog, paymentProcessor);

		Cart cart = new Cart(List.of(new Product("rice"), new Product("milk"), new Product("cheese")));

		PaymentDto paymentDetails = new CardPaymentDto("1234 5678 9123 4567", "12", "2028", "123");

		PaymentResult paymentResult = cashier.pay(cart, paymentDetails);
		assertTrue(paymentResult.isSuccessful());
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