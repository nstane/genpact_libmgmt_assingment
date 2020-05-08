# Genpact Library Book Keeping Assingment

## Below are exposed API end points

### Get all Books :
`http://localhost:8080/api/book`

`[
    {
        "title": "Spring Boot Starter App development",
        "author": "Narender Singh",
        "id": 3
    }
]`

### Get Book By Id : 
`http://localhost:8080/api/book/{id}`

---
#### **Sampel Response:**
---
`{
    "title": "Spring Boot Starter",
    "author": "Narender Singh",
    "id": 4
}`

### Add Book By Id : 
`http://localhost:8080/api/book/{id}`

---
#### **Request Body:** 
---
`{
  "title":"Spring Boot Starter App development",
  "author":"Narender Singh",
  "library_id":1
}`

---
#### **Response body :** 
---
`{
    "title": "Spring Boot Starter",
    "author": "Narender Singh",
    "id": 4
}`

### Update Book By Id : 
`http://localhost:8080/api/book/{id}`

---
#### **Request Body:**
---
`{
    "title":"Spring Boot Starter Actuators exposure",
    "author":"Narender Singh",
    "library_id":1
}`

---
#### **Response Body:**
---

```{
    "title": "Spring Boot Starter Actuators exposure",
    "author": "Narender Singh",
    "id": 4
}```

### Delete Book By Id : 
`http://localhost:8080/api/book/{id}`

**No Response fo delete**
