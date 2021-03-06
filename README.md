# Exposition Calendar

**Client-Server application, where visitors can buy tickets on chosen expositions.**

**Features:** MVC, Maven, Apache Tomcat, Session, Servlet, listeners,
                JSP, JSTL, localization, authorization, authentication, MySQL DB, 
                transactions, Log4j.
                
1. *Description* 

There is a list of Expositions located in Expo Halls. Visitor chooses topic, buys Tickets and makes a Payment.
Administrator can add Expositions and Expo Halls (for now tickets can be added directly in DB).

2. *Software requirements*

 * jdk 1.8.0_171
 * Apache Tomcat 9.0.8
 * MySQL Server 8.0.11
 * Apache Maven 3.5.4  

3. *Installation*

Download project from Github repository. Start MySQL server (both login and password are "root"). Execute createdb.sql to create database tables. In command line run ```mvn clean install```. Copy expocalendar.war from target folder and paste it to the /TOMCAT/webapps folder.

4. *Launch*

Run Tomcat server using script /TOMCAT/bin/startup.bat .The deployed project will be available on http://localhost:8080/expocalendar/.

To register as administrator use adminKey "11" (change it in config file).

