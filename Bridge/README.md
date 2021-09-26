# Bridge
Bridge works as a gate for a client. Here you can send request and start the process

## How to use it
Run all services and send a new request on endpoint `localhost:8081/request/v1` - POST method. 

Structure of the request json
```
{
  "name": "some title",
  "request": "body of the request"
}
```
After around 10 seconds processing should be finished and you should be able to ask for result. 
Use `localhost:8081/result/v1/{requestId}` endpoint with GET method to retrieve result.
Optionaly you can check the status of the request on endpoint `localhost:8081/request/v1/status/{requestId}`
* `Pending` - waiting for processing
* `Processing` - request is processing
* `Done` - processing is finished and result is ready to be retrieved




Diagram showing main flow  
![image](https://user-images.githubusercontent.com/67066372/125170579-e5735780-e1af-11eb-976f-46bb30b4d38c.png)
