public class TDD{
	public static void main(String[] args){
		testMultiplication();
		testEquality();
		testFrancMultiplication();
		testCurrency();
		testDifferentClassEquality();
	}
		
	class Money  {
		protected int amount;

		public boolean equals(Object object)  {
			Money money = (Money) object;
			return amount == money.amount;
		}  
		
		public boolean equals(Object object) {
			Money money = (Money) object;
			return amount == money.amount && getClass().equals(money.getClass());
		}	
		static Dollar dollar(int amount)  {
			return new Dollar(amount);
		}

		abstract Money times(int multiplier);  	
		
		static Money dollar(int amount)  {
			return new Dollar(amount);
		}

		static Money franc(int amount) {
			return new Franc(amount);
		}		
		
		protected String currency();
		
		String currency() {
			return currency;
		}
		static Money dollar(int amount)  {
			return new Dollar(amount, "USD");
		}

		static Money franc(int amount) {
			return new Franc(amount, "CHF");
		}
				
		Money(int amount, String currency) {
			this.amount = amount;
			this.currency = currency;
		}
		
		Money times(int multiplier) {
			return new Money(amount * multiplier, currency);
		}
	}

	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}


    public void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
    }

	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5))); 
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}
	
	public void testFrancMultiplication() {
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	}
	
	public void testDifferentClassEquality() {
		assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
	}
}