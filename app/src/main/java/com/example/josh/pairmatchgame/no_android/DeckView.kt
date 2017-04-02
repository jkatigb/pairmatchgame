package com.example.josh.pairmatchgame.no_android

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.example.josh.pairmatchgame.GameModel
import com.example.josh.pairmatchgame.GamePresenter
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by Josh on 3/31/2017.
 */


fun ViewManager.deckView(init: DeckView.() -> Unit = {}) = ankoView(::DeckView, 0, init)

class DeckView(context: Context) : ImageView(context) {
    init {
        imageResource = cardBackDrawable
        onClick {
            GamePresenter.onDeckTap()
        }
    }

    fun update() {
        val cards = GameModel.deck.cardsInDeck
        imageResource = if (cards.isNotEmpty()) cardBackDrawable else emptyPileDrawable
    }
}