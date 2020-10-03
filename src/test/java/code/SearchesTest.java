package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class SearchesTest {

    @Test
    void testFirstSearch(){
        assertEquals(List.of(2.0, 4.0/3), new Searches()
                .findDecimalImproperFractionByUserName("Ana")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindHighestFraction(){
        Fraction highest = new Fraction(2,1);
        assertEquals(highest,new Searches().findHighestFraction());
    }

    @Test
    void testFindFirstDecimalFractionByUserName(){
        assertEquals(0,new Searches().findFirstDecimalFractionByUserName("Antonio"));
        assertEquals(2,new Searches().findFirstDecimalFractionByUserName("Ana"));
    }
}
