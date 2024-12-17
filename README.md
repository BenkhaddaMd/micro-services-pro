# Microservices Architecture: Student and School Services

This project demonstrates a microservices architecture consisting of the following components:

1. **Student Service**: Manages student-related data and operations.
2. **School Service**: Handles school-related data and operations.
3. **Eureka Server**: Service discovery server for registering and discovering microservices.
4. **Gateway Server**: API Gateway for routing requests to appropriate microservices.

---

## Project Structure

```
/microservices-project
├── student-service
│   ├── src
│   ├── pom.xml
│   └── ...
├── school-service
│   ├── src
│   ├── pom.xml
│   └── ...
├── eureka-server
│   ├── src
│   ├── pom.xml
│   └── ...
├── gateway-server
│   ├── src
│   ├── pom.xml
│   └── ...
└── README.md
```

---

## Components

### 1. Student Service
- **Description**: A RESTful service to manage students.
- **Endpoints**:
  - `GET /api/students`: Retrieve all students.
  - `POST /api/students`: Add a new student.
  - `GET /api/students/{id}`: Retrieve a student by ID.
- **Port**: `8081`

### 2. School Service
- **Description**: A RESTful service to manage schools.
- **Endpoints**:
  - `GET /api/schools`: Retrieve all schools.
  - `POST /api/schools`: Add a new school.
  - `GET /api/schools/{id}`: Retrieve a school by ID.
- **Port**: `8082`

### 3. Eureka Server
- **Description**: A service registry for registering and discovering microservices.
- **Port**: `8761`
- **Key Features**:
  - Monitors the status of registered services.
  - Enables load balancing and dynamic scaling.

### 4. Gateway Server
- **Description**: Serves as the entry point to route requests to the appropriate microservices.
- **Port**: `8080`
- **Key Features**:
  - Centralized API management.
  - Load balancing and request routing.
  - Security and throttling (if configured).

---

## How to Run

### Prerequisites
Ensure the following are installed:
- **Java JDK** (11 or higher)
- **Maven** (for building the project)
- **Spring Boot** (used by the microservices)

### Steps

1. **Run the Eureka Server**:
   - Navigate to the `eureka-server` directory.
   - Run the application using:
     ```bash
     mvn spring-boot:run
     ```

2. **Run the Microservices**:
   - Navigate to the `student-service` directory and run:
     ```bash
     mvn spring-boot:run
     ```
   - Navigate to the `school-service` directory and run:
     ```bash
     mvn spring-boot:run
     ```

3. **Run the Gateway Server**:
   - Navigate to the `gateway-server` directory.
   - Run the application using:
     ```bash
     mvn spring-boot:run
     ```

4. Access the services via:
   - **Gateway**: `http://localhost:8080`
   - **Eureka Dashboard**: `http://localhost:8761`

---

## Configuration

### Application Properties
Each service has its own `application.properties` file to configure ports and other settings.

#### Example: `student-service/src/main/resources/application.properties`
```properties
server.port=8082
spring.application.name=student-service
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

#### Example: `gateway-server/src/main/resources/application.properties`
```properties
server.port=8080
spring.application.name=gateway-server
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

---

## Features

- **Service Discovery**: All microservices register themselves with the Eureka server.
- **Dynamic Routing**: Requests are routed through the Gateway Server based on service discovery.
- **Modularity**: Each microservice handles its own data and logic.

---

## Troubleshooting

- Ensure all services are registered with Eureka. Check the Eureka dashboard at `http://localhost:8761`.
- Verify port availability before starting services.
- Check logs for any error messages and resolve dependencies accordingly.

---

## Acknowledgments
- Built using Spring Boot and Spring Cloud.

