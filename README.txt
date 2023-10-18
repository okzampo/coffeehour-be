COFFEEHOUR 

This project represents the backend for a web application. 
The purpose of COFFEEHOUR is to allow people to order from their favourite bar from the comfort of their office. 
Imagine it like it was some sort of UberEats, but... only for a coffee or a quick snack!

This README will serve as a dev diary, explaining my choices.
I will also try to commit, going step by step, each implementation to the project on the GitHub project.
I've chosen a SpringBoot project with Maven because I wanted to deepen my knowledge of both the two technologies.
The same can be told about the choice of the Database, Mongo.

The first dependency other than "mongo" and "web" is "lombok". I've chosen it in order to apply the @Data annotation to my entities,
With the @Data annotation, many essential methods are generated for free.
Furthermore, lombok gives us access to @Slf4j (for log implemention) and @Builder, which creates class builders for us.

I started by creating the "User" entity. I created a simple entity, its repository and service, then I started implementing the methods of the service.
I created a BaseEntity class, that will be the foundation for every class I am going to build in the future. It will implement other infos.

Users are implementing a "password" field, but there's no implementation for any authentication mechanism(yet).

In order to create some solid endpoints, the necessity to handle exceptions and mapping has risen.

Since I am already experienced with MapStruct, I decided to use it in order to map Entities into DTOs and vice versa.
I created a BaseMapper, an abstract generic class which will be implemented by any future mapper. Inside this class there are two "toResponse" methods.
These methods will be used in order to transfer only a fraction of data as response.
In implementing MapStruct, I experienced some problems in generating new mappers. The problems were solved by implementing a pair of plugins inside the pom.xml.

Before implementing the exception handler, I wanted to try my endpoints.
I included a docker-compose.yml file inside the project, other than the configuration for the connection to my Mongo container inside the application.properties file.
By doing so, I can finally launch my application and create, edit and delete users.