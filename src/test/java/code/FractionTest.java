package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private Fraction fraction;
    private Fraction fraction2;
    private Fraction fraction3;
    private Fraction fraction4;

    @BeforeEach
    void before() {
        fraction = new Fraction(2, 5);
        fraction2 = new Fraction(1, 3);
        fraction3 = new Fraction(1, 3);
        fraction4 = new Fraction(4, 3);
    }

    @Test
    void testFraction() {
        assertEquals(new Fraction(1, 1), new Fraction());
    }

    @Test
    void testGetNumerator() {
        assertEquals(2, fraction.getNumerator());
        assertEquals(1, fraction2.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(3);
        assertEquals(3, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(5, fraction.getDenominator());
        assertEquals(3, fraction2.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(10);
        assertEquals(10, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.4, fraction.decimal());
    }

    @Test
    void testIsProper() {
        assertTrue(fraction.isProper());
        assertFalse(fraction4.isProper());
    }

    @Test
    void testIsImproper() {
        assertFalse(fraction.isImproper());
        assertTrue(fraction4.isImproper());
    }

    @Test
    void testIsEquivalent() {
        assertFalse(fraction.isEquivalent(fraction2));
        assertTrue(fraction2.isEquivalent(fraction3));
    }

    @Test
    void testAdd() {
        assertEquals(new Fraction(11, 15), fraction.add(fraction2));
        assertEquals(new Fraction(6, 9), fraction2.add(fraction2));
    }

    @Test
    void testMultiply() {
        assertEquals(new Fraction(2, 15), fraction.multiply(fraction2));
    }

    @Test
    void testDivide() {
        assertEquals(new Fraction(6, 5), fraction.divide(fraction2));
        assertEquals(new Fraction(5, 6), fraction2.divide(fraction));
    }

    @Test
    void testIsHigher() {
        assertEquals(fraction4, fraction.isHigher(fraction4));
        assertEquals(fraction4, fraction4.isHigher(fraction2));
    }

    @Test
    void testEquals() {
        assertEquals(fraction2, fraction3);
        assertNotEquals(fraction2, fraction);
        assertEquals(false, fraction.equals(null));
    }

    @Test
    void testHashcode() {
        assertEquals(fraction2.hashCode(), fraction3.hashCode());
        assertNotEquals(fraction2.hashCode(), fraction.hashCode());
    }

    @Test
    void testToString() {
        String temp = "Fraction{" +
                "numerator=" + fraction.getNumerator() +
                ", denominator=" + fraction.getDenominator() +
                '}';
        assertEquals(temp, fraction.toString());
    }

}
