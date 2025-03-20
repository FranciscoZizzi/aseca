import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> products = new ArrayList<>();

	public Cart() {
		this.products = new ArrayList<>();
	}

	public Cart(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return List.copyOf(this.products);
	}

	public void add(Product product) {
		this.products.add(product);
	}

	public void remove(Product product) {
		this.products.remove(product);
	}

	public boolean contains(Product product) {
		return this.products.contains(product);
	}

	public boolean isEmpty() {
		return this.products.isEmpty();
	}
}
