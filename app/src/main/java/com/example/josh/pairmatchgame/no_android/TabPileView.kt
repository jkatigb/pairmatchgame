package com.example.josh.pairmatchgame.no_android

import android.content.Context
import android.view.ViewManager
import com.example.josh.pairmatchgame.GameModel
import com.example.josh.pairmatchgame.GamePresenter
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

/**
 * Created by Josh on 3/31/2017.
 */

class TabPileView(context: Context, val index: Int) : _RelativeLayout(context) {
    init {
        addViews()
    }

    fun update() {
        removeAllViews()
        addViews()
    }


    private fun addViews() {
        val cards = GameModel.tableauPiles[index].cards
        cards.forEachIndexed { i, card ->
            imageView {
                y = (i * dip(25)).toFloat()
                imageResource = if (card.faceUp) getResIdForCard(card) else cardBackDrawable
                onClick {
                    GamePresenter.onTableauTap(index, i)
                }
            }.lparams(context.cardWidth, context.cardHeight)
        }
    }

}

fun ViewManager.TabPileView(index: Int, init: TabPileView.() -> Unit = {}) =
        ankoView({ TabPileView(it, index) }, 0, init)
