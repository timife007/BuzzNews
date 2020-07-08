package timifeoluwa.example.buzznews.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import timifeoluwa.example.buzznews.databinding.ListViewItemBinding
import timifeoluwa.example.buzznews.network.Article

class RecyclerViewAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Article, RecyclerViewAdapter.ArticlesViewHolder>(DiffCallback) {
    class ArticlesViewHolder(private var binding: ListViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.articles = article
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return newItem === oldItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return newItem == oldItem
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticlesViewHolder {
        return ArticlesViewHolder(ListViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(article)
        }
    }

    class OnClickListener(val clickListener: (article: Article) -> Unit) {
        fun onClick(article: Article) = clickListener(article)
    }
}