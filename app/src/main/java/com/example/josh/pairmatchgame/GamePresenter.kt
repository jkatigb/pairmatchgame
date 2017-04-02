package com.example.josh.pairmatchgame

/**
 * Created by Josh on 3/31/2017.
 */

object GamePresenter {

    var view: GameView? = null

    fun setGameView(gameView: GameView) {
        view = gameView
    }

    fun onDeckTap() {
        GameModel.onDeckTap()
        view?.update()
    }

    fun onWasteTap() {
        GameModel.onWasteTap()
        view?.update()
    }

    fun onFoundationTap(index: Int) {
        GameModel.onFoundationTap(index)
        view?.update()
    }

    fun onTableauTap(index: Int, cardIndex: Int) {
        GameModel.onTableauTap(index, cardIndex)
        view?.update()
    }


}