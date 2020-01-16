package io.aiontechnology.currency;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void asDouble() {
        // Setup the fixture
        BigDecimal value = BigDecimal.valueOf(13.29);

        // Exercise the SUT
        Money money = new Money(value, Currency.USD);
        double result = money.asDouble();

        // validate;
        assertEquals(value.doubleValue(), result);
    }

    @Test
    void asDouble_3decimals() {
        // Setup the fixture
        BigDecimal value = BigDecimal.valueOf(13.29);

        // Exercise the SUT
        Money money = new Money(value, Currency.USD);
        double result = money.asDouble();

        // validate;
        assertEquals(value.doubleValue(), result);
    }

}