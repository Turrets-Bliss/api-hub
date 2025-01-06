Run the following command to package your Spring Boot application:

$ ./mvnw package

Build the Docker Images and Start the Services:

$ docker-compose up --build

Access the Application:

Your Spring Boot app will be accessible at http://localhost:8080.
PostgreSQL will be running on localhost:5432.