REST with Java, Jersey 2, Jetty and Maven
================

#Technologies:

- Java 1.7
- Jersey 2.4.1 (could be easily upgraded)
- Maven 3
- Jetty 8.1.9 (managed by Maven)

#Configuration needed

You will need [Maven](http://maven.apache.org/). You don't necessarily need to know how Maven works; you only need to install it.

#How to start the example

Execute mvn jetty:run at the root folder (the same that contains pom.xml).

#How to check it's working

Point your browser to <http://localhost:8090/sample/services/person>. If it presents to you a list of people, it's working.

#How has this URL been generated?

localhost -> It's your own host (duh);
8090      -> Set in Jetty's plugin in the file pom.xml
sample	  -> Same as above
services  -> Defined in web.xml
person    -> Defined in PersonResource.java

