package io.aiontechnology.currency;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * Represents a monetary value in a particular currency.
 */
@RequiredArgsConstructor
public class Money {

    private final BigDecimal value;
    private final Currency currency;

    public double asDouble() {
        return value.doubleValue();
    }

}
