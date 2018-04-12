package ec.solmedia.kotlinawesome

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import kotlinx.android.synthetic.main.galapagos.*

class MainActivity : AppCompatActivity() {

    private var show = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.galapagos)

        backgroundImage.setOnClickListener {
            if (show) animateComponent(false, R.layout.galapagos)
            else animateComponent(true, R.layout.galapagos_detail)
        }
    }

    private fun animateComponent(state: Boolean, layout: Int) {
        show = state

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, layout)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }
}
