package io.aiontechnology.currency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    private static final Currency USD = Currency.getInstance("USD");
    private static final Currency EUR = Currency.getInstance("EUR");

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
    void add_sameCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(USD).build();

        // Exercise the SUT
        Money result = first.add(second);

        // Validate
        assertEquals(9.55, result.asDouble());
        assertEquals(USD, result.getCurrency());
    }

    @Test()
    void add_differentCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(EUR).build();

        // Execute the SUT
        Executable executable = () -> first.add(second);

        // Validation
        assertThrows(IllegalStateException.class, executable);
    }

    @Test
    void subtract_sameCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(USD).build();

        // Exercise the SUT
        Money result = first.substract(second);

        // Validate
        assertEquals(1.13, result.asDouble());
        assertEquals(USD, result.getCurrency());
    }

    @Test()
    void subtract_differentCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(EUR).build();

        // Execute the SUT
        Executable executable = () -> first.substract(second);

        // Validation
        assertThrows(IllegalStateException.class, executable);
    }

    @Test
    void multiply_sameCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(USD).build();

        // Exercise the SUT
        Money result = first.multiply(second);

        // Validate
        assertEquals(22.48, result.asDouble());
        assertEquals(USD, result.getCurrency());
    }

    @Test()
    void multiply_differentCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(EUR).build();

        // Execute the SUT
        Executable executable = () -> first.multiply(second);

        // Validation
        assertThrows(IllegalStateException.class, executable);
    }

    @Test
    void divide_sameCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(USD).build();

        // Exercise the SUT
        Money result = first.divide(second);

        // Validate
        assertEquals(1.27, result.asDouble());
        assertEquals(USD, result.getCurrency());
    }

    @Test()
    void divide_differentCurrency() {
        // Setup the fixture
        Money first = Money.value(BigDecimal.valueOf(5.34)).withCurrency(USD).build();
        Money second = Money.value(BigDecimal.valueOf(4.21)).withCurrency(EUR).build();

        // Execute the SUT
        Executable executable = () -> first.divide(second);

        // Validation
        assertThrows(IllegalStateException.class, executable);
    }

}