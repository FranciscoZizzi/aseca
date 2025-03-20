import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
	@Test
	public void TwoProductsAreEqualIfTheirNameIsEqualCaseInsensitive() {
		Product product1 = new Product("UNO");
		Product product2 = new Product("Uno");

		assertEquals(product1, product2);
		assertEquals(product1.hashCode(), product2.hashCode());
	}

	@Test
	public void TwoProductsWithDifferentNameAreNotEqualCaseInsensitive() {
		Product product1 = new Product("Uno");
		Product product2 = new Product("dos");

		assertNotEquals(product1, product2);
		assertNotEquals(product1.hashCode(), product2.hashCode());
	}
}
