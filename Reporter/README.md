# Reporter
Here is stored information about processed requests. Every request produces process information that looks as below and it is stored in a database. Later they can be retrieved by REST endpoint
* `name` - name of the request
* `decision` - approved or denied `
* `request date` - time when request was created
* `result date` - time when result was created

## How to use it
Before running the service, we have to first in console run command `docker-compose up` to run PostgreSQL database and RabbitMQ service. After the database and rabbit is up we can run Reporter service. 

To create the first report we have to send a request to the **Bridge** service. After around 10 seconds it should be processed and data should arrive to **Reporter** service.

## Get report
[GET]`localhost:8080/report/v1` - calling this endpoint will return information about every report in the database

## Flow
![image](https://user-images.githubusercontent.com/67066372/125171339-09d13300-e1b4-11eb-8586-b95c4c255f76.png)
