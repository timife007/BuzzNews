package timifeoluwa.example.buzznews.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Source(
    val id: String?,
    val name: String?
) : Parcelable