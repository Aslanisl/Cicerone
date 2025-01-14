package com.github.terrakok.cicerone.sample.mvp.animation.profile

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.sample.R
import com.github.terrakok.cicerone.sample.Screens.SelectPhoto
import moxy.InjectViewState
import moxy.MvpPresenter

/**
 * Created by Konstantin Tskhovrebov (aka @terrakok) on 14.07.17.
 */
@InjectViewState
class ProfilePresenter(
        private val router: Router
) : MvpPresenter<ProfileView>() {

    companion object {
        private const val RESULT_KEY = "photo_result"
        private const val DEFAULT_PHOTO = R.drawable.ava_1
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState!!.showPhoto(DEFAULT_PHOTO)
    }

    fun onPhotoClicked() {
        router.setResultListener(RESULT_KEY) { data ->
            viewState!!.showPhoto(data as Int)
        }
        router.navigateTo(SelectPhoto(RESULT_KEY))
    }

    fun onBackPressed() {
        router.exit()
    }
}