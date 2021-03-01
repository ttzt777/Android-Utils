package cc.bear3.util.utils.span

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 *
 * @author TT
 * @since 2021-3-1
 */
class SpanUtil {
    companion object {
        fun getDrawableSpan(context: Context?, @DrawableRes resId: Int) : CharSequence {
            if (context == null) {
                return ""
            }

            val drawable = ContextCompat.getDrawable(context, resId) ?: return ""

            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)

            val sp = SpannableString("image")
            val span = CenterAlignImageSpan(drawable)
            sp.setSpan(span, 0, sp.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            return sp
        }
    }
}