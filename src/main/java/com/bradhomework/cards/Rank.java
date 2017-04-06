package com.bradhomework.cards;

/**
 * Enumeration of card ranks.
 */
public enum Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    /**
     * Value of rank.
     */
    private int value;

    /**
     * Constructs a Rank enum.
     *
     * @param value of rank.
     */
    Rank(final int value) {
        this.value = value;
    }
}
