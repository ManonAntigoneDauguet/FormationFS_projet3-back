# ChâTop
Welcome to the back part of the application ChâTop !  
To access to the front part, [go to this link](https://github.com/ManonAntigoneDauguet/FormationFS_projet2).

Feel free to check out the [documentation of the API :
- with [this link](http://localhost:3001/api/swagger-ui/index.html) if the is launching
- with [this file](api-docs.json) to load into [Swagger Editor](https://editor.swagger.io/)

## Table of Contents

1. [Dependencies](#dependencies)
2. [How to install and run the project](#how-to-install-and-run-the-project)
3. [Access to uploaded pictures](#access-to-uploaded-pictures)
4. [About database](#about-database)

## Dependencies

This project is using java 17.

## How to install and run the project

After creating your own database, complete the `.env` file with the following constants :
- `DATABASE_USERNAME` as your database username
- `DATABASE_PASSWORD` as your database password
- `JWT_KEY` as the key used to encode the JWT token. It must be sufficiently long.  
(example : `ThisIsASecretKeyThatIsAtLeast32BytesLong1545135951695622156622`)

Running the project generate the necessary tables in the database and allow to use the necessary endpoints of the application.   

The server run on the port 3001.

When the server is launching, you can consult the documentation of the API with [this link](http://localhost:3001/api/swagger-ui/index.html).  
Note : by default the JWT token expiration time is set on 1 day. You can change this setting in the `application.properties` file with the `chatop.app.jwtExpirationMs` property.

You can run with `java -DDATABASE_USERNAME= youruser-DDATABASE_PASSWORD=yourpassword -DKEY=hjxgsqhdshdfgdsfkdsjhfgdkjsgfkj chatop.jar`.

## Access to uploaded pictures

The API allows the user to save a picture on action POST `/rentals`.  
This picture is saved into the folder driven by the environment variable `path.saving.picture`(by default `C:\\Documents\\projet4.pictures\\`)

## About database

With the `schema.sql`, the necessary tables will be created.  
By default, the Hibernate configuration of the project is set to `create` : the tables are removed and recreated with each run of the application.
If you want to preserve the previous state of your tables, please change the setting to `update`.
