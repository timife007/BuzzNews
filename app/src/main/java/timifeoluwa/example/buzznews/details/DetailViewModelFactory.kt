package timifeoluwa.example.buzznews.details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timifeoluwa.example.buzznews.network.Article


class DetailViewModelFactory(
    private val article: Article,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(article, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
