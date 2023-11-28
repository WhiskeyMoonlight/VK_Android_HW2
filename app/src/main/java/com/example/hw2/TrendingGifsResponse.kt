package com.example.hw2

import com.google.gson.annotations.SerializedName

data class TrendingGifsResponse(
    @SerializedName("data")
    val data: List<GifData>
)


data class GifData(
    @SerializedName("images")
    val images: Image
)


data class Image(
    @SerializedName("original")
    val original: Original
)


data class Original(
    @SerializedName("height")
    val height: String,

    @SerializedName("width")
    val width: String,

    @SerializedName("size")
    val size: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("mp4_size")
    val mp4_size: String,

    @SerializedName("mp4")
    val mp4: String,

    @SerializedName("webp_size")
    val webp_size: String,

    @SerializedName("webp")
    val webp: String,

    @SerializedName("frames")
    val frames: String,

    @SerializedName("hash")
    val hash: String,
)