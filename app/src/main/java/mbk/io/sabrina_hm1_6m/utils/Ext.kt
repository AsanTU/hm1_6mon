package mbk.io.sabrina_hm1_6m.utils

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.showToast(massage:String){
    Toast.makeText(this,massage,Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(massage: String) {
    Toast.makeText(requireContext(), massage, Toast.LENGTH_SHORT).show()
}