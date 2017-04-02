package com.example.josh.pairmatchgame

/**
 * Created by Josh on 3/31/2017.
 */
class FoundationPile(val suit: String) {

    val cards: MutableList<Card> = mutableListOf()

    fun reset() {
        cards.clear()
    }

    fun removeCard(card: Card) {
        cards.remove(card)
    }

    fun addCard(card: Card): Boolean {
        var nextValue: Int = 0
        if (cards.isNotEmpty()) {
            nextValue = cards.last().value + 1
        }
        if (card.suit == suit && card.value == nextValue) {
            cards.add(card)
            return true
        }
        return false
    }
}