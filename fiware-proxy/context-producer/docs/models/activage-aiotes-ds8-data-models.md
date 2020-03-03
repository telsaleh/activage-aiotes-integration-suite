# ACTIVAGE DS8 Data Models  

This document specifies the data models for the Activage DS8 IoT Platform for FIWARE (NGSIv2/JSON) and its corresponding representation in INTER-MW (INTER-IoT/JSON-LD).
  
- [ACTIVAGE DS8 Data Models](#activage-ds8-data-models)
  - [Entity Naming Convention](#entity-naming-convention)
  - [Device Messages](#device-messages)
    - [Door State Sensor](#door-state-sensor)
    - [Motion Detector](#motion-detector)
    - [Energy Meter](#energy-meter)
    - [Heartbeat Sensor](#heartbeat-sensor)
    - [Pedometer](#pedometer)
    - [Sleep Detector](#sleep-detector)
    - [Fall Detector](#fall-detector)
  - [ADL Service Messages](#adl-service-messages)
    - [TV Viewing](#tv_viewing)
    - [Bathroom Usage](#bathroom_usage)
  
## Entity Naming Convention

The entity IDs adopt the following naming structure:  

```txt
{system_entity}:{DS_Platform}:{DS_City}:{UUID}
```  

So for a device, an example would be:  

```txt
device:LEE:VAL:w34j5j46kjrtm5l
```  

And for a service, an example would be:  

```txt  
service:LEE:VAL:w34j5j46kjrtm5l
```  

UUID is generated using hash of user ID, device ID and the sensor type.

## Device Messages

### Door State Sensor  

<img src="https://energenie4u.co.uk/res/images/products/large/MIHO033%20WEBSITE.jpg" width="30%" height="30%">

- NGSIv2 (JSON)  

``` json  

{
    "id": "device:LEE:LD:test001",
    "type": "DoorStateSensor",
    "observation": {
        "type": "String",
        "value": "OPEN",
        "metadata": {
            "timestamp": {
                "value": "2017-06-17T07:21:24.238Z",
                "type": "DateTime"
            },
            "observationId": {
                "type": "String",
                "value": "ovservationID-find-a-way"
            },
            "quantityKind": {
                "type": "String",
                "value": "doorState"
            }
        }
    },
    "monitoredAsset": {
        "type": "String",
        "value": "BackDoor"
    }
}

```  

- INTER-IoT (JSON-LD)

```json  
{
    "@graph": [
        {
            "@graph": [
                {
                    "@id": "msg:meta/9d9f0467-209c-4c8c-b8bf-796f519e000e",
                    "msg:conversationID": "conv2dcf1807-6851-461c-a827-69703d7ee8a8",
                    "msg:dateTimeStamp": "2019-07-25T18:13:03.771+01:00",
                    "msg:messageID": "msg7042fdeb-ac95-4117-8ce7-8d2fa065d89e",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": [
                        {
                            "@id": "msg:Observation"
                        },
                        {
                            "@id": "msg:meta"
                        }
                    ]
                }
            ],
            "@id": "msg:metadata"
        },
        {
            "@graph": [
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_0",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": {
                        "@id": "InterIoT:syntax/FIWAREv2#_1"
                    },
                    "InterIoT:syntax/FIWAREv2#hasId": "device:LEE:LD:test001",
                    "InterIoT:syntax/FIWAREv2#hasType": "DoorStateSensor",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Entity"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_1",
                    "InterIoT:syntax/FIWAREv2#hasName": "observation",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_2"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_2",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "OPEN",
                    "InterIoT:syntax/FIWAREv2#hasMetadata": {
                        "@id": "InterIoT:syntax/FIWAREv2#_3"
                    },
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_3",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_4"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_6"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_8"
                        }
                    ],
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Metadata"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_4",
                    "InterIoT:syntax/FIWAREv2#hasName": "timestamp",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_5"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_5",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2017-06-17T07:21:24.238Z",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_6",
                    "InterIoT:syntax/FIWAREv2#hasName": "observationId",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_7"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_7",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "ovservationID-find-a-way",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_8",
                    "InterIoT:syntax/FIWAREv2#hasName": "quantityKind",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_9"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_9",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "doorState",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                }
            ],
            "@id": "msg:payload"
        }
    ],
    "@context": {
        "msg": "http://inter-iot.eu/message/",
        "iiotex": "http://inter-iot.eu/GOIoTPex#",
        "geosparql": "http://www.opengis.net/ont/geosparql#",
        "iiot": "http://inter-iot.eu/GOIoTP#",
        "InterIoT": "http://inter-iot.eu/",
        "ssn": "http://www.w3.org/ns/ssn/",
        "sosa": "http://www.w3.org/ns/sosa/"
    }
}  
```  

### Motion Detector  

<img src="https://energenie4u.co.uk/res/images/products/large/MIHO032%20WEBSITE.jpg" width="30%" height="30%">

- NGSIv2 (JSON)  

```json  
{
    "id": "device:LEE:LD:test001",
    "type": "MotionDetector",
    "observation": {
        "type": "Boolean",
        "value": "1",
        "metadata": {
            "timestamp": {
                "value": "2017-06-17T07:21:24.238Z",
                "type": "DateTime"
            },
            "observationId": {
                "type": "String",
                "value": "ovservationID-find-a-way"
            },
            "quantityKind": {
                "type": "String",
                "value": "motion"
            }
        }
    }
}  
```  

- INTER-IoT (JSON-LD)

```json  
{
    "@graph": [
        {
            "@graph": [
                {
                    "@id": "msg:meta/921087a9-b786-499b-9a0b-c62faf3b24d4",
                    "msg:conversationID": "conv35f72cf9-2ac2-4f97-aaa5-0e3b4cd474ef",
                    "msg:dateTimeStamp": "2019-08-07T15:49:23.409+01:00",
                    "msg:messageID": "msg40d646f4-353b-474b-9934-d83654e515b4",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": [
                        {
                            "@id": "msg:Observation"
                        },
                        {
                            "@id": "msg:meta"
                        }
                    ]
                }
            ],
            "@id": "msg:metadata"
        },
        {
            "@graph": [
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_0",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": {
                        "@id": "InterIoT:syntax/FIWAREv2#_1"
                    },
                    "InterIoT:syntax/FIWAREv2#hasId": "device:LEE:LD:test001",
                    "InterIoT:syntax/FIWAREv2#hasType": "MotionDetector",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Entity"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_1",
                    "InterIoT:syntax/FIWAREv2#hasName": "observation",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_2"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_2",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "1",
                    "InterIoT:syntax/FIWAREv2#hasMetadata": {
                        "@id": "InterIoT:syntax/FIWAREv2#_3"
                    },
                    "InterIoT:syntax/FIWAREv2#hasType": "Boolean"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_3",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_4"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_6"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_8"
                        }
                    ],
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Metadata"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_4",
                    "InterIoT:syntax/FIWAREv2#hasName": "timestamp",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_5"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_5",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2017-06-17T07:21:24.238Z",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_6",
                    "InterIoT:syntax/FIWAREv2#hasName": "observationId",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_7"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_7",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "ovservationID-find-a-way",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_8",
                    "InterIoT:syntax/FIWAREv2#hasName": "quantityKind",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_9"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_9",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "motion",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                }
            ],
            "@id": "msg:payload"
        }
    ],
    "@context": {
        "msg": "http://inter-iot.eu/message/",
        "iiotex": "http://inter-iot.eu/GOIoTPex#",
        "geosparql": "http://www.opengis.net/ont/geosparql#",
        "iiot": "http://inter-iot.eu/GOIoTP#",
        "InterIoT": "http://inter-iot.eu/",
        "ssn": "http://www.w3.org/ns/ssn/",
        "sosa": "http://www.w3.org/ns/sosa/"
    }
}  
```  

### Energy Meter  

<img src="https://energenie4u.co.uk/res/images/products/large/MIHO004%20WEBSITE.jpg" width="30%" height="30%"><img src="https://energenie4u.co.uk/res/images/products/large/MIHO006%20WEBSITE.jpg" width="50%" height="50%">

- NGSIv2 (JSON)  

```json  
{
    "id": "device:LEE:{Id}:test001",
    "type": "EnergyMeter",
    "observation": {
        "type": "Numebr",
        "value": "40000",
        "metadata": {
            "timestamp": {
                "value": "2017-06-17T07:21:24.238Z",
                "type": "DateTime"
            },
            "observationId": {
                "type": "String",
                "value": "ovservationID-find-a-way"
            },
            "quantityKind": {
                "type": "String",
                "value": "Power"
            },
            "measurementUnit": {
                "type": "String",
                "value": "WAT"
            }
        }
    },
    "monitoredAsset": {
        "type": "String",
        "value": "Kettle"
    }
}
```  

- INTER-IoT (JSON-LD)

```json  
{
    "@graph": [
        {
            "@graph": [
                {
                    "@id": "msg:meta/3560c941-d1e3-402e-a94f-f72f5bd3e8b2",
                    "msg:conversationID": "conva73b68c4-d1b6-4562-97cc-7bdf73263a3a",
                    "msg:dateTimeStamp": "2019-07-29T14:30:18.769+01:00",
                    "msg:messageID": "msg7f6938ef-d5b3-423d-9350-414edeafb735",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": [
                        {
                            "@id": "msg:Observation"
                        },
                        {
                            "@id": "msg:meta"
                        }
                    ]
                }
            ],
            "@id": "msg:metadata"
        },
        {
            "@graph": [
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_0",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_1"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_12"
                        }
                    ],
                    "InterIoT:syntax/FIWAREv2#hasId": "device:LEE:Id:test001",
                    "InterIoT:syntax/FIWAREv2#hasType": "EnergyMeter",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Entity"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_1",
                    "InterIoT:syntax/FIWAREv2#hasName": "observation",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_2"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_10",
                    "InterIoT:syntax/FIWAREv2#hasName": "measurementUnit",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_11"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_11",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "WAT",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_12",
                    "InterIoT:syntax/FIWAREv2#hasName": "monitoredAsset",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_13"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_13",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "Kettle",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_2",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "40000",
                    "InterIoT:syntax/FIWAREv2#hasMetadata": {
                        "@id": "InterIoT:syntax/FIWAREv2#_3"
                    },
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_3",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_4"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_6"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_8"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_10"
                        }
                    ],
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Metadata"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_4",
                    "InterIoT:syntax/FIWAREv2#hasName": "timestamp",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_5"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_5",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2017-06-17T07:21:24.238Z",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_6",
                    "InterIoT:syntax/FIWAREv2#hasName": "observationId",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_7"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_7",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "ovservationID-find-a-way",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_8",
                    "InterIoT:syntax/FIWAREv2#hasName": "quantityKind",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_9"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_9",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "Power",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                }
            ],
            "@id": "msg:payload"
        }
    ],
    "@context": {
        "msg": "http://inter-iot.eu/message/",
        "iiotex": "http://inter-iot.eu/GOIoTPex#",
        "geosparql": "http://www.opengis.net/ont/geosparql#",
        "iiot": "http://inter-iot.eu/GOIoTP#",
        "InterIoT": "http://inter-iot.eu/",
        "ssn": "http://www.w3.org/ns/ssn/",
        "sosa": "http://www.w3.org/ns/sosa/"
    }
}  
```  

### Heartbeat Sensor  

<img src="https://images.samsung.com/is/image/samsung/p5/uk/galaxy-watch-need-to-knows/wellbeing/Heart-Step-1b-Samsung-Health.png?$ORIGIN_PNG$" width="30%" height="30%">

- NGSIv2 (JSON)

```json  
{
    "id": "device:LEE:LD:test001",
    "type": "HeartBeatSensor",
    "observation": {
        "type": "Number",
        "value": "60",
        "metadata": {
            "timestamp": {
                "value": "2017-06-17T07:21:24.238Z",
                "type": "DateTime"
            },
            "observationId": {
                "type": "String",
                "value": "ovservationID-find-a-way"
            },
            "quantityKind": {
                "type": "String",
                "value": "heartRate"
            },
            "measurementUnit": {
                "type": "String",
                "value": "bpm"
            }
        }
    }
}
```  

- INTER-IoT (JSON-LD)

```json  
{
    "@graph": [
        {
            "@graph": [
                {
                    "@id": "msg:meta/4f7268d2-8aee-43ac-9a7b-8a7a07f94828",
                    "msg:conversationID": "conv9e68c309-9d5a-4237-bd36-4d2335a06763",
                    "msg:dateTimeStamp": "2019-08-07T15:57:29.901+01:00",
                    "msg:messageID": "msgd656869e-7b6b-41c7-8deb-8f665e05623e",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": [
                        {
                            "@id": "msg:Observation"
                        },
                        {
                            "@id": "msg:meta"
                        }
                    ]
                }
            ],
            "@id": "msg:metadata"
        },
        {
            "@graph": [
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_0",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": {
                        "@id": "InterIoT:syntax/FIWAREv2#_1"
                    },
                    "InterIoT:syntax/FIWAREv2#hasId": "device:LEE:LD:test001",
                    "InterIoT:syntax/FIWAREv2#hasType": "HeartBeatSensor",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Entity"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_1",
                    "InterIoT:syntax/FIWAREv2#hasName": "observation",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_2"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_10",
                    "InterIoT:syntax/FIWAREv2#hasName": "measurementUnit",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_11"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_11",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "bpm",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_2",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "60",
                    "InterIoT:syntax/FIWAREv2#hasMetadata": {
                        "@id": "InterIoT:syntax/FIWAREv2#_3"
                    },
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_3",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_4"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_6"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_8"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_10"
                        }
                    ],
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Metadata"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_4",
                    "InterIoT:syntax/FIWAREv2#hasName": "timestamp",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_5"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_5",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2017-06-17T07:21:24.238Z",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_6",
                    "InterIoT:syntax/FIWAREv2#hasName": "observationId",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_7"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_7",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "ovservationID-find-a-way",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_8",
                    "InterIoT:syntax/FIWAREv2#hasName": "quantityKind",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_9"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_9",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "heartRate",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                }
            ],
            "@id": "msg:payload"
        }
    ],
    "@context": {
        "msg": "http://inter-iot.eu/message/",
        "iiotex": "http://inter-iot.eu/GOIoTPex#",
        "geosparql": "http://www.opengis.net/ont/geosparql#",
        "iiot": "http://inter-iot.eu/GOIoTP#",
        "InterIoT": "http://inter-iot.eu/",
        "ssn": "http://www.w3.org/ns/ssn/",
        "sosa": "http://www.w3.org/ns/sosa/"
    }
}
```

### Pedometer  

<img src="https://images.samsung.com/is/image/samsung/p5/uk/galaxy-watch-need-to-knows/wellbeing/Heart-Step-1b-Samsung-Health.png?$ORIGIN_PNG$" width="30%" height="30%">

- NGSIv2 (JSON)  

```json  
{
    "id": "device:LEE:LD:test001",
    "type": "Pedometer",
    "observation": {
        "type": "Number",
        "value": "100",
        "metadata": {
            "timestamp": {
                "value": "2017-06-17T07:21:24.238Z",
                "type": "DateTime"
            },
            "observationId": {
                "type": "String",
                "value": "ovservationID-find-a-way"
            },
            "quantityKind": {
                "type": "String",
                "value": "stepCount"
            },
            "measurementUnit": {
                "type": "String",
                "value": "StepPerDay"
            }
        }
    }
}
```  

- INTER-IoT (JSON-LD)

```json  
{
    "@graph": [
        {
            "@graph": [
                {
                    "@id": "msg:meta/1b6cc73c-6009-4f86-bdee-9ba4a08510a6",
                    "msg:conversationID": "conv73ab2d70-f709-431e-9ef4-086eb8bea92f",
                    "msg:dateTimeStamp": "2019-08-07T15:38:13.419+01:00",
                    "msg:messageID": "msg5091a99b-dc7e-4044-b6d5-9945f221be0a",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": [
                        {
                            "@id": "msg:Observation"
                        },
                        {
                            "@id": "msg:meta"
                        }
                    ]
                }
            ],
            "@id": "msg:metadata"
        },
        {
            "@graph": [
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_0",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": {
                        "@id": "InterIoT:syntax/FIWAREv2#_1"
                    },
                    "InterIoT:syntax/FIWAREv2#hasId": "device:LEE:LD:test001",
                    "InterIoT:syntax/FIWAREv2#hasType": "Pedometer",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Entity"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_1",
                    "InterIoT:syntax/FIWAREv2#hasName": "observation",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_2"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_10",
                    "InterIoT:syntax/FIWAREv2#hasName": "measurementUnit",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_11"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_11",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "StepPerDay",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_2",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "100",
                    "InterIoT:syntax/FIWAREv2#hasMetadata": {
                        "@id": "InterIoT:syntax/FIWAREv2#_3"
                    },
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_3",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_4"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_6"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_8"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_10"
                        }
                    ],
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Metadata"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_4",
                    "InterIoT:syntax/FIWAREv2#hasName": "timestamp",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_5"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_5",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2017-06-17T07:21:24.238Z",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_6",
                    "InterIoT:syntax/FIWAREv2#hasName": "observationId",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_7"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_7",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "ovservationID-find-a-way",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_8",
                    "InterIoT:syntax/FIWAREv2#hasName": "quantityKind",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_9"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_9",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "stepCount",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                }
            ],
            "@id": "msg:payload"
        }
    ],
    "@context": {
        "msg": "http://inter-iot.eu/message/",
        "iiotex": "http://inter-iot.eu/GOIoTPex#",
        "geosparql": "http://www.opengis.net/ont/geosparql#",
        "iiot": "http://inter-iot.eu/GOIoTP#",
        "InterIoT": "http://inter-iot.eu/",
        "ssn": "http://www.w3.org/ns/ssn/",
        "sosa": "http://www.w3.org/ns/sosa/"
    }
}
```  

### Sleep Detector  

<img src="https://images.samsung.com/is/image/samsung/p5/uk/galaxy-watch-need-to-knows/wellbeing/Heart-Step-1b-Samsung-Health.png?$ORIGIN_PNG$" width="30%" height="30%">  

- NGSIv2 (JSON)  

```json  
{
    "id": "device:LEE:LD:test001",
    "type": "SleepDetector",
    "observation": {
        "type": "Number",
        "value": "7",
        "metadata": {
            "timestamp": {
                "value": "2017-06-17T07:23:59.238Z",
                "type": "DateTime"
            },
            "observationId": {
                "type": "String",
                "value": "observationID-find-a-way"
            },
            "quantityKind": {
                "type": "String",
                "value": "SleepRate"
            },
            "measurementUnit": {
                "type": "String",
                "value": "Hours"
            },
            "sleepStart": {
                "type": "DateTime",
                "value": "2017-06-17T07:14:24.238Z"
            },
            "sleepEnd": {
                "type": "DateTime",
                "value": "2017-06-17T07:21:24.238Z"
            }
        }
    }
}
```  

- INTER-IoT (JSON)  

```json  
{
    "@graph": [
        {
            "@graph": [
                {
                    "@id": "msg:meta/fe32c0c8-ed58-45d6-801c-c43c5175ddd4",
                    "msg:conversationID": "conv40ee5ea7-0c77-47ef-9739-6a897ab0a556",
                    "msg:dateTimeStamp": "2019-08-12T13:29:20.835Z",
                    "msg:messageID": "msgf98e08dc-076c-4f2c-95fd-7822b53864ec",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": [
                        {
                            "@id": "msg:Observation"
                        },
                        {
                            "@id": "msg:meta"
                        }
                    ]
                }
            ],
            "@id": "msg:metadata"
        },
        {
            "@graph": [
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_0",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": {
                        "@id": "InterIoT:syntax/FIWAREv2#_1"
                    },
                    "InterIoT:syntax/FIWAREv2#hasId": "device:LEE:LD:test001",
                    "InterIoT:syntax/FIWAREv2#hasType": "SleepDetector",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Entity"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_1",
                    "InterIoT:syntax/FIWAREv2#hasName": "observation",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_2"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_10",
                    "InterIoT:syntax/FIWAREv2#hasName": "measurementUnit",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_11"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_11",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "Hours",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_12",
                    "InterIoT:syntax/FIWAREv2#hasName": "sleepStart",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_13"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_13",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2017-06-17T07:14:24.238Z",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_14",
                    "InterIoT:syntax/FIWAREv2#hasName": "sleepEnd",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_15"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_15",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2017-06-17T07:21:24.238Z",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_2",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "7",
                    "InterIoT:syntax/FIWAREv2#hasMetadata": {
                        "@id": "InterIoT:syntax/FIWAREv2#_3"
                    },
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_3",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_4"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_6"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_8"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_10"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_12"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_14"
                        }
                    ],
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Metadata"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_4",
                    "InterIoT:syntax/FIWAREv2#hasName": "timestamp",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_5"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_5",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2017-06-17T07:23:59.238Z",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_6",
                    "InterIoT:syntax/FIWAREv2#hasName": "observationId",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_7"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_7",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "ovservationID-find-a-way",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_8",
                    "InterIoT:syntax/FIWAREv2#hasName": "quantityKind",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_9"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_9",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "SleepRate",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                }
            ],
            "@id": "msg:payload"
        }
    ],
    "@context": {
        "msg": "http://inter-iot.eu/message/",
        "iiotex": "http://inter-iot.eu/GOIoTPex#",
        "geosparql": "http://www.opengis.net/ont/geosparql#",
        "iiot": "http://inter-iot.eu/GOIoTP#",
        "InterIoT": "http://inter-iot.eu/",
        "ssn": "http://www.w3.org/ns/ssn/",
        "sosa": "http://www.w3.org/ns/sosa/"
    }
}
```  

### Fall Detector  

<img src="https://images.samsung.com/is/image/samsung/p5/uk/galaxy-watch-need-to-knows/wellbeing/Heart-Step-1b-Samsung-Health.png?$ORIGIN_PNG$" width="30%" height="30%">  
  
Key|Possible value  
---|--------------  
hasConfirmation|Yes, No, Timeout  
hasPriority|Normal, Emergency, Attention  
quantityKind|Fall, General_Alert, Notification  

- NGSIv2 (JSON)  

```json  
{
    "id": "device_uuid",
    "type": "FallDetector",
    "observation": {
        "type": "StructuredData",
        "value": {
            "hasConfirmation": {
                "type": "String",
                "value": "Yes"
            },
            "hasPriority":  {
                "type": "String",
                "value": "Emergency"
            }
        },
        "metadata": {
            "timestamp": {
                "value": "2017-06-17T07:21:24.238Z",
                "type": "DateTime"
            },
            "observationId": {
                "type": "String",
                "value": "ovservationID-find-a-way"
            },
            "quantityKind": {
                "type": "String",
                "value": "Fall"
            }
        }
    }
}
```  

- INTER-IoT (JSON-LD)  

```json  
{
    "@graph": [
        {
            "@graph": [
                {
                    "@id": "msg:meta/b51005f5-a8e6-4747-9330-9963194c2a12",
                    "msg:conversationID": "convf84bdab9-cc32-4f0f-a53c-67b4edac6bc1",
                    "msg:dateTimeStamp": "2019-07-30T15:41:13.439+01:00",
                    "msg:messageID": "msg6f310810-05f5-4d55-a971-147834abe17f",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": [
                        {
                            "@id": "msg:Observation"
                        },
                        {
                            "@id": "msg:meta"
                        }
                    ]
                }
            ],
            "@id": "msg:metadata"
        },
        {
            "@graph": [
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_0",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": {
                        "@id": "InterIoT:syntax/FIWAREv2#_1"
                    },
                    "InterIoT:syntax/FIWAREv2#hasId": "device_uuid",
                    "InterIoT:syntax/FIWAREv2#hasType": "FallDetector",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Entity"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_1",
                    "InterIoT:syntax/FIWAREv2#hasName": "observation",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_2"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_10",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2017-06-17T07:21:24.238Z",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_11",
                    "InterIoT:syntax/FIWAREv2#hasName": "observationId",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_12"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_12",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "ovservationID-find-a-way",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_13",
                    "InterIoT:syntax/FIWAREv2#hasName": "quantityKind",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_14"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_14",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "Fall",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_2",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_3"
                    },
                    "InterIoT:syntax/FIWAREv2#hasMetadata": {
                        "@id": "InterIoT:syntax/FIWAREv2#_8"
                    },
                    "InterIoT:syntax/FIWAREv2#hasType": "StructuredData"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_3",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_4"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_6"
                        }
                    ]
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_4",
                    "InterIoT:syntax/FIWAREv2#hasName": "Confirmed",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_5"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_5",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "YEs",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_6",
                    "InterIoT:syntax/FIWAREv2#hasName": "priority",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_7"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_7",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "Emergency",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_8",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_9"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_11"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_13"
                        }
                    ],
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Metadata"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_9",
                    "InterIoT:syntax/FIWAREv2#hasName": "timestamp",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_10"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                }
            ],
            "@id": "msg:payload"
        }
    ],
    "@context": {
        "msg": "http://inter-iot.eu/message/",
        "iiotex": "http://inter-iot.eu/GOIoTPex#",
        "geosparql": "http://www.opengis.net/ont/geosparql#",
        "iiot": "http://inter-iot.eu/GOIoTP#",
        "InterIoT": "http://inter-iot.eu/",
        "ssn": "http://www.w3.org/ns/ssn/",
        "sosa": "http://www.w3.org/ns/sosa/"
    }
}  
```  

## ADL Service Messages  

### TV_Viewing  

<img src="https://img.global.news.samsung.com/global/wp-content/uploads/2018/06/Live-Sports_QLED-TV_1.gif" width="30%" height="30%">  

- NSGIv2 (JSON)  

```json  
{
    "id": "service:LEE:LD:test001",
    "type": "TV_Viewing",
    "dailyResult": {
        "type": "Number",
        "value": 10,
        "metadata": {
            "userid": {
                "value": "uuid",
                "type": "String"
            },
            "timestamp": {
                "value": "2019-06-01T00:00:00+00:00",
                "type": "DateTime"
            },
            "measurementUnit": {
                "value": "Hours",
                "type": "String"
            },
            "green_lower": {
                "value": "7",
                "type": "Number"
            },
            "green_upper": {
                "value": "18",
                "type": "Number"
            },
            "yellow_lower": {
                "value": "3",
                "type": "Number"
            },
            "yellow_upper": {
                "value": "20",
                "type": "Number"
            }
        }
    }
}  

```  

- INTER-IoT (JSON-LD)  

```json  
{
    "@graph": [
        {
            "@graph": [
                {
                    "@id": "msg:meta/7b82b612-1e61-4eef-bc56-6c501d2eed3b",
                    "msg:conversationID": "conv6b9f7ffb-3c07-4e23-99cf-548f91a4c40d",
                    "msg:dateTimeStamp": "2019-07-23T14:01:37.195+01:00",
                    "msg:messageID": "msg53d1b7e6-0919-46e4-8754-af445f23c690",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": [
                        {
                            "@id": "msg:Observation"
                        },
                        {
                            "@id": "msg:meta"
                        }
                    ]
                }
            ],
            "@id": "msg:metadata"
        },
        {
            "@graph": [
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_0",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": {
                        "@id": "InterIoT:syntax/FIWAREv2#_1"
                    },
                    "InterIoT:syntax/FIWAREv2#hasId": "service:LEE:LD:test001",
                    "InterIoT:syntax/FIWAREv2#hasType": "TV_Viewing",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Entity"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_1",
                    "InterIoT:syntax/FIWAREv2#hasName": "dailyResult",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_2"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_10",
                    "InterIoT:syntax/FIWAREv2#hasName": "green_lower",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_11"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_11",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "7",
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_12",
                    "InterIoT:syntax/FIWAREv2#hasName": "green_upper",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_13"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_13",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "18",
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_14",
                    "InterIoT:syntax/FIWAREv2#hasName": "yellow_lower",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_15"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_15",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "3",
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_16",
                    "InterIoT:syntax/FIWAREv2#hasName": "yellow_upper",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_17"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_17",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "20",
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_2",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": {
                        "@type": "http://www.w3.org/2001/XMLSchema#int",
                        "@value": "10"
                    },
                    "InterIoT:syntax/FIWAREv2#hasMetadata": {
                        "@id": "InterIoT:syntax/FIWAREv2#_3"
                    },
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_3",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_4"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_6"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_8"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_10"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_12"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_14"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_16"
                        }
                    ],
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Metadata"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_4",
                    "InterIoT:syntax/FIWAREv2#hasName": "userid",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_5"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_5",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "uuid",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_6",
                    "InterIoT:syntax/FIWAREv2#hasName": "timestamp",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_7"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_7",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2019-06-01T00:00:00+00:00",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_8",
                    "InterIoT:syntax/FIWAREv2#hasName": "measurementUnit",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_9"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_9",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "Hours",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                }
            ],
            "@id": "msg:payload"
        }
    ],
    "@context": {
        "msg": "http://inter-iot.eu/message/",
        "iiotex": "http://inter-iot.eu/GOIoTPex#",
        "geosparql": "http://www.opengis.net/ont/geosparql#",
        "iiot": "http://inter-iot.eu/GOIoTP#",
        "InterIoT": "http://inter-iot.eu/",
        "ssn": "http://www.w3.org/ns/ssn/",
        "sosa": "http://www.w3.org/ns/sosa/"
    }
}
```  

### Bathroom_Usage  

<img src="https://cdn.pixabay.com/photo/2017/02/24/12/23/bathroom-2094716_960_720.jpg" width="30%" height="30%">  

- NGSIv2 (JSON)  

```json  
{
    "id": "service:LEE:LD:test002",
    "type": "Bathroom_Usage",
    "dailyResult": {
        "type": "Number",
        "value": 10,
        "metadata": {
            "userid": {
                "value": "uuid",
                "type": "String"
            },
            "timestamp": {
                "value": "2019-06-01T00:00:00+00:00",
                "type": "DateTime"
            },
            "measurementUnit": {
                "value": "Hours",
                "type": "String"
            },
            "green_lower": {
                "value": "7",
                "type": "Number"
            },
            "green_upper": {
                "value": "18",
                "type": "Number"
            },
            "yellow_lower": {
                "value": "3",
                "type": "Number"
            },
            "yellow_upper": {
                "value": "20",
                "type": "Number"
            }
        }
    }
}  
```  

- INTER-IoT (JSON-LD)  

```json  
{
    "@graph": [
        {
            "@graph": [
                {
                    "@id": "msg:meta/8a1b8f17-e681-4703-88ff-5da855c57759",
                    "msg:conversationID": "conva2eef187-bcbf-4cc5-8932-e377d863888c",
                    "msg:dateTimeStamp": "2019-07-19T20:49:04.151+01:00",
                    "msg:messageID": "msg3d70aa85-67df-44a6-b97c-2566134da50e",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": [
                        {
                            "@id": "msg:Observation"
                        },
                        {
                            "@id": "msg:meta"
                        }
                    ]
                }
            ],
            "@id": "msg:metadata"
        },
        {
            "@graph": [
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_0",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": {
                        "@id": "InterIoT:syntax/FIWAREv2#_1"
                    },
                    "InterIoT:syntax/FIWAREv2#hasId": "service:LEE:LD:test002",
                    "InterIoT:syntax/FIWAREv2#hasType": "Bathroom_Usage",
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Entity"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_1",
                    "InterIoT:syntax/FIWAREv2#hasName": "dailyResult",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_2"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_10",
                    "InterIoT:syntax/FIWAREv2#hasName": "green_lower",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_11"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_11",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "7",
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_12",
                    "InterIoT:syntax/FIWAREv2#hasName": "green_upper",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_13"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_13",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "18",
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_14",
                    "InterIoT:syntax/FIWAREv2#hasName": "yellow_lower",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_15"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_15",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "3",
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_16",
                    "InterIoT:syntax/FIWAREv2#hasName": "yellow_upper",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_17"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_17",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "20",
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_2",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": {
                        "@type": "http://www.w3.org/2001/XMLSchema#int",
                        "@value": "10"
                    },
                    "InterIoT:syntax/FIWAREv2#hasMetadata": {
                        "@id": "InterIoT:syntax/FIWAREv2#_3"
                    },
                    "InterIoT:syntax/FIWAREv2#hasType": "Number"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_3",
                    "InterIoT:syntax/FIWAREv2#hasAttribute": [
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_4"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_6"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_8"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_10"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_12"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_14"
                        },
                        {
                            "@id": "InterIoT:syntax/FIWAREv2#_16"
                        }
                    ],
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Metadata"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_4",
                    "InterIoT:syntax/FIWAREv2#hasName": "userid",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_5"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_5",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "uuid",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_6",
                    "InterIoT:syntax/FIWAREv2#hasName": "timestamp",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_7"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_7",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "2019-06-01T00:00:00+00:00",
                    "InterIoT:syntax/FIWAREv2#hasType": "DateTime"
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_8",
                    "InterIoT:syntax/FIWAREv2#hasName": "measurementUnit",
                    "InterIoT:syntax/FIWAREv2#hasValue": {
                        "@id": "InterIoT:syntax/FIWAREv2#_9"
                    },
                    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": {
                        "@id": "InterIoT:syntax/FIWAREv2#Attribute"
                    }
                },
                {
                    "@id": "InterIoT:syntax/FIWAREv2#_9",
                    "InterIoT:syntax/FIWAREv2#hasAttrValue": "Hours",
                    "InterIoT:syntax/FIWAREv2#hasType": "String"
                }
            ],
            "@id": "msg:payload"
        }
    ],
    "@context": {
        "msg": "http://inter-iot.eu/message/",
        "iiotex": "http://inter-iot.eu/GOIoTPex#",
        "geosparql": "http://www.opengis.net/ont/geosparql#",
        "iiot": "http://inter-iot.eu/GOIoTP#",
        "InterIoT": "http://inter-iot.eu/",
        "ssn": "http://www.w3.org/ns/ssn/",
        "sosa": "http://www.w3.org/ns/sosa/"
    }
}
```  

