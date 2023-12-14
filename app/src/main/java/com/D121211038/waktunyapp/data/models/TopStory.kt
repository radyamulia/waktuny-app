package com.D121211038.waktunyapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class TopStory(

	@SerialName("per_facet")
	val perFacet: List<String?>? = null,

	@SerialName("subsection")
	val subsection: String? = null,

	@SerialName("item_type")
	val itemType: String? = null,

	@SerialName("org_facet")
	val orgFacet: List<String?>? = null,

	@SerialName("section")
	val section: String? = null,

	@SerialName("abstract")
	val jsonMemberAbstract: String? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("des_facet")
	val desFacet: List<String?>? = null,

	@SerialName("uri")
	val uri: String? = null,

	@SerialName("url")
	val url: String? = null,

	@SerialName("short_url")
	val shortUrl: String? = null,

	@SerialName("material_type_facet")
	val materialTypeFacet: String? = null,

	@SerialName("multimedia")
	val multimedia: List<TopStoryMultimediaItem?>? = null,

	@SerialName("geo_facet")
	val geoFacet: List<String?>? = null,

	@SerialName("updated_date")
	val updatedDate: String? = null,

	@SerialName("created_date")
	val createdDate: String? = null,

	@SerialName("byline")
	val byline: String? = null,

	@SerialName("published_date")
	val publishedDate: String? = null,

	@SerialName("kicker")
	val kicker: String? = null
): Parcelable

@Parcelize
@Serializable
data class TopStoryMultimediaItem(

	@SerialName("copyright")
	val copyright: String? = null,

	@SerialName("subtype")
	val subtype: String? = null,

	@SerialName("format")
	val format: String? = null,

	@SerialName("width")
	val width: Int? = null,

	@SerialName("caption")
	val caption: String? = null,

	@SerialName("type")
	val type: String? = null,

	@SerialName("url")
	val url: String? = null,

	@SerialName("height")
	val height: Int? = null
): Parcelable
