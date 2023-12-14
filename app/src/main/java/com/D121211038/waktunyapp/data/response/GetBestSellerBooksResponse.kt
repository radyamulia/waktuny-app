package com.D121211038.waktunyapp.data.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.D121211038.waktunyapp.data.models.BestSellerBook
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.Serial

@Parcelize
@Serializable
data class GetBestSellerBooksResponse(

	@SerialName("copyright")
	val copyright: String? = null,

	@SerialName("last_modified")
	val lastModified: String? = null,

	@SerialName("results")
	val results: Results? = null,

	@SerialName("num_results")
	val numResults: Int? = null,

	@SerialName("status")
	val status: String? = null
) : Parcelable

@Parcelize
@Serializable
data class Results(

	@SerialName("next_published_date")
	val nextPublishedDate: String? = null,

	@SerialName("bestsellers_date")
	val bestsellersDate: String? = null,

	@SerialName("books")
	val books: List<BestSellerBook>? = null,

	@SerialName("published_date_description")
	val publishedDateDescription: String? = null,

	@SerialName("normal_list_ends_at")
	val normalListEndsAt: Int? = null,

	@SerialName("list_name")
	val listName: String? = null,

	@SerialName("list_name_encoded")
	val listNameEncoded: String? = null,

	@SerialName("previous_published_date")
	val previousPublishedDate: String? = null,

	@SerialName("display_name")
	val displayName: String? = null,

	@SerialName("correction")
	val correction: List<String?>? = null,

	@SerialName("published_date")
	val publishedDate: String? = null,

	@SerialName("updated")
	val updated: String? = null
) : Parcelable
