# client-request-service

A plain REST service for managing client applications to bank products.

# build

`mvn clean package`

the full jar will be placed in the `target` folder, 
named `client-request-service-0.0.1-SNAPSHOT.jar`

# API description

`/api/application/latest/{contactId}` - get the latest application of the client with specified `contactId`.

`/api/application/all` - returns all applications available.

