package com.mvvm.mvvmlearnkotlin.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


class WallpaperResponse : ArrayList<WallpaperResponseItem>()

@Entity
data class WallpaperResponseItem(
    @SerializedName("alt_description")
    val altDescription: String? = "",
    @SerializedName("blur_hash")
    val blurHash: String? = "",
    @SerializedName("color")
    val color: String? = "",
    @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("current_user_collections")
    val currentUserCollections: List<Any>? = listOf(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("id")
    @PrimaryKey
    @NonNull
    val id: String,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean? = false,
    @SerializedName("likes")
    val likes: Int? = 0,
    @SerializedName("links")
    val links: Links? = Links(),
    @SerializedName("promoted_at")
    val promotedAt: String? = "",
    @SerializedName("sponsorship")
    val sponsorship: Sponsorship? = Sponsorship(),
    @SerializedName("topic_submissions")
    val topicSubmissions: TopicSubmissions? = TopicSubmissions(),
    @SerializedName("updated_at")
    val updatedAt: String? = "",
    @SerializedName("urls")
    val urls: Urls? = Urls(),
    @SerializedName("user")
    val user: User? = User(),
    @SerializedName("width")
    val width: Int? = 0
)


data class Links(
    @SerializedName("download")
    val download: String? = null,
    @SerializedName("download_location")
    val downloadLocation: String? = null,
    @SerializedName("html")
    val html: String? = null,
    @SerializedName("self")
    val self: String? = null
)


data class Sponsorship(
    @SerializedName("impression_urls")
    val impressionUrls: List<String>? = listOf(),
    @SerializedName("sponsor")
    val sponsor: Sponsor? = Sponsor(),
    @SerializedName("tagline")
    val tagline: String? = "",
    @SerializedName("tagline_url")
    val taglineUrl: String? = ""
)

data class TopicSubmissions(
    @SerializedName("3d-renders")
    val dRenders: DRenders? = null,
    @SerializedName("experimental")
    val experimental: Experimental? = null,
    @SerializedName("people")
    val people: People? = null,
    @SerializedName("textures-patterns")
    val texturesPatterns: TexturesPatterns? = null,
    @SerializedName("wallpapers")
    val wallpapers: Wallpapers? = null
)

@Entity
data class Urls(
    @SerializedName("full")
    val full: String? = null,
    @SerializedName("raw")
    val raw: String? = null,
    @SerializedName("regular")
    val regular: String? = null,
    @SerializedName("small")
    val small: String? = null,
    @SerializedName("small_s3")
    val smallS3: String? = null,
    @SerializedName("thumb")
    val thumb: String? = null
)

data class User(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean? = false,
    @SerializedName("bio")
    val bio: String? = "",
    @SerializedName("first_name")
    val firstName: String? = "",
    @SerializedName("for_hire")
    val forHire: Boolean? = false,
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("instagram_username")
    val instagramUsername: String? = "",
    @SerializedName("last_name")
    val lastName: String? = "",
    @SerializedName("links")
    val links: LinksX? = LinksX(),
    @SerializedName("location")
    val location: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("portfolio_url")
    val portfolioUrl: String? = "",
    @SerializedName("profile_image")
    val profileImage: ProfileImage? = ProfileImage(),
    @SerializedName("social")
    val social: Social? = Social(),
    @SerializedName("total_collections")
    val totalCollections: Int? = 0,
    @SerializedName("total_likes")
    val totalLikes: Int? = 0,
    @SerializedName("total_photos")
    val totalPhotos: Int? = 0,
    @SerializedName("twitter_username")
    val twitterUsername: String? = "",
    @SerializedName("updated_at")
    val updatedAt: String? = "",
    @SerializedName("username")
    val username: String? = ""
)

data class Sponsor(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean? = false,
    @SerializedName("bio")
    val bio: String? = "",
    @SerializedName("first_name")
    val firstName: String? = "",
    @SerializedName("for_hire")
    val forHire: Boolean? = false,
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("instagram_username")
    val instagramUsername: String? = "",
    @SerializedName("last_name")
    val lastName: String? = "",
    @SerializedName("links")
    val links: LinksX? = LinksX(),
    @SerializedName("location")
    val location: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("portfolio_url")
    val portfolioUrl: String? = "",
    @SerializedName("profile_image")
    val profileImage: ProfileImage? = ProfileImage(),
    @SerializedName("social")
    val social: Social? = Social(),
    @SerializedName("total_collections")
    val totalCollections: Int? = 0,
    @SerializedName("total_likes")
    val totalLikes: Int? = 0,
    @SerializedName("total_photos")
    val totalPhotos: Int? = 0,
    @SerializedName("twitter_username")
    val twitterUsername: String? = "",
    @SerializedName("updated_at")
    val updatedAt: String? = "",
    @SerializedName("username")
    val username: String? = ""
)

data class LinksX(
    @SerializedName("followers")
    val followers: String? = null,
    @SerializedName("following")
    val following: String? = null,
    @SerializedName("html")
    val html: String? = null,
    @SerializedName("likes")
    val likes: String? = null,
    @SerializedName("photos")
    val photos: String? = null,
    @SerializedName("portfolio")
    val portfolio: String? = null,
    @SerializedName("self")
    val self: String? = null
)

data class ProfileImage(
    @SerializedName("large")
    val large: String? = null,
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("small")
    val small: String? = null
)

data class Social(
    @SerializedName("instagram_username")
    val instagramUsername: String? = null,
    @SerializedName("paypal_email")
    val paypalEmail: Any? = null,
    @SerializedName("portfolio_url")
    val portfolioUrl: String? = null,
    @SerializedName("twitter_username")
    val twitterUsername: String? = null
)

data class DRenders(
    @SerializedName("status")
    val status: String? = null
)

data class Experimental(
    @SerializedName("status")
    val status: String? = null
)

data class People(
    @SerializedName("status")
    val status: String? = null
)

data class TexturesPatterns(
    @SerializedName("status")
    val status: String? = null
)

data class Wallpapers(
    @SerializedName("status")
    val status: String? = null
)