package com.D121211038.waktunyapp.data.response

import android.os.Parcelable
import com.D121211038.waktunyapp.data.models.TopStory
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class GetTopStoriesResponse(

	@SerializedName("copyright")
	val copyright: String? = null,

	@SerializedName("last_updated")
	val lastUpdated: String? = null,

	@SerializedName("section")
	val section: String? = null,

	@SerializedName("num_results")
	val numResults: Int? = null,

	@SerializedName("status")
	val status: String? = null,

	@SerializedName("results")
	val results: List<TopStory>? = null
): Parcelable
