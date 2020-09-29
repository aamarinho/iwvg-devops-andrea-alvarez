package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private Fraction fraction;
    private Fraction fraction2;
    private Fraction fraction3;

    @BeforeEach
    void before(){
        fraction = new Fraction(2,5);
        fraction2 = new Fraction(1,3);
        fraction3 = new Fraction(1,3);
    }

    @Test
    void testIsProper(){
        assertTrue(fraction.isProper());
    }

    @Test
    void testIsImproper(){
        assertFalse(fraction.isImproper());
    }

    @Test
    void testIsEquivalent(){
        assertFalse(fraction.isEquivalent(fraction2));
        assertTrue(fraction2.isEquivalent(fraction3));
    }

    @Test
    void testAdd(){
        assertEquals(new Fraction(11,15),fraction.add(fraction2));
        assertEquals(new Fraction(6,9),fraction2.add(fraction2));
    }

    @Test
    void testMultiply(){
        assertEquals(new Fraction(2,15),fraction.multiply(fraction2));
    }

    @Test
    void testDivide(){
        assertEquals(new Fraction(6,5),fraction.divide(fraction2));
        assertEquals(new Fraction(5,6),fraction2.divide(fraction));
    }

    @Test
    void testEquals(){
        assertEquals(fraction2, fraction3);
        assertNotEquals(fraction2, fraction);
    }

    @Test
    void testHashcode(){
        assertEquals(fraction2.hashCode(),fraction3.hashCode());
        assertNotEquals(fraction2.hashCode(),fraction.hashCode());
    }

    @Test
    void testToString(){
        String temp= "Fraction{" +
                "numerator=" + fraction.getNumerator() +
                ", denominator=" + fraction.getDenominator() +
                '}';
        assertEquals(temp,fraction.toString());
    }

}
