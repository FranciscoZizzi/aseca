import java.util.Objects;

public class Product {
	private final String name;

	public Product(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(name.toLowerCase(), product.name.toLowerCase());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name.toLowerCase());
	}
}
