package com.example.smartpay.fragment

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.smartpay.MainActivity
import com.example.smartpay.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

abstract class BaseFragment : Fragment() {
    protected lateinit var mainActivity: MainActivity

    val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9+._%\\-]{1,256}" +
                "@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    lateinit var passwordError: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = requireActivity() as MainActivity

    }


    protected fun navigate(command: NavigationCommand): Any {
        return when (command) {
            is NavigationCommand.To -> {
                try {
                    this.findNavController().navigate(
                        command.directions,
                        FragmentNavigatorExtras()
                    )
                } catch (e: Exception) {

                }
            }

            is NavigationCommand.Back -> findNavController().navigateUp()
        }
    }

    fun isValidEmail( emailBase: TextInputEditText, emailLayout: TextInputLayout): Boolean {

        if (EMAIL_ADDRESS_PATTERN.matcher(emailBase.text).matches()) {
            emailBase.background = ResourcesCompat.getDrawable(
                resources,
                R.drawable.custom_edittext,
                resources.newTheme()
            )
        } else {
            emailLayout.error = "Invalid email format"
            emailBase.background = ResourcesCompat.getDrawable(
                resources,
                R.drawable.custome_edittext_error,
                resources.newTheme()
            )
        }
        return EMAIL_ADDRESS_PATTERN.matcher(emailBase.text).matches()
    }

 fun isValidPassword(passwordBase: TextInputEditText, passwordLayout: TextInputLayout): Boolean {
        if (passwordChecker(passwordBase.text.toString().trim())) {
           passwordBase.background = ResourcesCompat.getDrawable(
                resources,
                R.drawable.custom_edittext,
                resources.newTheme()
            )
        } else {
            passwordLayout.error = passwordError
            passwordBase.background= ResourcesCompat.getDrawable(
                resources,
                R.drawable.custome_edittext_error,
                resources.newTheme()
            )
        }

        return true
    }

    fun passwordChecker(password: String): Boolean {
        if (password.length < 8) {
            passwordError = "Password must not be less than 8 digits"
            return false
        }
        if (password.firstOrNull { it.isDigit() } == null) {
            passwordError = "Please input a digit"
            return false
        }
        if (password.filter { it.isLetter() }.firstOrNull { it.isUpperCase() } == null) {
            passwordError = "Must contain uppercase"
            return false
        }
        if (password.filter { it.isLetter() }.firstOrNull { it.isLowerCase() } == null) {
            passwordError = "Must contain lowercase"
            return false
        }
        if (password.firstOrNull { !it.isLetterOrDigit() } == null) {
            passwordError = "Must contain symbol"
            return false
        }
        return true
    }


    protected fun headerTitle(header: CharSequence, start: Int, end: Int): SpannableString {
        val spannable = SpannableString(header) // String for which you want to change the color
        spannable.setSpan(
            ForegroundColorSpan(
                ResourcesCompat.getColor(
                    resources,
                    R.color.primaryColor,
                    resources.newTheme()
                )
            ), start, end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannable
    }

    sealed class NavigationCommand {
        data class To(val directions: NavDirections) : NavigationCommand()
        object Back : NavigationCommand()
    }
}