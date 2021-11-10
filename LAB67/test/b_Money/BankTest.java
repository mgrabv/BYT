package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("1A", "Ulrika");
		SweBank.openAccount("2A", "Bob");
		Nordea.openAccount("1A", "Bob");
		DanskeBank.openAccount("1A", "Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
		assertEquals("Nordea", Nordea.getName());
		assertEquals("DanskeBank", DanskeBank.getName());
		assertNotEquals("Nordae", Nordea.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SweBank.getCurrency());
		assertEquals(SEK, Nordea.getCurrency());
		assertEquals(DKK, DanskeBank.getCurrency());
		assertNotEquals(SEK, DanskeBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		SweBank.openAccount("5A", "TEST");
		assertTrue(SweBank.getBalance("5A").equals(0));		//Account exists...
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(0), SweBank.getBalance("1A"));

		SweBank.deposit("1A", new Money(100, SEK));
		
		assertEquals(Integer.valueOf(100), SweBank.getBalance("1A"));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(0), SweBank.getBalance("1A"));
		SweBank.deposit("1A", new Money(100, SEK));
		assertEquals(Integer.valueOf(100), SweBank.getBalance("1A"));
		
		SweBank.withdraw("1A", new Money(100, SEK));				// Withdrawal

		assertEquals(Integer.valueOf(0), SweBank.getBalance("1A"));
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(0), SweBank.getBalance("1A"));
		DanskeBank.deposit("1A", new Money(400, DKK));
		assertEquals(Integer.valueOf(400), DanskeBank.getBalance("1A"));
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		DanskeBank.deposit("1A", new Money(400, DKK));				//Transfer between banks.
		SweBank.deposit("1A", new Money(100, SEK));
		assertEquals(Integer.valueOf(400), DanskeBank.getBalance("1A"));
		assertEquals(Integer.valueOf(100), SweBank.getBalance("1A"));

		SweBank.transfer("1A", DanskeBank, "1A", new Money(100, SEK));

		assertEquals(Integer.valueOf(475), DanskeBank.getBalance("1A"));
		assertEquals(Integer.valueOf(0), SweBank.getBalance("1A"));

		DanskeBank.transfer("1A", SweBank, "1A", new Money(75, DKK));

		assertEquals(Integer.valueOf(400), DanskeBank.getBalance("1A"));
		assertEquals(Integer.valueOf(100), SweBank.getBalance("1A"));

		assertEquals(Integer.valueOf(0), SweBank.getBalance("2A"));	//Transfer between accounts.

		SweBank.transfer("1A", "2A", new Money(100, SEK));

		assertEquals(Integer.valueOf(100), SweBank.getBalance("2A"));
		assertEquals(Integer.valueOf(0), SweBank.getBalance("1A"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		DanskeBank.deposit("1A", new Money(400, DKK));
		SweBank.deposit("1A", new Money(200, SEK));
		assertEquals(Integer.valueOf(400), DanskeBank.getBalance("1A"));
		assertEquals(Integer.valueOf(200), SweBank.getBalance("1A"));

		SweBank.addTimedPayment("1A", "Payment1", 2, 2, new Money(100, SEK), DanskeBank, "1A");
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		assertEquals(Integer.valueOf(475), DanskeBank.getBalance("1A"));
		assertEquals(Integer.valueOf(100), SweBank.getBalance("1A"));
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		assertEquals(Integer.valueOf(550), DanskeBank.getBalance("1A"));
		assertEquals(Integer.valueOf(0), SweBank.getBalance("1A"));
	}
}
