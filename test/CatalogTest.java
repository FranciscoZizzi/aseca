import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/*
	maneja precios de productos
		crear, modificar, eliminar
 */
class CatalogTest {
	@Test
	public void Test() throws IllegalArgumentException {
		HashMap<Product, Integer> priceList = new HashMap<>();
		assertThrows(IllegalArgumentException.class, () -> new Catalog(new Date(), priceList));
	}
}