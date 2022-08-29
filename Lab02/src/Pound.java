
public class Pound extends Currency{
	
	private final String name = "Pound";
	
	/**
	 * Create a new Pound currency object with the value 0
	 */
	public Pound() {
		super();
	}
	
	/**
	 * Create a new Pound currency object with the value param
	 * @param value
	 */
	public Pound(double value) {
		super(value);
	}

	@Override
	public String getCurrencyName() {
		return name;
	}

	@Override
	public boolean isSameCurrency(Currency currency) {
		return currency instanceof Pound;
	}

}
