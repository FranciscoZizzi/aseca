import java.util.List;

public class Cashier {
	private final Catalog catalog;
	private final PaymentProcessor paymentProcessor;

	public Cashier(Catalog catalog, PaymentProcessor paymentProcessor) {
		this.catalog = catalog;
		this.paymentProcessor = paymentProcessor;
	}

	public Result<Integer, CashierException> getPrice(Cart cart) {
		List<Product> products = cart.getProducts();
		int subtotal = 0;
		for (Product product : products) {
			try {
				subtotal += catalog.getPrice(product).unwrap();
			} catch (CatalogException exception) {
				return new Result<>(null, new CashierException(exception.getMessage()));
			}
		}
		return new Result<>(subtotal, null);
	}

	public PaymentResult pay(Cart cart, PaymentDto paymentDetails) {
		Result<Integer, CashierException> cartPrice = getPrice(cart);

		if (cartPrice.isError()) return new PaymentResult(false, 0, 0, "");

		return paymentProcessor.pay(cartPrice.getValue(), paymentDetails);
	}
}