# ChâTop
Welcome to the back part of the application ChâTop !  
To access to the front part, [go to this link](https://github.com/ManonAntigoneDauguet/FormationFS_projet2).

Feel free to check out the [documentation of the API :
- with [this link](http://localhost:3001/api/swagger-ui/index.html) if the is launching
- with [this file](api-docs.json) to load into [Swagger Editor](https://editor.swagger.io/)

## Dependencies

This project is using java 17.

## How to Install and Run the Project

After to create your own database, save your password and username in a `.env` file under these constants :
- DATABASE_USERNAME
- DATABASE_PASSWORD

Running the project generate the necessary tables in the database and allow to use the necessary endpoints of the application.   

The server run on the port 3001.

When the server is launching, you can consult the documentation of the API with [this link](http://localhost:3001/api/swagger-ui/index.html).

## Access to uploaded pictures

The API allows the user to save a picture on action POST "/rentals".  
This picture is saved into the folder driven by the environment variable `path.saving.picture`(by default `src/main/resources/static/pictures`)  
The API allow to return the saved picture by the `server.base-pictures-url` (by default `http://localhost:3001/pictures/`)

With the default parameters, the pictures are saved into a static folder. So the API can return the information about the picture with `server.base-pictures-url` without specific endpoints.