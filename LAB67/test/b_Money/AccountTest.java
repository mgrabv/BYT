package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("1A", "Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("1A", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("Payment1", 3, 3, new Money(5000000, SEK), SweBank, "1A");
		assertTrue(testAccount.timedPaymentExists("Payment1"));
		testAccount.removeTimedPayment("Payment1");
		assertFalse(testAccount.timedPaymentExists("Payment1"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(1000000), SweBank.getBalance("1A"));
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		testAccount.addTimedPayment("Payment1", 2, 2, new Money(5000000, SEK), SweBank, "1A");
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		assertEquals(Integer.valueOf(6000000), SweBank.getBalance("1A"));
		assertEquals(Integer.valueOf(5000000), testAccount.getBalance().getAmount());
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		assertEquals(Integer.valueOf(11000000), SweBank.getBalance("1A"));
		assertEquals(Integer.valueOf(0), testAccount.getBalance().getAmount());
	}

	@Test
	public void testAddWithdraw() {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		testAccount.deposit(new Money(5000000, SEK));
		assertEquals(Integer.valueOf(15000000), testAccount.getBalance().getAmount());
		testAccount.withdraw(new Money(10000000, SEK));
		assertEquals(Integer.valueOf(5000000), testAccount.getBalance().getAmount());
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
		assertEquals(SEK, testAccount.getBalance().getCurrency());
	}
}
