package com.example.setayesh.weather.entity.geonames

import java.io.Serializable

data class GeoNames(
	val totalResultsCount: Int? = null,
	val geonames: List<GeonamesItem?>? = null
)