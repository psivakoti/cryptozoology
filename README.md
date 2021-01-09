# Customer REST API

Build an API to track the animals electronically for The Menagerie of Cryptozoological Creatures.

## Instructions

As zookeeper, I want to add animals to my zoo.
Rule: Animal should have a name and a type (flying, swimming, walking)

When I add an animalDto
Then it is in my zoo


## API Specifications

**Resource Summary**

| URI                                      | HTTP Method |   HTTP Status   | Description                              |
|------------------------------------------|-------------|-----------------|------------------------------------------| 
| cryptozoological.com/api/animals         | POST        |   201 CREATED   | Form submission to add a new animal.     |


---
**POST /api/animals**

Request Body:
```json
{
    "name": "Elephant",
    "type": "Walking"
}
```
Response Body:
```json
{
    "id": "1",
    "name": "Elephant",
    "type": "Walking"
}
```
