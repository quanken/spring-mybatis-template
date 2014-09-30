spring-mybatis-template
=======================

This is a mixed Java/Groovy J2EE Gradle Project. 

This project show you :
* how to compile groovy and java mixed j2ee project with gradle
* mybatis annotation example with groovy implements
* mybatis paginator to page query datas


Preparation
=======================

In order to run this example project, you should have :
* Java JDK 1.6+
* Gradle 1.10 above(Current Gradle 2.1)
* Vim / Intellij IDEA / Eclipse or other editors
* Tomcat 6+
* MySQL Server 5.1 or above

Build
=======================

exec `gradle build` to get the project achievement
or `gradle deploy` to have the build achievement to place in `deploy` dir

Before you actually run the project, you `MUST` do :
* init database, table and test data with `database/*.sql`
* modify database connection info in `src/main/resources/application.properties`

