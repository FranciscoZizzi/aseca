public class MockPaymentProcessor implements PaymentProcessor {

	@Override
	public PaymentResult pay(int price, PaymentDto paymentDto) {
		switch (paymentDto) {
			case CashPaymentDto cashPayment -> {
				return processCashPayment(price, cashPayment);
			}
			case CardPaymentDto cardPayment -> {
				return processCardPayment(price, cardPayment);
			}
		}
	}

	private PaymentResult processCashPayment(Integer price, CashPaymentDto paymentDetails) {
		int amount = paymentDetails.amount();

		if (amount < price) return new PaymentResult(false, 0, 0, "Insufficient cash");

		return new PaymentResult(true, amount, amount - price, "");
	}

	private PaymentResult processCardPayment(Integer price, CardPaymentDto paymentDetails) {
		return new PaymentResult(true, price, 0, "");
	}
}
