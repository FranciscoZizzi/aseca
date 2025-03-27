public interface PaymentProcessor {
	PaymentResult pay(int price, PaymentDto paymentDto);
}
