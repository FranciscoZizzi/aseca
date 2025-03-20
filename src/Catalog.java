import java.util.Date;
import java.util.HashMap;

public class Catalog {
	private final Date catalogDate;
	private final HashMap<Product, Integer> priceList;

	public Catalog(Date catalogDate, HashMap<Product, Integer> priceList) {
		if (priceList.isEmpty()) throw new IllegalArgumentException();
		this.catalogDate = catalogDate;
		this.priceList = priceList;
	}
}
