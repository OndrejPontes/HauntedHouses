#REST API

**URL**: `http://localhost:8080/pa165/`


###Methods URLs
**URLs to get all items in collection:**

| Collection        | URL           |
| ------------- |:-------------:|
| ghosts | `/ghosts` |
| abilities      | `/abilities` |
| houses | `/houses` |
| hauntings | `/hauntings` |


**Examples of other methods:**


| Method        |   | URL | |
| ------------- |:------:| :-----:| :------:|
| Get item  | GET | `/{id}`   | |
| Get item by name |  GET |   `/name/{name}`   | possible with abilities, ghosts and houses
| Get by address | GET |  `/address/{address}` | possible with houses |
| Get by date  |   GET  | `/date/{date}` |  possible with hauntings |
| Create item  | POST  |  |  JSON params necessary |
| Update item |   PUT |  |  JSON params necessary |
| Delete item  |   DELETE | `{id}` |  |


###Using CURL
For example
```
curl -i http://localhost:8080/pa165/ghosts/
```
returns list of all ghosts in database.