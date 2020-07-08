package timifeoluwa.example.buzznews.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timifeoluwa.example.buzznews.network.Article
import timifeoluwa.example.buzznews.network.NewsApi

enum class NewsStatus { LOADING, ERROR, DONE }

class NewsViewModel : ViewModel() {

    private val _status = MutableLiveData<NewsStatus>()
    val status: LiveData<NewsStatus>
        get() = _status

    private val _news = MutableLiveData<List<Article>>()
    val news: LiveData<List<Article>>
        get() = _news

    private val _navigateToSelectedArticle = MutableLiveData<Article>()
    val navigateToSelectedArticle: LiveData<Article>
        get() = _navigateToSelectedArticle

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getLatestNews()
    }

    private fun getLatestNews() {
        coroutineScope.launch {
            val getNewsDeferred = NewsApi.retrofitService.getNewsAsync()
            try {
                _status.value = NewsStatus.LOADING
                val newsResult = getNewsDeferred.await()
//                _status.value  = "Success : ${newsResult.articles?.size} articles retrieved"
                _status.value = NewsStatus.DONE
                _news.value = newsResult.articles
            } catch (e: Exception) {
                _status.value = NewsStatus.ERROR
                _news.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayArticleDetails(article: Article) {
        _navigateToSelectedArticle.value = article
    }

    fun displayArticleDetailsComplete() {
        _navigateToSelectedArticle.value = null
    }
}