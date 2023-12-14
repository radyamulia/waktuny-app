package com.D121211038.waktunyapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class PopularArticle(
	@SerialName("per_facet")
	val perFacet: List<String?>? = null,

	@SerialName("eta_id")
	val etaId: Int? = null,

	@SerialName("subsection")
	val subsection: String? = null,

	@SerialName("org_facet")
	val orgFacet: List<String?>? = null,

	@SerialName("nytdsection")
	val nytdsection: String? = null,

	@SerialName("column")
	val column: String? = null,

	@SerialName("section")
	val section: String? = null,

	@SerialName("asset_id")
	val assetId: Long? = null,

	@SerialName("source")
	val source: String? = null,

	@SerialName("abstract")
	val jsonMemberAbstract: String? = null,

	@SerialName("media")
	val media: List<MediaItem?>? = null,

	@SerialName("type")
	val type: String? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("des_facet")
	val desFacet: List<String?>? = null,

	@SerialName("uri")
	val uri: String? = null,

	@SerialName("url")
	val url: String? = null,

	@SerialName("adx_keywords")
	val adxKeywords: String? = null,

	@SerialName("geo_facet")
	val geoFacet: List<String?>? = null,

	@SerialName("id")
	val id: Long? = null,

	@SerialName("published_date")
	val publishedDate: String? = null,

	@SerialName("updated")
	val updated: String? = null,

	@SerialName("byline")
	val byline: String? = null
): Parcelable

@Parcelize
@Serializable
data class MediaMetadataItem(

	@SerialName("format")
	val format: String? = null,

	@SerialName("width")
	val width: Int? = null,

	@SerialName("url")
	val url: String? = null,

	@SerialName("height")
	val height: Int? = null
): Parcelable

@Parcelize
@Serializable
data class MediaItem(
	@SerialName("copyright")
	val copyright: String? = null,

	@SerialName("media-metadata")
	val mediaMetadata: List<MediaMetadataItem?>? = null,

	@SerialName("subtype")
	val subtype: String? = null,

	@SerialName("caption")
	val caption: String? = null,

	@SerialName("type")
	val type: String? = null,

	@SerialName("approved_for_syndication")
	val approvedForSyndication: Int? = null
): Parcelable
