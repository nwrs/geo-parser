# Geo Parser

Simple Scala NLP library to parse free text locations into rich geo locations with lat/long co-ordinates and ISO-31662 codes.

* Useful for extracting geo locations from a user's social media profile page to map the results.
* Currently parses UK and US locations.
* A parsed location provides the town, area, region, country, geo co-ords and ISO-31662 codes (UK only).
* Match is graded for accuracy denoting what matched; Country, Region, Area or Town.
* More than a thousand UK cities, towns, urban areas and counties matched.
* US States and some major cities matched (more work required here!)

### Build requirements

* Scala 2.11
* Maven 3.x

### Build

```
$ git clone https://github.com/nwrs/geo-parser.git
$ cd geo-parser
$ mvn clean install
```

### Examples

``` scala
scala> GeoParser.parse("camden")
res0: Option[com.nwrs.parsing.GeoLocation] = Some(GeoLocation(Camden,Greater London,England,UK,51.5457,-0.1403,4,GB-CMD))

scala> GeoParser.parse("islington")
res1: Option[com.nwrs.parsing.GeoLocation] = Some(GeoLocation(Islington,Greater London,England,UK,51.5333,-0.1,4,GB-ISL))

scala> GeoParser.parse("cardiff")
res2: Option[com.nwrs.parsing.GeoLocation] = Some(GeoLocation(Cardiff,Glamorgan,Wales,UK,51.48155,-3.180849,4,GB-CRF))

scala> GeoParser.parse("unknown town, hertfordshire")
res3: Option[com.nwrs.parsing.GeoLocation] = Some(GeoLocation(,Hertfordshire,England,UK,51.75,-0.3333,3,GB-HRT))

scala> GeoParser.parse("random town, unknown county, scotland")
res4: Option[com.nwrs.parsing.GeoLocation] = Some(GeoLocation(,,Scotland,UK,55.95,-3.2,2,GB-SCT))

scala> GeoParser.parse("random place, uk")
res5: Option[com.nwrs.parsing.GeoLocation] = Some(GeoLocation(,,,UK,51.50023,-0.12427,1,GB-UKM))

scala> GeoParser.parse("albuquerque")
res6: Option[com.nwrs.parsing.GeoLocation] = Some(GeoLocation(Albuquerque,New Mexico,,US,35.0853336,-106.6055534,4,))

scala> GeoParser.parse("unknown town, MA")
res7: Option[com.nwrs.parsing.GeoLocation] = Some(GeoLocation(,Massachusetts,,US,42.230171,-71.530106,3,))
```

Used by [Tempest-Streamer](https://github.com/nwrs/tempest-streamer) to map tweets in real-time:

![Example Output](https://github.com/nwrs/tempest-streamer/blob/master/docs/images/screenshots/uk-mapping.jpg)
