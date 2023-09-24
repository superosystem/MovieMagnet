package io.github.gusriil.moviemagnet.ui.detail.credit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.github.gusriil.moviemagnet.domain.model.Credit
import io.github.gusriil.moviemagnet.ui.person.PersonActivity
import io.github.gusriil.moviemagnet.util.Constants.CREDIT

class CreditClickListener<T : Credit>(
    private val context: Context
) : CreditClickCallback<T> {

    override fun onClick(credit: T) {
        val intent = Intent(context, PersonActivity::class.java).apply {
            putExtras(Bundle().apply {
                putParcelable(
                    CREDIT,
                    credit
                )
            })
        }
        context.startActivity(intent)
    }
}