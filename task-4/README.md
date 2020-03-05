# Setup Script 


## Prepare `MySql` Database

To be able to run this `JPA` you need to have following things:
 - `Java 8`
 - `Maven`
 - Installed `MySql` server and running deamon.
 
This is an example of creating `User` with `Password` on `localhost`. 

```sql
CREATE USER 'artem'@'localhost' IDENTIFIED BY 'salt';
GRANT ALL ON *.* TO 'artem'@'localhost';
```

In the example above we've created **user** `artem` on `localhost` 
with **password** `salt`. And after thar we've granted 
all privileges to this **user**  

If you want you can change these **params** as you need.

>*NOTE*: If you change some **params** somewhere in this topic -
> you will need change the same in `application.properties` file.

Than we need to create a database 
which saves all our data.

```sql
CREATE DATABASE task4;
```

In this example we've created database with name `task4`.
You can change the name of DB as you want.


## API docs

API documentation can be found below or under 
[Postman Api Docs](https://documenter.getpostman.com/view/7712624/SzRuYrsh?version=latest#e8a4c052-b06f-4c49-a97d-5c2fe55378bb).

### ToC
 - General
 - `/manager`
   - `PUT` - Create a new `Manager` employee.
   - `GET` - Get List of all employees of type `Manager`

