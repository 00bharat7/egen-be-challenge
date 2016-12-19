# Weight Tracker API

Weight tracker API allows the Sensor to Create, Read and ReadByTimestamp

## Usage

### Rest API Calls

The module provides the following REST API methods:

````
POST     /metrics/create/:baseWeight
GET      /metrics/read  
GET      /metrics/readByTimeRange 
GET      /alerts/read
GET      /alerts/readByTimeRange

````

#### Sample Requests

**Request Parameters**:

1. **timeStamp** - timestamp for the weight recorded
2. **value** - Weight of the person (Supported between 0 and 500 pounds)

````
[POST] http://{hostname}:{port}/metrics/create/150

Request Body:

{
  "timeStamp": "1458062848654", 
  "value": "160"
}


````

````
[GET] http://{hostname}:{port}/metrics/read

````

````
[GET] http://{hostname}:{port}/metrics/readByTimeRange?from="1458062848654"&to="1458062848694"

````

````
[GET] http://{hostname}:{port}/alerts/read

````

````
[GET] http://{hostname}:{port}/alerts/readByTimeRange?from="1458062848654"&to="1458062848694"

````
