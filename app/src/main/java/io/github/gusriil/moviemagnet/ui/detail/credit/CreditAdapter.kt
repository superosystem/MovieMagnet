package io.github.gusriil.moviemagnet.ui.detail.credit

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.databinding.CreditItemBinding
import io.github.gusriil.moviemagnet.domain.model.Credit
import io.github.gusriil.moviemagnet.util.layoutInflater

class CreditAdapter<T : Credit>(
        credits: List<T>,
        private val creditClickCallback: CreditClickCallback<T>)
    : RecyclerView.Adapter<CreditAdapter.CreditViewHolder>() {

    private var credits: List<T> = credits
        set(credit) {
            field = credit
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditViewHolder {
        val binding: CreditItemBinding = DataBindingUtil
                .inflate(parent.context.layoutInflater,
                        R.layout.credit_item,
                        parent, false)
        binding.callback = creditClickCallback
        return CreditViewHolder(binding)
    }

    override fun getItemCount() = credits.size

    override fun onBindViewHolder(holder: CreditViewHolder, position: Int) {
        with(holder.binding) {
            creditItem = credits[position]
            executePendingBindings()
        }
    }

    class CreditViewHolder(val binding: CreditItemBinding) :
            RecyclerView.ViewHolder(binding.root)
}