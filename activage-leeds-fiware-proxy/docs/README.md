# ACTIVAGE Leeds FIWARE Proxy 

## Introduction  
The ACTIVAGE Leeds FIWARE proxy enables the exchange of context data between the ActivageLeeds platform and a FIWARE Context Broker. The proxy consists of the following modules:

- `Context Producer`: A component for enabling a proprietary platform API to publish context data to a FIWARE Context Broker using the NGSIv2 API specification.
- `Context Consumer`: A module for enabling a proprietary platform API to susbcribe to context data from a FIWARE Context Broker.  

It pulls data from services provided by the ActivageLeeds Platform and publishes to an IoT platform compatible with the ACTIVAGE AIoTES Framework. The IoT platform used is FIWARE.

## Architecture  

![image info](./docs/images/LEE-AIoTES-integration_fiware_proxy.png)  

## Installation Guide

### System Requirements  

#### Software Dependencies  
The following dependencies are required to run the software:   

- OpenJDK 8  
- Maven 3.1+ (for compiling and generating the executable)
- MongoDB 3.2+   

#### Interfacing System Entities  
The software interacts with the following components in the Activage Leeds Platform:

- ActivageLeeds Document Database  (MongoDB)
- ActivageLeeds Web Server  (SmartThings API)
- Orion Context Broker  (IoT Platform) 
