import java.util.ArrayList;
import java.util.List;

public class Cart {
	private final List<Product> products;

	public Cart() {
		this.products = new ArrayList<>();
	}

	public Cart(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return List.copyOf(this.products);
	}

	public Cart add(Product product) {
		List<Product> newProducts = new ArrayList<>(List.copyOf(this.products));
		newProducts.add(product);
		return new Cart(newProducts);
	}

	public Cart remove(Product product) {
		List<Product> newProducts = new ArrayList<>(List.copyOf(this.products));
		newProducts.remove(product);
		return new Cart(newProducts);
	}

	public boolean contains(Product product) {
		return this.products.contains(product);
	}

	public boolean isEmpty() {
		return this.products.isEmpty();
	}
}
