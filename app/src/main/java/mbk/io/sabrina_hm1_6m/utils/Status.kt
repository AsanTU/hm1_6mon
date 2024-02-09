package mbk.io.sabrina_hm1_6m.utils

import android.widget.ImageView
import mbk.io.sabrina_hm1_6m.R

class Status (private val imgCircleStatus: ImageView) {

    fun setStatusImage(status: String) {
        when (status) {
            "Alive" -> imgCircleStatus.setBackgroundResource(R.drawable.ic_alive)
            "Dead" -> imgCircleStatus.setBackgroundResource(R.drawable.ic_death)
            else -> imgCircleStatus.setBackgroundResource(R.drawable.ic_unknown)
        }
    }
}