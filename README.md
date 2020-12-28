# bbdn-rest-demo-java
This project contains sample code for demonstrating the Blackboard Learn REST APIs in  Tomcat Java Webapp.
This sample code was built with OpenJDK 11.0.2.

### Project at a glance:
- Target: Blackboard Learn SaaS Release 2015.11.0-rel.8+0a806d1 minimum
- Source Release: v1.0
- Release Date  2016-02-25
- Author: Scott Hurrey
- Tested on Blackboard Learn SaaS Release 2015.11.0-rel.8+0a806d1

### Requirements:
- Java 11
- Developer account - register at https://developer.blackboard.com
- Test instance


### Setting Up Your Development Environment
- Tomcat: This code was developed and tested against Tomcat 9. 
- Java 11: This code was developed and tested against openjdk11.0.2.
- Gradle: Relies on Gradle 5.6.2. 

### To Use
1. Start tomcat - <i>tomcat/bin/startup.sh</i><br />
2. Replace place holders with your developer credentials and System URL, as described in the "Configuring the Script" section below<br />
3. Build project - <i>./gradlew build</i><br />
4. Deploy war file - <i>cp build/libs/bbdn-rest-demo-java.war tomcat/webapps</i><br />
5. Access index in browser - <i>http://localhost:8080/bbdn-rest-demo-java/index</i><br />
6. Follow the on-screen instructions

### Configuring the Script
Before executing the script to run against your test server you must configure it with your registered application's URL, Key, and Secret.

Open src/main/java/bbdn/rest/RestConstants.java and edit lines 5, 6, and 7.
- On line 5, if you are not testing against the developer virtual machine, replace "http://localhost:9876" with your server's top-level URL.
- On line 6 replace "insert_your_application_key_here" with the key issued when you registered your application.<br/>
- On line 7 replace "insert_your_application_secret_here" with the secret issued when you registered your application.

### What it does
The rest demo script demonstrates authenticating a REST application, management and use of the authorization token, and creating, updating, discovering, and deleting supported Learn objects.

<i><b>NOTE:</b> Before running the example code you must register a developer account and application as described on the Developer Community <a href="https://docs.blackboard.com/learn/rest/getting-started/registry">REST Registry</a> and <a href="https://docs.blackboard.com/learn/rest/getting-started/rest-and-learn">Managing REST Integrations in Learn: The REST Integrations Tool for System Administrators</a> pages. You must also configure the script as outlined in the below Configure the Script section.</i>

This webapp allows you to:<br />
- Authenticate<br/>
- Create, Read, and Update a Data Source<br/>
- Create, Read, and Update a Term<br/>
- Create, Read, and Update a Course<br/>
- Create, Read, and Update a User<br/>
- Create, Read, and Update a Membership<br/>
- Delete created objects in reverse order of create - membership, user, course, term, datasource.

All generated output is sent to the browser.


## Running the Demo!
### Setup Your Test Server
To run the demo if you have not already done so you must as outlined above register the application via the Developer Portal and add the application to your test environment using the REST API Integration tool.

### Conclusion
For a thorough walkthrough of this code, visit the corresponding Blackboard Developer Community <a href="https://docs.blackboard.com/learn/rest/examples/java-demo" target="_blank">REST Demo Using Java</a> document.
