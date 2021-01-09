# Customer REST API

Build an API to track the animals electronically for The Menagerie of Cryptozoological Creatures.

## Instructions

**As zookeeper, I want to add animals to my zoo.
Rule: Animal should have a name and a type (flying, swimming, walking)**

**When** I add an animalDto
**Then** it is in my zoo

**As zookeeper, I want to view animals of my zoo.**
**Given** I have added animals to my zoo
**When** I check my zoo
**Then** I see all the animals


**As a zookeper, I want to feed my animals.
Rule: Animal moods are unhappy or happy. They are unhappy by default.**

**Given** an animal is unhappy
**When** I give it a treat
**Then** the animal is happy

**Given** an animal is happy
**When** I give it a treat
**Then** the animal is still happy

## API Specifications

**Resource Summary**

| URI                                                | HTTP Method |   HTTP Status   | Description                                |
|----------------------------------------------------|-------------|-----------------|--------------------------------------------| 
| cryptozoological.com/api/animals                   | POST        |   201 CREATED   | Form submission to add a new animal.       | 
| cryptozoological.com/api/animals                   | GET         |   200           | Returns list of all animals in zoo.        |
| cryptozoological.com/api/animals/{id}              | PUT         |   200           | Feed animal and return the animal.         |
| cryptozoological.com/api/animals/{habitat}         | POST        |   200           | Update animals mood based on habitat       |
| cryptozoological.com/api/animals/{mood}/{type}     | GET         |   200           | List of all animals matches mood and happy |

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

---
**GET /api/animals**

Response Body:
```json
[{
    "id": "1",
    "name": "Elephant",
    "type": "Walking",
    "mood": "Happy",
  "habitat": "forest"
},
{
  "id": "2",
  "name": "Fish",
  "type": "Swimming",
  "mood": "Happy",
  "habitat": "ocean"
}]
```
---
**PUT /api/animals/1**

Request Body:
```json
{
    "treat": "Toy"
}
```
Response Body:
```json
{
    "id": "1",
    "name": "Elephant",
    "type": "Walking",
    "mood": "Happy",
  "habitat": "forest"
}
```
---
**POST /api/animals/forest**

Request Body 1:
```json
{
    "animal": {
      "id": "1",
      "name": "Elephant",
      "type": "Walking",
      "mood": "Happy",
      "habitat": "forest"
  }
}
```
Response Body 1:
```json

    [{
      "id": "1",
      "name": "Elephant",
      "type": "Walking",
      "mood": "Happy",
      "habitat": "forest"
    }]

```

---
**POST /api/animals/swimming**
Request Body 2:
```json
{
  "animal": {
    "id": "1",
    "name": "Elephant",
    "type": "Walking",
    "mood": "UnHappy",
    "habitat": "forest"
  }
}
```
Response Body 2:
```json
{
  "nest": 
    [{
      "id": "1",
      "name": "Elephant",
      "type": "Walking",
      "mood": "UnHappy",
      "habitat": "forest"
    }]
}
```
---
**GET /api/animals/happy/walking**

Response Body:
```json
[{
    "id": "1",
    "name": "Elephant",
    "type": "Walking",
    "mood": "Happy",
     "habitat": "forest"
},
{
  "id": "2",
  "name": "Lion",
  "type": "Walking",
  "mood": "Happy",
  "habitat": "forest"
}]
```
---
**GET /api/animals/happy/walking**

Response Body:
```json
[{
    "id": "1",
    "name": "Elephant",
    "type": "Walking",
    "mood": "Happy",
     "habitat": "forest"
},
{
  "id": "2",
  "name": "Lion",
  "type": "Walking",
  "mood": "Happy",
  "habitat": "forest"
}]
```
---
**GET /api/animals/habitats?filter=empty**

Response Body:
```json
{ 
  "habitat": 
    [
      "flying",
      "crawling"
    ]
}

```