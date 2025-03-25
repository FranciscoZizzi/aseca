import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Catalog {
	private final Date catalogDate;
	private final HashMap<Product, Integer> priceList;

	public Catalog(Date catalogDate, HashMap<Product, Integer> priceList) {
		this.catalogDate = catalogDate;
		this.priceList = priceList;
	}

	public Result<Integer, CatalogException> getPrice(Product product) {
		return new Result<>(priceList.get(product), new CatalogException("Product not found"));
	}

	public Catalog addProduct(Product product, Integer price) {
		HashMap<Product, Integer> newPriceList = new HashMap<>(priceList);
		newPriceList.put(product, price);
		return new Catalog(catalogDate, newPriceList);
	}

	public Catalog removeProduct(Product product) {
		HashMap<Product, Integer> newPriceList = new HashMap<>(priceList);
		newPriceList.remove(product);
		return new Catalog(catalogDate, newPriceList);
	}

	public int size() {
		return priceList.size();
	}
}
