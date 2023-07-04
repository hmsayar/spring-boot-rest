# Spring Boot Movie Rating Application

This is a Spring Boot application that allows you to manage Users, Movies, and Movie Ratings. It uses a PostgreSQL database to store data.

## Getting Started

You need Docker installed to run this application. Clone the repository and run docker-compose up in the root directory.

### Prerequisites

* Docker
* Docker-compose

### Installation

Clone this repository:

```bash
https://github.com/hmsayar/spring-boot-rest.git
```
Go into the repository:

```bash
cd spring-boot-rest
```
Build the application:
```bash
mvn clean package
```
Run the application:
```bash
docker-compose up
```

## Usage

* **Create User**

```bash
curl -X POST \
  http://localhost:8080/api/users/ \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "John Doe",
    "email": "john@example.com"
  }'
```
* **Update User**

```bash
curl -X PUT \
  http://localhost:8080/api/users/2 \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Updated Name",
    "email": "updated@example.com"
  }'
```

* **Get User**

```bash
curl -X GET \
  http://localhost:8080/api/users/2
```

* **Delete User**

```bash
curl -X DELETE \
  http://localhost:8080/api/users/10
```

* **Create Movie**

```bash
curl -X POST http://localhost:8080/api/movies/ \
-H 'Content-Type: application/json' \
-d '{
    "name": "The Dark Knight",
    "description": "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
    "releaseDate": 2008
}'
```

* **Update Movie**

```bash
curl -X PUT http://localhost:8080/api/movies/3 \
-H 'Content-Type: application/json' \
-d '{
    "name": "The Dark Knight",
    "description": "Updated description",
    "releaseDate": 2008
}'
```

* **Get Movie(s)**

```bash
curl -X GET 'http://localhost:8080/api/movies/?pageNo=0&pageSize=10'
```
```bash
curl -X GET http://localhost:8080/api/movies/3
```

* **Delete Movie**

```bash
curl -X DELETE http://localhost:8080/api/movies/1
```

* **Rate Movie**

```bash
curl -X POST -H "Content-Type: application/json" -d '{"userId":1, "movieId":1, "rate":2}' http://localhost:8080/api/usermovies/
```

* **Update Rate**

```bash
curl -X PUT -H "Content-Type: application/json" -d '{"rate":1}' http://localhost:8080/api/usermovies/user/1/movie/1
```

* **Get Rate**

```bash
curl -X GET http://localhost:8080/api/usermovies/user/1/movie/1
```