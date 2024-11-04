# E-commerce-microservices-app

## About the project
This project is a microservices architecture for an e-commerce application. It was made in the context of a school project
to implement an event driven mmicroservices architecture.
It is composed of 8 services:
- **Product Service**: manages the products of the e-commerce application
- **Order Service**: manages the orders of the e-commerce application
- **Stock Service**: manages the stock of the products
- **Gateway Service**: is the entry point of the application, it routes the requests to the right service
- **Eureka Service**: is the service registry, it allows the services to register and discover each other
- **Kafka Service**: is the message broker, it allows the services to communicate asynchronously
- **Zookeeper Service**: is the coordination service for Kafka
- **Frontend**: is the frontend of the application

Here is the architecture of the application:
![Architecture](./images/architecture.png)

### Interoperability and scalability
The services communicate with each other using REST APIs and Kafka. The services are independent and can be deployed 
separately. This allows to scale the services independently and to replace them without affecting the other services.

## Getting started

### Installation

1. Clone the repository
```bash
git clone https://github.com/LiamBou/ecommerce-microservices.git
```

2. Go to the project directory
```bash
cd ecommerce-microservices
```

#### Running the application

To run the application, you need to have Docker and Docker Compose installed on your machine.

To start the application, run the following command:
```bash
docker-compose up
```
You can access the frontend of the application at `http://localhost:3000`