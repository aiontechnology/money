package io.aiontechnology.currency;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * <p>
 * Represents a monetary value in a particular currency. Objects of this class are immutable.
 * </p>
 * <p>
 * Constructing instance of this class is does through the {@link #value} method. This method returns an instance
 * of {@link Builder} which can be used to set the currency or accept the default (USD). In either case, calling
 * {@link Builder#build()} will return the Money instance.
 * </p>
 */
public class Money {

    /** The numeric value of the money */
    private final BigDecimal value;
    /** The currency of the money */
    private final Currency currency;

    /**
     * Use this method to obtain a Money builder in order to construct a Money instance. The value is required so it
     * must be provided to the builder. This method does not provide a Money object directly. You much call the
     * {@link Builder#build()} method to get it.
     *
     * @param value The value of the desired builder.
     * @return The {@link Builder} object.
     */
    public static Builder value(BigDecimal value) {
        return new Builder(value);
    }

    /**
     * Money constructor. It is private because it should only be called by the {@link Builder#build()} method.
     *
     * @param value The value of the money.
     * @param currency The currency of the money.
     */
    private Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    /**
     * Return the money's value as a double.
     *
     * @return The money's value
     */
    public double asDouble() {
        return value.doubleValue();
    }

    /**
     * Return the money's currency.
     *
     * @return The currency.
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Multiply the given Money object with this Money and return a new one representing their product. Currently the
     * both Money objects must be the same currency. In the future, currency conversion will be supported.
     *
     * @param operand The value to multiple the current money object to.
     * @return The resulting Money object
     */
    public Money multiply(Money operand) {
        if (currency != operand.currency) {
            throw new IllegalStateException("Can't do that yet");
        }
        return new Money(value.multiply(operand.value), currency);
    }

    /**
     * This is a builder class for constructing instances of Money objects.
     */
    public static class Builder {

        /** The numeric value of the money */
        private BigDecimal value;
        /** The currency of the money */
        private Currency currency = Currency.getInstance("USD");

        private Builder(BigDecimal value) {
            this.value = value;
        }

        public Builder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Money build() {
            return new Money(value, currency);
        }

    }

}
