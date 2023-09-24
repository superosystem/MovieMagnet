package io.github.gusriil.moviemagnet.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.databinding.FragmentDetailBinding
import io.github.gusriil.moviemagnet.domain.model.Credit
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.ui.BaseDetailFragment
import io.github.gusriil.moviemagnet.ui.detail.credit.CreditAdapter
import io.github.gusriil.moviemagnet.ui.detail.credit.CreditClickListener
import io.github.gusriil.moviemagnet.util.setupActionBar
import io.github.gusriil.moviemagnet.util.toVisibility
import javax.inject.Inject

abstract class DetailFragment : BaseDetailFragment<DetailViewModel, FragmentDetailBinding>
    (R.layout.fragment_detail) {

    @Inject
    lateinit var tmdbItem: TmdbItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        with(binding) {
            tmdbItem = this@DetailFragment.tmdbItem
            viewModel.liveData.observe(viewLifecycleOwner) { detailWrapper ->
                castList.setupAdapter(detailWrapper.cast)
                crewList.setupAdapter(detailWrapper.crew)
            }
            with(activity as AppCompatActivity) {
                setupActionBar(detailsToolbar) {
                    setDisplayShowTitleEnabled(false)
                    setDisplayHomeAsUpEnabled(true)
                    setDisplayShowHomeEnabled(true)
                }
            }


            this@DetailFragment.tmdbItem.overview.trim().isNotEmpty().also {
                summaryLabel.toVisibility(it)
                summary.toVisibility(it)
            }

            summary.setOnClickListener {
                val maxLine = resources.getInteger(R.integer.max_lines)
                summary.maxLines = if (summary.maxLines > maxLine) maxLine else Int.MAX_VALUE
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailsMotion.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}

            override fun onTransitionChange(
                motionLayout: MotionLayout,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                binding.detailsAppbarBackground.cutProgress = 1f - progress
                binding.detailsPoster .visibility = View.VISIBLE
            }

            @SuppressLint("RestrictedApi")
            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.end -> {
                        binding.detailsAppbarBackground.cutProgress = 0f
                        binding.detailsPoster.visibility = View.GONE
                    }
                    R.id.start -> {
                        binding.detailsAppbarBackground.cutProgress = 1f
                        binding.detailsPoster.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun <T : Credit> RecyclerView.setupAdapter(items: List<T>) {
        layoutManager = GridLayoutManager(
            activity, 1,
            GridLayoutManager.HORIZONTAL, false
        )
        setHasFixedSize(true)
        adapter = CreditAdapter(items, CreditClickListener(context))
    }
}