package timifeoluwa.example.buzznews.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import timifeoluwa.example.buzznews.databinding.FragmentDetailBinding

class DetailsFragment : Fragment() {
    private val viewModel: DetailsViewModel by lazy {
        ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val article = DetailsFragmentArgs.fromBundle(arguments!!).selectedArticle
        val viewModelFactory = DetailViewModelFactory(article, application)
        binding.viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(DetailsViewModel::class.java)
        (activity as AppCompatActivity).supportActionBar?.title = "Details"
        return binding.root
    }
}

