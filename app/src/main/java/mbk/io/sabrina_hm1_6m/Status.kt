package mbk.io.sabrina_hm1_6m

import android.widget.ImageView

class Status (private val imgCircleStatus: ImageView) {

    fun setStatusImage(status: String) {
        when (status) {
            "Alive" -> imgCircleStatus.setBackgroundResource(R.drawable.ic_alive)
            "Dead" -> imgCircleStatus.setBackgroundResource(R.drawable.ic_death)
            else -> imgCircleStatus.setBackgroundResource(R.drawable.ic_unknown)
        }
    }
}