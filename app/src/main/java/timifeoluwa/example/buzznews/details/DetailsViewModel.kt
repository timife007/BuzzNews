package timifeoluwa.example.buzznews.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timifeoluwa.example.buzznews.network.Article

class DetailsViewModel(article: Article, application: Application) : AndroidViewModel(application) {

    private val _selectedArticle = MutableLiveData<Article>()
    val selectedArticle: LiveData<Article>
        get() = _selectedArticle

    init {
        _selectedArticle.value = article
    }
}