package com.example.setayesh.weather.entity.geonames

import java.io.Serializable

data class GeonamesItem(
	val lng: String? = null,
	val geonameId: Int? = null,
	val toponymName: String? = null,
	val countryId: String? = null,
	val fcl: String? = null,
	val population: Int? = null,
	val countryCode: String? = null,
	val name: String? = null,
	val fclName: String? = null,
	val countryName: String? = null,
	val fcodeName: String? = null,
	val adminName1: String? = null,
	val lat: String? = null,
	val fcode: String? = null
)