# User Visit Tracker API

This Spring Boot application provides REST APIs to track and report user visits to a web service.

## Prerequisites

- JDK 17
- Docker and Docker Compose
- Maven

## Local Setup and Running

1. **Clone the repository:**

    ```
    git clone https://github.com/yourusername/uservisittracker.git
    cd user-session-tracker
    ```

2. **Start the database and logging services:**

   From the root directory of the project, run the following command to start the PostgreSQL database and Kibana using Docker Compose:

    ```
    cd src/main/resources
    docker-compose up
    ```

3. **Run the application:**

   You can then run the application using Maven:

    ```
    mvn spring-boot:run
    ```

   Alternatively, you can build the project with Maven and then run the resulting JAR file:

    ```
    mvn clean package
    java -jar target/user-session-tracker-0.0.1-SNAPSHOT.jar
    ```

## API Endpoints

The application provides the following endpoints:

- **POST /save:** Accepts a JSON body with 'date' and 'ip' fields to save a user visit. Example JSON:

    ```json
    {
      "date": "2023-05-22",
      "ip": "192.168.1.1"
    }
    ```

- **GET /statistics:** Returns a JSON array with the number of visits grouped by day. Example response:

    ```json
    [
      {
        "date": "2023-05-22",
        "count": 5
      },
      {
        "date": "2023-05-21",
        "count": 3
      }
    ]
    ```

## Swagger

The default URL for the swagger-ui will be 

http://localhost:8080/swagger-ui.html
.

## Logging

You can view application logs through Kibana, which is available at `http://localhost:5601`.

## Note

For the application to run successfully, make sure that the ports 8080 (for the Spring Boot application), 5432 (for PostgreSQL), 9200 (for Elasticsearch), and 5601 (for Kibana) are available.
