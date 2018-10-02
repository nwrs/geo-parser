package com.nwrs.parsing

case class GeoLocation(
                        town: String,
                        area: String,
                        region: String,
                        country: String,
                        latitude: Double,
                        longitude: Double,
                        accuracy: Int, // 0=None, 1=Country, 2=Region, 3=Area, 4=Town, 5=GPS
                        iso31662: String) {
  val location = Seq(town, area, region, country).filter( s => s!=null && !s.isEmpty).mkString(", ")
  val locationGeo = s"${latitude.toString},${longitude.toString}"
}
