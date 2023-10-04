package com.example.network.user.dto


import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("address")
    var address: Address? = Address(),
    @SerializedName("age")
    var age: Int? = 0,
    @SerializedName("bank")
    var bank: Bank? = Bank(),
    @SerializedName("birthDate")
    var birthDate: String? = "",
    @SerializedName("bloodGroup")
    var bloodGroup: String? = "",
    @SerializedName("company")
    var company: Company? = Company(),
    @SerializedName("domain")
    var domain: String? = "",
    @SerializedName("ein")
    var ein: String? = "",
    @SerializedName("email")
    var email: String? = "",
    @SerializedName("eyeColor")
    var eyeColor: String? = "",
    @SerializedName("firstName")
    var firstName: String? = "",
    @SerializedName("gender")
    var gender: String? = "",
    @SerializedName("hair")
    var hair: Hair? = Hair(),
    @SerializedName("height")
    var height: Int? = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("image")
    var image: String? = "",
    @SerializedName("ip")
    var ip: String? = "",
    @SerializedName("lastName")
    var lastName: String? = "",
    @SerializedName("macAddress")
    var macAddress: String? = "",
    @SerializedName("maidenName")
    var maidenName: String? = "",
    @SerializedName("password")
    var password: String? = "",
    @SerializedName("phone")
    var phone: String? = "",
    @SerializedName("ssn")
    var ssn: String? = "",
    @SerializedName("university")
    var university: String? = "",
    @SerializedName("userAgent")
    var userAgent: String? = "",
    @SerializedName("username")
    var username: String = "",
    @SerializedName("weight")
    var weight: Double? = 0.0
) {
    data class Address(
        @SerializedName("address")
        var address: String? = "",
        @SerializedName("city")
        var city: String? = "",
        @SerializedName("coordinates")
        var coordinates: Coordinates? = Coordinates(),
        @SerializedName("postalCode")
        var postalCode: String? = "",
        @SerializedName("state")
        var state: String? = ""
    ) {
        data class Coordinates(
            @SerializedName("lat")
            var lat: Double? = 0.0,
            @SerializedName("lng")
            var lng: Double? = 0.0
        )
    }

    data class Bank(
        @SerializedName("cardExpire")
        var cardExpire: String? = "",
        @SerializedName("cardNumber")
        var cardNumber: String? = "",
        @SerializedName("cardType")
        var cardType: String? = "",
        @SerializedName("currency")
        var currency: String? = "",
        @SerializedName("iban")
        var iban: String? = ""
    )

    data class Company(
        @SerializedName("address")
        var address: Address? = Address(),
        @SerializedName("department")
        var department: String? = "",
        @SerializedName("name")
        var name: String? = "",
        @SerializedName("title")
        var title: String? = ""
    ) {
        data class Address(
            @SerializedName("address")
            var address: String? = "",
            @SerializedName("city")
            var city: String? = "",
            @SerializedName("coordinates")
            var coordinates: Coordinates? = Coordinates(),
            @SerializedName("postalCode")
            var postalCode: String? = "",
            @SerializedName("state")
            var state: String? = ""
        ) {
            data class Coordinates(
                @SerializedName("lat")
                var lat: Double? = 0.0,
                @SerializedName("lng")
                var lng: Double? = 0.0
            )
        }
    }

    data class Hair(
        @SerializedName("color")
        var color: String? = "",
        @SerializedName("type")
        var type: String? = ""
    )
}
