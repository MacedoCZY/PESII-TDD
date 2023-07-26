public class TDD{
	public static void main(String[] args){
		//testMultiplication();
		testEquality();
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
	}
	
	class Dollar extends Money{
		private int amount;
		Dollar(int amount) {
		  this.amount= amount;
		}
		Money times(int multiplier) {
			return new Dollar(amount * multiplier);
		}
    }	

	class Franc extends Money{   
		private int amount;					
			Franc(int amount) {      
			this.amount= amount;
		}					
			Money times(int multiplier)  {      
			return new Franc(amount * multiplier);					
		}   		
	}

    public void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
    }

	public void testEquality() {
		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertFalse(new Dollar(5).equals(new Dollar(6)));
		assertTrue(new Franc(5).equals(new Franc(5)));
		assertFalse(new Franc(5).equals(new Franc(6)));
		assertFalse(new Franc(5).equals(new Dollar(5)));
	}
	
	public void testFrancMultiplication() {
		Franc five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));
	}
}