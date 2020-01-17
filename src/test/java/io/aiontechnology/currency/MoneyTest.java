package io.aiontechnology.currency;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {

    private static final Currency USD = Currency.getInstance("USD");

    @Test
    void asDouble() {
        // Setup the fixture
        BigDecimal value = BigDecimal.valueOf(13.29);

        // Exercise the SUT
        Money money = Money.value(value).withCurrency(USD).build();
        double result = money.asDouble();

        // validate;
        assertEquals(value.doubleValue(), result);
    }

    @Test
    void asDouble_3decimals() {
        // Setup the fixture
        BigDecimal value = BigDecimal.valueOf(13.29);

        // Exercise the SUT
        Money money = Money.value(value).withCurrency(USD).build();
        double result = money.asDouble();

        // validate;
        assertEquals(value.doubleValue(), result);
    }

    @Test
    void multiply_sameCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(USD).build();

        // Exercise the SUT
        Money result = first.multiply(second);

        // Validate
        assertEquals(result.asDouble(), 22.4814);
        assertEquals(result.getCurrency(), USD);
    }

    @Test
    void multiply_differentCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(USD).build();

        // Execute the SUT

        // Validation
    }
}