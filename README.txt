COFFEEHOUR 

This project represents the backend for a web application. 
The purpose of COFFEEHOUR is to allow people to order from their favourite bar from the comfort of their office. 
Imagine it like it was some sort of UberEats, but... only for a coffee or a quick snack!

This README will serve as a dev diary, explaining my choices.
I will also try to commit, going step by steap, each implementation to the project on the GitHub project.
I've chosen a Springboot project with Maven because I wanted to deepen my knowledge of both the two technologies.
The same can be told about the choice of the Database, Mongo.

The first dependency other than "mongo" and "web" is "lombok". I've chosen it in order to apply the @Data annotation to my entities,
With the @Data annotation, many essential methods are generated for free.
Furthermore, lombok gives us access to @Slf4j (for log implemention) and @Builder, which creates class builders for us.

I started by creating the "User" entity. I created a simple entity, its repository and service, then I started implementing the methods of the service.
I created a BaseEntity class, that will be the foundation for every class I am going to build in the future. In future, It will implement other infos.

With it, the necessity to handle exceptions and mapping has risen.