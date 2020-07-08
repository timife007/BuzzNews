package timifeoluwa.example.buzznews.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import timifeoluwa.example.buzznews.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {
    private val viewModel: NewsViewModel by lazy {
        ViewModelProviders.of(this).get(NewsViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter =
            RecyclerViewAdapter(RecyclerViewAdapter.OnClickListener {
                viewModel.displayArticleDetails(it)
            })
        viewModel.navigateToSelectedArticle.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController()
                    .navigate(NewsFragmentDirections.actionNewsFragmentToDetailsFragment(it))
                viewModel.displayArticleDetailsComplete()
            }
        })
        (activity as AppCompatActivity).supportActionBar?.title = "Popular News"
        setHasOptionsMenu(true)
        return binding.root

    }
}
