package timifeoluwa.example.buzznews.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    val status: String?,
    val totalResult: Long?,
    val articles: List<Article>?
) : Parcelable