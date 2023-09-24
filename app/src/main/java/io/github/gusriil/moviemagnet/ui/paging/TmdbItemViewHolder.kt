package io.github.gusriil.moviemagnet.ui.paging

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.gusriil.moviemagnet.databinding.TmdbItemBinding
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.util.layoutInflater

class TmdbItemViewHolder(val binding: TmdbItemBinding)
    : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun <T : TmdbItem> create(parent: ViewGroup, tmdbClickCallback: TmdbClickCallback<T>): TmdbItemViewHolder {
            val binding: TmdbItemBinding = TmdbItemBinding.inflate(parent.context.layoutInflater,
                    parent, false)
            binding.callback = tmdbClickCallback
            return TmdbItemViewHolder(binding)
        }
    }
}