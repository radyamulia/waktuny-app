package com.D121211038.waktunyapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class BestSellerBook(
	@SerialName("isbns")
	val isbns: List<IsbnsItem?>? = null,

	@SerialName("contributor_note")
	val contributorNote: String? = null,

	@SerialName("asterisk")
	val asterisk: Int? = null,

	@SerialName("description")
	val description: String? = null,

	@SerialName("primary_isbn10")
	val primaryIsbn10: String? = null,

	@SerialName("primary_isbn13")
	val primaryIsbn13: String? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("weeks_on_list")
	val weeksOnList: Int? = null,

	@SerialName("article_chapter_link")
	val articleChapterLink: String? = null,

	@SerialName("book_image_width")
	val bookImageWidth: Int? = null,

	@SerialName("contributor")
	val contributor: String? = null,

	@SerialName("amazon_product_url")
	val amazonProductUrl: String? = null,

	@SerialName("price")
	val price: String? = null,

	@SerialName("book_uri")
	val bookUri: String? = null,

	@SerialName("rank")
	val rank: Int? = null,

	@SerialName("dagger")
	val dagger: Int? = null,

	@SerialName("author")
	val author: String? = null,

	@SerialName("age_group")
	val ageGroup: String? = null,

	@SerialName("buy_links")
	val buyLinks: List<BuyLinksItem?>? = null,

	@SerialName("sunday_review_link")
	val sundayReviewLink: String? = null,

	@SerialName("book_review_link")
	val bookReviewLink: String? = null,

	@SerialName("book_image_height")
	val bookImageHeight: Int? = null,

	@SerialName("book_image")
	val bookImage: String? = null,

	@SerialName("publisher")
	val publisher: String? = null,

	@SerialName("rank_last_week")
	val rankLastWeek: Int? = null,

	@SerialName("first_chapter_link")
	val firstChapterLink: String? = null
): Parcelable

@Parcelize
@Serializable
data class BuyLinksItem(
	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
): Parcelable

@Parcelize
@Serializable
data class IsbnsItem(
	@SerialName("isbn13")
	val isbn13: String? = null,

	@SerialName("isbn10")
	val isbn10: String? = null
): Parcelable
