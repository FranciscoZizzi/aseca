import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

	@Test
	public void CreateCartShouldBeEmpty_001() {
		Cart cart = new Cart();

		assertTrue(cart.isEmpty());
	}

	@Test
	public void AddProductShouldMakeCartNotEmpty_002() {
		Cart cart = new Cart();
		Product product = new Product(10);
		cart.add(product);

		assertFalse(cart.isEmpty());
	}

	@Test
	public void AddProductShouldMakeCartContainProduct_003() {
		Cart cart = new Cart();
		Product product = new Product(10);
		cart.add(product);

		assertTrue(cart.contains(product));
	}

	@Test
	public void RemoveAnAddedProductShouldMakeCartEmpty_004() {
		Cart cart = new Cart();
		Product product = new Product(10);
		cart.add(product);
		assertTrue(cart.contains(product));

		cart.remove(product);

		assertTrue(cart.isEmpty());
	}

	@Test
	public void RemoveANonExistentProductShouldDoNothing_005() {
		Cart cart = new Cart();
		Product product = new Product(10);

		cart.remove(product);

		assertTrue(cart.isEmpty());
	}

	@Test
	public void RemoveAnAddedProductShouldMakeCartNotContainIt_006() {
		Cart cart = new Cart();
		Product product = new Product(10);
		cart.add(product);
		assertTrue(cart.contains(product));

		cart.remove(product);

		assertFalse(cart.contains(product));
	}

	@Test
	public void GetProductsShouldReturnListOfProducts_007() {
		Cart cart = new Cart();
		Product product1 = new Product(10);
		Product product2 = new Product(10);
		cart.add(product1);
		cart.add(product2);

		List<Product> products = cart.getProducts();
		assertTrue(products.contains(product1));
		assertTrue(products.contains(product2));
	}

	@Test
	public void GetProductsOnEmptyCartShouldReturnEmptyList_008() {
		Cart cart = new Cart();
		List<Product> products = cart.getProducts();

		assertTrue(products.isEmpty());
	}

	@Test
	public void CalculatePriceOfEmptyCartShouldBeZero_009() {
		Cart cart = new Cart();

		assertEquals(0, cart.calculatePrice());
	}

	@Test
	public void CalculatePriceShouldReturnSumOfProductPrices_010() {
		Cart cart = new Cart();
		Product product1 = new Product(98);
		Product product2 = new Product(5);

		cart.add(product1);
		cart.add(product2);

		assertEquals(product1.getPrice() + product2.getPrice(), cart.calculatePrice());
	}
}
