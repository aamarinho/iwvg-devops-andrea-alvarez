package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    private User user;

    @BeforeEach
    void before(){
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1,3));
        fractions.add(new Fraction(2,5));
        user = new User("12345678A","Andrea","Alvarez",fractions);
    }

    @Test
    void testToString(){
        String temp = "User{" +
                "id='" + user.getId() + '\'' +
                ", name='" + user.getName() + '\'' +
                ", familyName='" + user.getFamilyName() + '\'' +
                ", fractions=" + user.getFractions() +
                '}';
        assertEquals(temp,user.toString());
    }
}
