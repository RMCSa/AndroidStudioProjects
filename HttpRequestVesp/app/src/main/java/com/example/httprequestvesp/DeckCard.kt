package com.example.httprequestvesp

class DeckCard (
    @SerializedName("sucess") var sucess: String,
    @SerializedName("deck_id") var deck_id: String,
    @SerializedName("cards") var cards: Array<Card>,
    @SerializedName("remaining") var remaining: Int
)



data class Images(
    @SerializedName("code") var code: String,
    @SerializedName("image") var image: String,
    @SerializedName("images") var images: String,
    @SerializedName("value") var value: String,
    @SerializedName("suit") var suit: String
)
