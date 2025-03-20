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
		Product product = createProductRice();
		cart.add(product);

		assertFalse(cart.isEmpty());
	}

	@Test
	public void AddProductShouldMakeCartContainProduct_003() {
		Cart cart = new Cart();
		Product product = createProductRice();
		cart.add(product);

		assertTrue(cart.contains(product));
	}

	@Test
	public void RemoveAnAddedProductShouldMakeCartEmpty_004() {
		Cart cart = new Cart();
		Product product = createProductRice();
		cart.add(product);
		assertTrue(cart.contains(product));

		cart.remove(product);

		assertTrue(cart.isEmpty());
	}

	@Test
	public void RemoveANonExistentProductShouldDoNothing_005() {
		Cart cart = new Cart();
		Product product = createProductRice();

		cart.remove(product);

		assertTrue(cart.isEmpty());
	}

	@Test
	public void RemoveAnAddedProductShouldMakeCartNotContainIt_006() {
		Cart cart = new Cart();
		Product product = createProductRice();
		cart.add(product);
		assertTrue(cart.contains(product));

		cart.remove(product);

		assertFalse(cart.contains(product));
	}

	@Test
	public void GetProductsShouldReturnListOfProducts_007() {
		Cart cart = new Cart();
		Product product1 = createProductRice();
		Product product2 = createProductRice();
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

	public static Product createProductRice() {
		return new Product("rice");
	}
}
