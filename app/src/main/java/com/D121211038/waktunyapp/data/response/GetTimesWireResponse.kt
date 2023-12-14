package com.D121211038.waktunyapp.data.response

import android.os.Parcelable
import com.D121211038.waktunyapp.data.models.TimesWire
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class GetTimesWireResponse(

	@SerialName("copyright")
	val copyright: String? = null,

	@SerialName("num_results")
	val numResults: Int? = null,

	@SerialName("status")
	val status: String? = null,

	@SerialName("results")
	val results: List<TimesWire>? = null
): Parcelable
