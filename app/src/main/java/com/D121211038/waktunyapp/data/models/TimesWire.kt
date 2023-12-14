package com.D121211038.waktunyapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class TimesWire(

	@SerializedName("per_facet")
	val perFacet: List<String?>? = null,

	@SerializedName("subsection")
	val subsection: String? = null,

	@SerializedName("item_type")
	val itemType: String? = null,

	@SerializedName("first_published_date")
	val firstPublishedDate: String? = null,

	@SerializedName("org_facet")
	val orgFacet: List<String?>? = null,

	@SerializedName("section")
	val section: String? = null,

	@SerializedName("abstract")
	val jsonMemberAbstract: String? = null,

	@SerializedName("source")
	val source: String? = null,

	@SerializedName("related_urls")
	val relatedUrls: List<String?>? = null,

	@SerializedName("title")
	val title: String? = null,

	@SerializedName("des_facet")
	val desFacet: List<String?>? = null,

	@SerializedName("uri")
	val uri: String? = null,

	@SerializedName("url")
	val url: String? = null,

	@SerializedName("material_type_facet")
	val materialTypeFacet: String? = null,

	@SerializedName("multimedia")
	val multimedia: List<TimesWireMultimediaItem?>? = null,

	@SerializedName("geo_facet")
	val geoFacet: List<String?>? = null,

	@SerializedName("slug_name")
	val slugName: String? = null,

	@SerializedName("updated_date")
	val updatedDate: String? = null,

	@SerializedName("created_date")
	val createdDate: String? = null,

	@SerializedName("byline")
	val byline: String? = null,

	@SerializedName("published_date")
	val publishedDate: String? = null,

	@SerializedName("subheadline")
	val subheadline: String? = null,

	@SerializedName("kicker")
	val kicker: String? = null
): Parcelable

@Parcelize
@Serializable
data class TimesWireMultimediaItem(

	@SerializedName("copyright")
	val copyright: String? = null,

	@SerializedName("subtype")
	val subtype: String? = null,

	@SerializedName("format")
	val format: String? = null,

	@SerializedName("width")
	val width: Int? = null,

	@SerializedName("caption")
	val caption: String? = null,

	@SerializedName("type")
	val type: String? = null,

	@SerializedName("url")
	val url: String? = null,

	@SerializedName("height")
	val height: Int? = null
): Parcelable
