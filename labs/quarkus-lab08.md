* Start from scratch

* Build the following projects/modules in quarkus

#### weather-finder

* Create a kafka consumer application **weather-finder**
* It listens to a topic **weather-topic** for city names. Message can be an ordinary string.
* On receiving the message connect to *http://api.weatherstack.com/current?access_key=8bbd3a99a778dd009152d71802721384&units=f&query=<cityName>* and get the current temperature in JSON format
* Parse JSON and get the current temperature of the city alone. Your JSON response will be like this

``` json
{
  "request": {
    "type": "City",
    "query": "Chennai, India",
    "language": "en",
    "unit": "f"
  },
  "current": {
    "observation_time": "03:39 PM",
    "temperature": 75,
    "weather_code": 389,
    "weather_icons": [
      "https://cdn.worldweatheronline.com/images/wsymbols01_png_64/wsymbol_0040_thunderstorms_night.png"
    ],
    "weather_descriptions": [
      "Light Drizzle, Rain With Thunderstorm"
    ],
    "wind_speed": 9,
    "wind_degree": 350,
    "wind_dir": "N",
    "pressure": 1013,
    "precip": 0,
    "humidity": 89,
    "cloudcover": 75,
    "feelslike": 27,
    "uv_index": 1,
    "visibility": 2,
    "is_day": "no"
  }
}

```

* Store the response in the following table using JPA
* Create a table **temperatures(id, name, temperature, observation_date_time)** in training database


#### weather-api

* Create a REST api __weather-api__ running in __8080__
* It has two endpoints 
* POST __/weather/{city}__ which publishes a message to the **weather-topic**
* GET __/weather/{city}__ which returns all the temperatures for the given city 



#### Dockerize 

* Add Dockerfile(s) for **weather-finder** and **weather-api**
* Create **docker-compose.yaml** file and configure both the services weather-finder and weather-api
* For connecting to kafka from docker container, you can use **kafka.bootstrap.servers=host.docker.internal:9094**


# DO NOT GIVE UP



