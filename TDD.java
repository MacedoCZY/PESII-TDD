public class TDD{
	public static void main(String[] args){
		testMultiplication();
	}
	
	class Dollar {
		int amount;
		Dollar(int amount) {
		  this.amount= amount;
		}
		void times(int multiplier) {
			return new Dollar(amount * multiplier);
		}
    }	

    public void testMultiplication() {
		Dollar five = new Dollar(5);
		Dollar product = five.times(2);
		assertEquals(10, product.amount);
		product = five.times(3);
		assertEquals(new Dollar(15), product);
    }
	
}