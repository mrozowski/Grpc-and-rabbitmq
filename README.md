# Simple Request Processor Service
![Alt text](Images/flow.png?raw=true "component")

The main purpose of this project was to learn more about Grpc and RabbitMQ message broker.
This project consists of 3 services **Bridge**, **Request Processor** and **Reporter**. Services communicate with each other using Grpc and RabbitMQ. 

## Technologies
* Spring
* Grpc
* RabbitMQ
* Asciidocktor
* Docker

## Bridge
This service works as a gate for a client. It receives requests from clients, store them and send to another service for processing. It has 3 REST endpoints
* `sendRequest` - send a new request to the service
* `getStatus` - get status of the request
* `getResult` - get the request's result

And one gRPC endpoint
* `notifyRequestDone` - notify bridge that process finished

Bridge creates and stores client's requests. For simplicity, it stores requests in memory (inside list). After Bridge store request it sends it to `RequestProcessor` service using gRPC protocol.

## Request Processor (RP)
RP does not use REST endpoints. It uses gRPC to communicate with Bridge and RabbitMQ for communication with Reporter service. After it receives requests it starts processing.

gRPC endpoints:
* `processRequest` - send request for processing
* `getResult` - return result with given request id

#### Processing
The process of the request is very simple. It generates a new string based on request and adds information if the request was approved or denied - that decision is made randomly. Then it stores the result in the database (here again for simplicity I used List instead of real database).
Next, it sends a notification to Bridge about finished process. And sends process data to `Reporter` service using the queue.

## Reporter
Reporter receives reports messages only from RabbitMQ. And on the other side, it has REST endpoint for analytic for getting processing reports data.
* `getReport` - return report with information like the number of processed requests, process time, popular topics, etc

Reporter after receives a message from the queue it stores it in PostgreSQL database. Every message contains request topic, request data time, process date time, and decision.
