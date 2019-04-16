# java-todos

# Introduction

This is a basic todo database scheme with users and a todo list.

# Instructions

Create a REST api server to store and read data from the provided SQLite Database called todos.db. data.sql is the script that was used to populate the database.  Hint: use the crudy snack application worked through during the presents as a model!

The table layouts are as follows:

- [x] TODOS
  * todoid primary key, not null int
  * description string, not null
  * datestarted datetime // adding this is now a stretch goal
  * completed boolean (0 = false 1 = true)/ / adding this is now a stretch goal
  * userid foreign key (one user to many todos) not null 

- [x] USERS
  * userid primary key, not null int
  * username string, not null
  
Expose the following end points

- [x] GET /users - returns all the users
- [x] GET /todos - return all the todos

- [x] GET /users/id/{userid} - return the user based off of the user id
- [x] GET /users/name/{username} - return the user based off of the user name
- [x] GET /todos/id/{todoid} - return the todo based off of the todo id

- [x] GET /todos/users - return a listing of the todos with its assigned user's name
- [ ] GET /todos/active - return a listing of the todos not yet completed. // adding this is now a stretch goal

- [x] POST /users - adds a user
- [x] POST /todos - adds a todo

- [x] PUT /users/id/{userid} - updates a user based on userid
- [x] PUT /todos/id/{todoid} - updates a todo based on todoid

- [x] DELETE /users/id/{userid} - Deletes a user based off of their userid and deletes all their associated todos
- [x] DELETE /todos/id/{todoid} - deletes a todo based off its todoid

* Add Swagger Documentation to your REST APIs
  - [x] Add custom responses to each of the follow error conditions
    * 200 - successfully retrieve list
    * 401 - not authorized for this resource
    * 403 - access to resource forbidden
    * 404 - resource not found

  * Add custom Swagger Documentation to each of the follow End Points. The rest of the end points may just have the default documentation.
      - [x] GET /todos
      - [x] GET /todos/users
      - [ ] GET /todos/active // adding this is now a stretch goal
      - [x] PUT /todos/id/{todoid}
      - [x] DELETE /todos/id/{todoid}
    - [ ] For a stretch goal - add custom responses to the rest of the end points

- [x] Add flyway data migration
  * for this project we will just have the starting migration. The DDL for creating the tables can be found in the file tables.DDL

- [x] the end points should return null when no data is found.

- [x] change end points so they return data that is deleted or a new copy of updated data

* Expose at least the following the actuator endpoints to help with system mangagement
   - [x] /health
   - [x] /info
   - [x] /metrics
   
   - [x] Stretch goal - update each of these three actuator endpoints to report your own messages. 
   
