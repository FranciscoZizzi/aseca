public record CardPaymentDto(
		String cardNumber,
		String expirationMonth, String expirationYear,
		String securityNumber
) implements PaymentDto {
}
