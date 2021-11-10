package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(Integer.valueOf(10000), SEK100.getAmount());
		assertEquals(Integer.valueOf(1000), EUR10.getAmount());
		assertEquals(Integer.valueOf(20000), SEK200.getAmount());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK100.getCurrency());
		assertEquals(EUR, EUR10.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("100.0 SEK", SEK100.toString());
		assertEquals("10.0 EUR", EUR10.toString());
		assertEquals("20.0 EUR", EUR20.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals(Integer.valueOf(1500), EUR10.universalValue());
		assertEquals(Integer.valueOf(3000), EUR20.universalValue());
		assertEquals(Integer.valueOf(-1500), SEKn100.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		assertTrue(SEK100.equals(EUR10));
		assertTrue(EUR20.equals(SEK200));
		assertFalse(EUR20.equals(SEK100));
		assertFalse(SEKn100.equals(SEK100));
	}

	@Test
	public void testAdd() {
		assertEquals(Integer.valueOf(2000), EUR10.add(SEK100).getAmount());
		assertEquals(Integer.valueOf(0), SEK100.add(SEKn100).getAmount());
		assertEquals(Integer.valueOf(3000), EUR20.add(SEK100).getAmount());
		assertEquals(Integer.valueOf(20000), SEK100.add(EUR10).getAmount());
	}

	@Test
	public void testSub() {
		assertEquals(Integer.valueOf(0), EUR10.sub(SEK100).getAmount());
		assertEquals(Integer.valueOf(20000), SEK100.sub(SEKn100).getAmount());
		assertEquals(Integer.valueOf(1000), EUR20.sub(SEK100).getAmount());
		assertEquals(Integer.valueOf(0), SEK100.sub(EUR10).getAmount());
	}

	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
		assertTrue(SEK0.isZero());
		assertFalse(SEKn100.isZero());
		assertFalse(EUR10.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals(Integer.valueOf(-10000), SEK100.negate().getAmount());
		assertEquals(SEKn100.getAmount(), SEK100.negate().getAmount());
		assertEquals(Integer.valueOf(-1000), EUR10.negate().getAmount());
		assertNotEquals(SEK100.getAmount(), SEK100.negate().getAmount());
		assertEquals(EUR0.getAmount(), EUR0.negate().getAmount());
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, SEK100.compareTo(EUR10));
		assertEquals(1, SEK200.compareTo(SEK100));
		assertEquals(-1, SEK100.compareTo(EUR20));
		assertEquals(0, EUR0.compareTo(EUR0));
	}
}
