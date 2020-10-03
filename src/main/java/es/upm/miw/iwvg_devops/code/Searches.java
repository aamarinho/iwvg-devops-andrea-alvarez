package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isImproper)
                .map(Fraction::decimal);
    }

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(1, 1), Fraction::isHigher);
    }

    public Double findFirstDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal).findFirst().orElse(null);
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFamilyName().equals(familyName))
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(1, 1), Fraction::multiply);
    }
}
