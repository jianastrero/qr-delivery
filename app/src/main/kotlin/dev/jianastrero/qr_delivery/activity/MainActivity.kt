package dev.jianastrero.qr_delivery.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import dagger.hilt.android.AndroidEntryPoint
import dev.jianastrero.qr_delivery.navgraph.MainNavGraph
import dev.jianastrero.qr_delivery.ui.theme.TemplateAndroidAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity(), ViewTreeObserver.OnPreDrawListener {

    private var splashScreenTimerStart = 0L

    private lateinit var content: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSplashScreenAnimation()

        setContent {
            TemplateAndroidAppTheme {
                MainNavGraph()
            }
        }

        content = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(this)

        CoroutineScope(Dispatchers.Default).launch {
            splashScreenTimerStart = System.currentTimeMillis()
            while (System.currentTimeMillis() > splashScreenTimerStart + SPLASH_SCREEN_DURATION) {
                delay(100)
            }
        }
    }

    override fun onPreDraw(): Boolean =
        if (System.currentTimeMillis() > splashScreenTimerStart + SPLASH_SCREEN_DURATION) {
            content.viewTreeObserver.removeOnPreDrawListener(this)
            true
        } else {
            false
        }

    private fun setSplashScreenAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.setOnExitAnimationListener { splashScreenView ->
                val scaleY = ObjectAnimator.ofFloat(
                    splashScreenView,
                    View.SCALE_Y,
                    1f,
                    1.5f
                )
                val scaleX = ObjectAnimator.ofFloat(
                    splashScreenView,
                    View.SCALE_X,
                    1f,
                    1.5f
                )
                val fade = ObjectAnimator.ofFloat(
                    splashScreenView,
                    View.ALPHA,
                    1f,
                    0f
                )

                val animationSet = AnimatorSet().apply {
                    interpolator = AnticipateInterpolator()
                    duration = 500L
                }

                animationSet.doOnEnd { splashScreenView.remove() }
                animationSet
                    .play(scaleX)
                    .with(scaleY)
                    .with(fade)
                animationSet.start()
            }
        }
    }

    companion object {
        private const val SPLASH_SCREEN_DURATION = 1_500L
    }
}

@Preview
@Composable
private fun MainActivityPreview() {
    TemplateAndroidAppTheme {
        MainNavGraph()
    }
}
