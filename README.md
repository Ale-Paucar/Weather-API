# Weather API ☀️

A REST API built with **Spring Boot** that consumes data from an external weather API, transforms it, and exposes custom endpoints. It includes validation, error handling, caching, and custom deserialization.

> ⚠️ **Important Note**: This project **requires an external API key** (not included in the repository) to function properly. However, you can still understand and adapt its structure easily.

---

## 🚀 Key Features

* Get current weather and hourly forecasts
* Custom exception and error handling
* Custom JSON deserialization
* Rate limiting with `Bucket4j`
* Caching using `Redis`

---

## 💠 Technologies Used

* Java 17
* Spring Boot 3.4.5
    * Spring Web
    * Spring Cache
    * Spring Data Redis
    * Bean Validation
* Bucket4j (Rate Limiter)
* Maven
* Docker (For Redis container)

## 📌 Requirements

* Java 17+
* Maven 3.8+
* Redis (required for caching)
* Visual Crossing API key

---

## 📁 Project Structure

```plaintext
src/
├── main/
│   ├── java/com/alexispaucar/weather_api/
│   │   ├── controllers/          # REST Controllers
│   │   ├── dto/                  # Data Transfer Objects
│   │   ├── exceptions/           # Custom exceptions
│   │   ├── models/               # Error models
│   │   ├── service/              # Business logic + external API
│   │   └── WeatherApiApplication.java
│   └── resources/
│       ├── application.properties
│       └── application-dev.properties
└── test/                         # Unit tests
```

---

## 🛆 Local Setup & Running

### 1. Clone the repository

```bash
git clone https://github.com/Ale-Paucar/Weather-API.git
cd Weather-API
```

### 2. Add your API key

Create and open the file::

```properties
# src/main/resources/application-dev.properties

weather.api.key=YOUR_API_KEY
```
You can obtain a free API key by registering at:

`
https://www.visualcrossing.com/weather-api
`
### 3.Run Redis container (for caching)
This project requires a Redis server for caching to work. You must have Docker installed. Run:

```bash
docker run -d --name weather-redis -p 6379:6379 redis
```
Without Redis running, the application will fail to start.
### 4. Run the project using Maven

```bash
./mvnw spring-boot:run
```

Or, if Maven is installed globally:

```bash
mvn spring-boot:run
```

---

## 📬 Available Endpoint (example)

* `GET /api/weather/current?city=Lima`
  → Returns the current weather and hourly forecast for the specified city.


## 📄 License

This project is free for educational or personal use. No private keys or sensitive files are included.
