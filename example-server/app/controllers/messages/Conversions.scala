package controllers.messages

import common.messages.{Media, Weather, User}

import scala.util.Random

trait Conversions {

  def toUser(apiUser: ApiUser): User = {
    User(
      firstName = apiUser.name.first,
      lastName = if(Random.nextBoolean()) Some(apiUser.name.last) else None,
      postalCode = apiUser.location.zip.toString,
      pictures = toMedia(apiUser.picture))
  }

  def toMedia(apiPicture: ApiPicture): Media = Media(apiPicture.large, apiPicture.medium, apiPicture.thumbnail)

  def iconURL(icon: String) = s"http://openweathermap.org/img/w/$icon.png"

  def toWeather(apiWeather: ApiWeather): Weather =
    Weather(
      apiWeather.id,
      apiWeather.main,
      apiWeather.description,
      iconURL(apiWeather.icon))

  def randomWeather = Random.shuffle(List(
    Weather(200, "Thunderstorm", "Thunderstorm with rain", iconURL("11d")),
    Weather(300, "Drizzle", "Light intensity drizzle", iconURL("09d")),
    Weather(500, "Rain", "Moderate rain", iconURL("10d")),
    Weather(600, "Snow", "Light snow", iconURL("13d")),
    Weather(701, "Mist", "Mist", iconURL("50d")),
    Weather(800, "Clear", "Clear sky", iconURL("01d")),
    Weather(804, "Clouds", "Overcast clouds", iconURL("02d"))
  )).head

}
