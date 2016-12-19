# egen-be-challenge

EGEN Weight tracker is weight tracking Application. Key features includes below functionalities

1. Store Weight and timestamp details in DB which are recorded from the Sensor/Emulator.
2. Fetch all the Metrics.
3. Fetch all the Metrics by Timestamp.
4. Create Alerts automatically in DB if weight is above or below 10% of the base weight given by the sensor.
5. Fetch all Alerts.
6. Fetch all Alerts by Timestamp.

## Sensor Notes - 

1. The Sensor should send the baseweight as part of the Create API like below.

````
java -jar -Dbase.value=150 -Dapi.url=http://localhost:9000/metrics/create/150 sensor-emulator-0.0.1-SNAPSHOT.jar
````
## DB Details -

````
1. Use Mongo DB
2. Create a Database -  weighttrackerdb
3. create 2 collections - alerts, metrics
````

NOTE : For more details about the API visit the below documentation

````
https://github.com/00bharat7/egen-be-challenge/tree/master/docs/WeightTracker.md
````
