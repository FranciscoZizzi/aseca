import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

	@Test
	public void GetProductPriceFromCatalogShouldReturnResultWithCorrectPrice() {
		HashMap<Product, Integer> priceList = new HashMap<>(Map.of(createProductRice(), 10));
		Catalog catalog = new Catalog(new Date(), priceList);
		assertEquals(10, catalog.getPrice(createProductRice()).unwrap());
	}

	@Test
	public void GetProductMissingFromCatalogShouldThrowCatalogExceptionWithMessage() {
		HashMap<Product, Integer> priceList = new HashMap<>(Map.of(createProductRice(), 10));
		Catalog catalog = new Catalog(new Date(), priceList);

		Product someProduct = new Product("not_rice");
		assertThrows(CatalogException.class , () ->
				catalog.getPrice(someProduct).unwrap());
	}

	@Test
	public void RemoveProductFromCatalogShouldReturnNewCatalogWithoutProduct() {
		HashMap<Product, Integer> priceList = new HashMap<>(Map.of(createProductRice(), 10));
		Catalog catalog = new Catalog(new Date(), priceList);

		Catalog newCatalog = catalog.removeProduct(createProductRice());
		assertThrows(CatalogException.class , () ->
				newCatalog.getPrice(createProductRice()).unwrap());
	}

	@Test
	public void RemoveProductNotInCatalogShouldReturnCatalogOfSameSize() {
		HashMap<Product, Integer> priceList = new HashMap<>(Map.of(createProductRice(), 10));
		Catalog catalog = new Catalog(new Date(), priceList);

		Catalog newCatalog = catalog.removeProduct(new Product("not_rice"));
		assertEquals(catalog.size(), newCatalog.size());
	}

	@Test
	public void AddedProductToCatalogShouldBeSearchable() {
		HashMap<Product, Integer> priceList = new HashMap<>(Map.of(createProductRice(), 10));
		Catalog catalog = new Catalog(new Date(), priceList).addProduct(createProductMilk(), 7);

		assertEquals(7, catalog.getPrice(createProductMilk()).unwrap());
	}

	public static Product createProductRice() {
		return new Product("rice");
	}

	public static Product createProductMilk() {
		return new Product("milk");
	}
}