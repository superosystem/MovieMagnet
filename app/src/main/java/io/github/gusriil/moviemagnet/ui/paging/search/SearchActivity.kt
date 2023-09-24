package io.github.gusriil.moviemagnet.ui.paging.search

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.SearchView.OnQueryTextListener
import android.widget.TextView
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.databinding.ActivitySearchBinding
import io.github.gusriil.moviemagnet.ui.BaseActivity
import io.github.gusriil.moviemagnet.util.replaceFragmentInActivity

abstract class SearchActivity<T: TmdbItem> : BaseActivity() {

    protected abstract val fragment: BaseSearchFragment<T>

    protected abstract val hintId: Int

    private lateinit var binding: ActivitySearchBinding

    override val networkStatusLayout: View
        get() = binding.networkStatusLayout

    override val textViewNetworkStatus: TextView
        get() = binding.textViewNetworkStatus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        with(binding) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
            // inputType & ime options seem to be ignored from XML! Set in code
            searchView.inputType = InputType.TYPE_TEXT_FLAG_CAP_WORDS
            searchView.imeOptions = searchView.imeOptions or EditorInfo.IME_ACTION_SEARCH or
                    EditorInfo.IME_FLAG_NO_EXTRACT_UI or EditorInfo.IME_FLAG_NO_FULLSCREEN
            searchView.requestFocus()

            searchBack.setOnClickListener {
                finishAfterTransition()
            }

            searchView.queryHint = getString(hintId)
            replaceFragmentInActivity(fragment, R.id.fragment_container)

            searchView.setOnQueryTextListener(object : OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    fragment.search(query)
                    return true
                }

                override fun onQueryTextChange(query: String): Boolean {
                    if (query.isNotEmpty()) {
                        fragmentContainer.visibility = View.VISIBLE
                        fragment.search(query)
                    } else {
                        fragmentContainer.visibility = View.GONE
                        fragment.observeRefreshState()
                    }
                    return true
                }
            })
        }
    }
}