package timifeoluwa.example.buzznews.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import timifeoluwa.example.buzznews.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    val viewModel: SettingsViewModel by lazy {
        ViewModelProviders.of(this).get(SettingsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSettingsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        (activity as AppCompatActivity).supportActionBar?.title = "Settings"
        return binding.root


    }
}