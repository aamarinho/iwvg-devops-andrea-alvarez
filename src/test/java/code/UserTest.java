package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User user;
    private User user2;
    private List<Fraction> fractionsTest;
    private List<Fraction> fractions;

    @BeforeEach
    void before() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 3));
        fractions.add(new Fraction(2, 5));
        user = new User("12345678A", "Andrea", "Alvarez", fractions);
        fractionsTest = new ArrayList<>();
        fractionsTest.add(new Fraction(1, 3));
        fractionsTest.add(new Fraction(2, 5));
        user2 = new User(null, null, null, new ArrayList<>());
    }

    @Test
    void testUser() {
        assertEquals(0, new User().getFractions().size());
    }

    @Test
    void testGetId() {
        assertEquals("12345678A", user.getId());
    }

    @Test
    void testGetName() {
        assertEquals("Andrea", user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("Alvarez", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        assertEquals(fractionsTest, user.getFractions());
    }

    @Test
    void testSetName() {
        user.setName("Lola");
        assertEquals("Lola", user.getName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Mariño");
        assertEquals("Mariño", user.getFamilyName());
    }

    @Test
    void testAddFraction() {
        user.addFraction(new Fraction(2, 2));
        assertEquals(3, user.getFractions().size());
    }

    @Test
    void testSetFraction() {
        user.setFractions(fractionsTest);
        assertEquals(fractionsTest, user.getFractions());
    }

    @Test
    void testFullName() {
        String temp = "Andrea Alvarez";
        assertEquals(temp, user.fullName());
    }

    @Test
    void testInitials() {
        String temp = "A.";
        assertEquals(temp, user.initials());
    }

    @Test
    void testToString() {
        String temp = "User{" +
                "id='" + user.getId() + '\'' +
                ", name='" + user.getName() + '\'' +
                ", familyName='" + user.getFamilyName() + '\'' +
                ", fractions=" + user.getFractions() +
                '}';
        assertEquals(temp, user.toString());
    }
}
