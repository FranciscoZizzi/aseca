import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {

	@Test
	public void CreateCartShouldBeEmpty_001() {
		Cart cart = new Cart();

		assertTrue(cart.isEmpty());
	}

	@Test
	public void AddProductShouldMakeCartNotEmpty_002() {
		Cart cart = new Cart();
		Product product = new Product();
		cart.add(product);

		assertFalse(cart.isEmpty());
	}

	@Test
	public void AddProductShouldMakeCartContainProduct_003() {
		Cart cart = new Cart();
		Product product = new Product();
		cart.add(product);

		assertTrue(cart.contains(product));
	}

	@Test
	public void RemoveAnAddedProductShouldMakeCartEmpty_004() {
		Cart cart = new Cart();
		Product product = new Product();
		cart.add(product);
		assertTrue(cart.contains(product));

		cart.remove(product);

		assertTrue(cart.isEmpty());
	}

	@Test
	public void RemoveANonExistentProductShouldDoNothing_005() {
		Cart cart = new Cart();
		Product product = new Product();

		cart.remove(product);

		assertTrue(cart.isEmpty());
	}
}