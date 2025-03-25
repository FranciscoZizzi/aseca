public class Result<V, E extends Throwable> {
	private final V value;
	private final E error;

	public Result(V value, E error) {
		this.value = value;
		this.error = error;
	}

	public V unwrap() throws E {
		if (value == null) throw error;
		return value;
	}

	public V orElse(V otherValue) {
		return value == null ? otherValue : value;
	}

	public V getValue() {
		return value;
	}
}
