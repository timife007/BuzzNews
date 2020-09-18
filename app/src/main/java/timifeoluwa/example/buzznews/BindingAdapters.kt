package timifeoluwa.example.buzznews

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import timifeoluwa.example.buzznews.network.Article
import timifeoluwa.example.buzznews.network.Source
import timifeoluwa.example.buzznews.news.NewsStatus
import timifeoluwa.example.buzznews.news.RecyclerViewAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Article>?) {
    val adapter = recyclerView.adapter as RecyclerViewAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("newsStatus")
fun bindStatus(statusImageView: ImageView, status: NewsStatus?) {
    when (status) {
        NewsStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        NewsStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        NewsStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}


@BindingAdapter("newsTitle")
fun bindTitle(txt: TextView, title: String?) {
    txt.text = title
}

@BindingAdapter("newsDesc")
fun bindDesc(txt: TextView, desc: String?) {
    txt.text = desc
}

@BindingAdapter("newsAuthor")
fun bindAuth(txt: TextView, author: String?) {
    txt.text = author
}

@BindingAdapter("newsSource")
fun bindSource(txt: TextView, source: Source?) {
    txt.text = source?.name
}

@BindingAdapter("newsPublish")
fun bindDate(txt: TextView, publishedAt: String?) {
    txt.text = publishedAt
}

@BindingAdapter("content")
fun bindContent(txt: TextView, content: String?) {
    txt.text = content
}

@BindingAdapter("newsLink")
fun bindLink(txt: TextView, url: String?) {
    txt.text = url
}