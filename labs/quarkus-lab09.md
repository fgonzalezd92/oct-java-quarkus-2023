### Quarkus Lab09

#### lab09-movies-api

* Create **lab09-movies-api** application with rest-client, mongo, resteasy, lombok dependencies
* Create two endpoints

```
POST /movies/{movieName}
GET /movies/{movieName}
```

* **POST** operation connects to **http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=movieName**; gets the response and stores the **title, language, cast, year** in mongo db(db: **training**, collections: **movies**)
* User **RestClient** for the above
* **GET** operation connects to mongodb and returns the response


#### Kubernetize your application 

* Store the mongo db URL in config map
* Store the OMDBAPI key in secret



