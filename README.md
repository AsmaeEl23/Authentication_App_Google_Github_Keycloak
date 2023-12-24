<h1>How to Secure Spring Boot and Angular Apps using Oauth 2 and OIDC Keycloak Google GitHub</h1>
<h5>Dependencies</h5>

<ul>
<li>Spring web</li>
<li>Lombok</li>
<li>Spring data jpa</li>
<li>oauth2 client</li>
<li>thymeleaf</li>
<li>h2 database</li>
<li>webjars bootstrap 5</li>
<li>thymeleaf layout</li>
<p>

**Thymeleaf:**
Thymeleaf is a Java-based server-side template engine commonly used in Spring applications. 
It enables the dynamic rendering of web pages by embedding expressions in HTML markup, 
facilitating the creation of dynamic and data-driven user interfaces.

**Thymeleaf Layout:**
Thymeleaf Layout is an extension for Thymeleaf that simplifies the creation of reusable layouts in web applications.
It allows developers to define standard templates (e.g., headers, footers) and dynamically inject content into these templates. 
This helps maintain a consistent look and feel across different pages, improving code organization 
and promoting reusability in the development of web applications.
</p>
</ul>
<h5>Security with google</h5>
<a href="https://cloud.google.com/cloud-console/">console google</a> (or)
<a href="https://console.cloud.google.com/home/dashboard?project=eminent-booking-407818&organizationId=0">console google</a>
<img src="images/img.png">
<img src="images/img_1.png">
configurer l'ecrane de ...
<img src="images/img_2.png">
<img src="images/img_3.png">
Add app name and your email (twice) --> save 
<img src="images/img_4.png">
<img src="images/img_5.png">
<img src="images/img_6.png">
Take the client id and secret and add it to the application.properties
add SecurityConfig Class
take the url and put it in google console (authorized URI)
<img src="images/img_7.png">
<p>http://localhost:8081/login/oauth2/code/google</p>
<img src="images/img_8.png">
<h3>Logout</h3>
add the thymeleaf-extras dependency
<pre>
        <.dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity6</artifactId>
            <version>3.1.0.M1</version>
        <./dependency>
</pre>

<h2>Github</h2>
<p>go to github setting then developer setting -> auth apps and create new auth-app</p>
<a href="https://github.com/settings/developers">developers</a>
<img src="images/img_9.png">
<img src="images/img_10.png">
<h2>Keycloak</h2>
<p>when we create a client we need to fill this to use the client id and client secret</p>
<img src="images/img_11.png">
<img src="images/img_12.png">
<h5>create roles and users </h5>
<img src="images/img_13.png">
<p>http://localhost:8081/login/oauth2/code/github</p>
<p>Keycloak test with HTTP request</p>
<pre>
POST http://localhost:8080/realms/sdia-app-realm/protocol/openid-connect/token
Accept: application/json
Content-Type: application/x-www-form-urlencoded

grant_type=password&username=user1&password=user1&client_id=sdia-customers-app&client_secret=2gBa9DYZQ7kw9u0Ef9VTaDpLGvphUYff
</pre>
<p>Get the client secret </p>
<img src="images/img_14.png">
<img src="images/img_15.png">
<p>add roles for authentification (add roles in jwt)</p>
<img src="images/img_16.png">
<img src="images/img_17.png">
<img src="images/img_18.png">
<p>click on the role realm that we added then</p>
<img src="images/img_19.png">
<p>the roles are now in the jwt exactly in realm_access</p>
<h5>Add 2 functions to the SecurityConfig</h5>
<p> 
    public GrantedAuthoritiesMapper userAuthoritiesMapper() -----
    mapAuthorities</p>
<p>Add a not authorized page</p>
<p>Assign role to a user who authenticated, if we registered</p>
<img src="images/img_20.png">
<img src="images/img_21.png">
<p>Our new user (user3) has a USER role</p>
<img src="images/img_22.png">
<h6>Apply the security politics</h6>
<img src="images/img_23.png">
<img src="images/img_24.png">



<h2>Inventory Service</h2>
<img src="images/img_27.png">
<h6>Test our security of the inventory service </h6>
<pre>
POST http://localhost:8080/realms/sdia-app-realm/protocol/openid-connect/token
Accept: application/json
Content-Type: application/x-www-form-urlencoded

grant_type=password&username=user1&password=user1&client_id=sdia-customers-app&client_secret=f65VK6o1ntoqXSYMmVKsdaUAbRPV5vxY


###

GET http://localhost:8082/products
Authorization: Bearer (access token =eyJhbGciOiJSUvbWVy..)

</pre>




<h2>Angular</h2>
<p>1-Install angular with this command : <color style="color: yellowgreen">npm install @angular/cli</color></p>
<p>2-Create a directory customer-front-angular-application</p>
<p>3-Create angular project with this command : <color style="color: yellowgreen">ng new customer-front-angular-application --directory ./ --no-standalone</color> , (--no-standalone) is for generate the module</p>
<p>Generate component (customers and products component) : <color style="color: yellowgreen">ng g c customers</color></p>
<p>Install bootstrap : <color style="color: yellowgreen">npm i bootstrap bootstrap-icons</color></p>
<p>Declare bootstrap in angular.json file, in style add : <color style="color: yellowgreen">"node_modules/bootstrap/dist/css/bootstrap.min.css"</color> , in script add : <color style="color: yellowgreen">"node_modules/bootstrap/dist/js/bootstrap.bundle.js"</color> </p>
<img src="images/img_25.png">
<p>Add <color style="color: burlywood">@import "bootstrap-icons/font/bootstrap-icons.min.css"</color> in style.css file</p>
<p>Modify the app.component.htm, customers/products.htm with some html codes</p>
<p>Add routes in app.routing.module.ts</p>
<p>Add HttpClientModule in app.module.ts (import) then the products and customers component to generate them</p>
<h5>Create new Angular keycloak client</h5>
<img src="images/img_26.png">
<h6>Authentification backend channel</h6>
<p>Authentication in the backend channel will be implemented using a customized approach, 
distinct from the default Keycloak authentication form. 
(by another formular of authentification, not the keycloak formular)</p>
<p>But here we gonna use frontend channel, using the keycloak authentication formule</p>
<h5>Keycloak activation in Angular</h5>
<a href="https://www.npmjs.com/package/keycloak-angular">get all you need about the keycloak-angular</a>
<p>1- Install keycloak-angular and keycloak-js by : <color style="color: yellowgreen">npm install keycloak-angular keycloak-js</color></p>
<p>2- Add factory function in the module which will set up the Keycloak service so that it can be used in the application.</p>
<p>Add realm and client id name</p>
<pre>
function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'your-realm',
        clientId: 'your-client-id'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}
</pre>
<p>3- Creat silent-check-sso.html file in assents directory and add on it : </p>
<p>To apply the factory function(service) if we start the application, we add this provider in the module, and import KeycloakAngularModule(inclue the KeycloakService) in the imports</p>
<pre>
{provide : APP_INITIALIZER, deps : [KeycloakService],useFactory : initializeKeycloak, multi : true}
</pre>
<h6>protect the routes by Guards</h6>
<ul>
<li>Generate guards in the directory guards</li>
<p><color style="color: yellowgreen">nvm use 20</color></p>
<p><color style="color: yellowgreen">ng g g guards/auth</color></p>
<p>Modify the file auth.guards.ts, and protect the roles in routing.module file, add the role admin for products</p>
</ul>
<h5>Display Use name</h5>
<h6>Generate services <color style="color: yellowgreen">ng g s services/security</color></h6>
<h6>App component <color style="color:cadetblue">Implement onInit</color></h6>
<h6>Use the service to display the username, in component.html</h6>
<h6>Create the login and logout methods</h6>


<h2>With Docker</h2>
<h5>SQL database place of h2</h5>
<p>Add sql dependency in inventory service</p>
<pre>
        <.dependency>
			<.groupId>com.mysql<./groupId>
			<.artifactId>mysql-connector-j<./artifactId>
		<./dependency>
</pre>
<h3>MYSQL container in Docker</h3>
<ul>
<li type="1">Create docker-compose.yml file</li>
<pre>
#Demarer plusieur services
services:
  #service 1 = mysql-db-inventory
  mysql-db-inventory:
    #L'image de docker pour mysql
    image: mariadb:10.6
    #Conteneur avec la meme nom comme le service
    container_name: mysql-db-inventory
    #Il est important de redemarer toujour
    restart: always
    #Si on supprime le conteneur les donnees rest a laide de volumes pour stocker toutes les donnees sur mysql_data:/var/lib/mysql mais il faut declarer le volume docker mysql_data
    volumes:
      - mysql_data:/var/lib/mysql
    #Dommande a cree une base de donnees inventory-db
    environment:
      MYSQL_DATABASE: inventory-db
      MYSQL_USER: asmae
      MYSQL_PASSWORD: asmae123
      MYSQL_ROOT_PASSWORD: admin
    ports:
      #port exterieur de conteneur : port interieur de conteneur
      - 3306:3306
    healthcheck:
      test: [ "CMD", "mysqladmin" ,"ping", "-h", "localhost" ]
      timeout: 5s
      retries: 10
  phpmyadmin:
    image: phpmyadmin
    restart: always
    ports:
      - 9999:80
    environment:
      #use our my sql service name
      PMA_HOST: mysql-db-inventory
      PMA_PORT: 3306
      #acceder a la base de donnees par defaut
      PMA_ARBITRARY: 1

#************************************
volumes:
mysql_data:
</pre>
<li type="1">Docker commands</li>
<li type="1">Start the docker compose with this command : docker compose up </li>
<img src="images/img_28.png">
<img src="images/img_29.png">
<p>" docker images " command, to see all the images</p>
<p>" docker ps " command, to see the starting containers</p>
<p>" docker stop [the first 4 numbers of the container ID/or name] " command, to stop a container</p>
<p>" docker start [the first 4 numbers of the container ID/or name] " command, to start a container</p>
<p>" docker logs [the first 4 numbers of the container ID/or name] " </p>
<img src="images/img_30.png">
<p>"docker compose down" to shut down all the services and removing all the containers</p>
<p>"docker compose up -d" to start all the services</p>
<img src="images/img_31.png">
<li type="1">Run inventory service</li>
<img src="images/img_32.png">
<p>the use of mysql in place of h2 </p>
</ul>
<h3>Generate app.jar</h3>
<ul>
<li>put the spring application in docker, so we need to generate it by mvn</li>
<p>"mvn compile" --> compile source code</p>
<p>"mvn test" --> run unit tests</p>
<p>"mvn package" --> do the 3 (compile and test) then generate packages</p>
<p>"mvn clean" --> to delete all the content of the target folder</p>
<p>"mvn clean package -DskipTests" --> to delete and regenerate the package without the unit tests</p>
<p>Our application generated in Target</p>
<img src="images/img_33.png">
<li>Run the app (in the path /target run the command)</li>
<p>without docker -->  "java -jar [name of the app]"</p>
<img src="images/img_34.png">
</ul>
<h3>Run the app with Docker</h3>
<ul>
<li type="1"><h5>Create a docker file for each service</h5></li>
<pre>
#image openjdk
FROM openjdk:17
VOLUME /tmp
#copy the jar file from target to docker with the name app.jar, so in the docker we will find the image ad the app
COPY target/*.jar  app.jar
#To execute the app (jave -jar app.jar) manually
ENTRYPOINT ["java","-jar", "app.jar"]
</pre>
<li type="1"><h5>Create the image "docker build . -t [nameOfImage/inventory-service-sdia]:[version/v1]"</h5></li>
<img src="images/img_35.png">
<li type="1"><h5>Start containers from this image " docker run inventory-service-sdia:v1 -e DB_URL=jdbc:mysql://mysql-db-inventory:3306/inventory-db" </h5></li>
<p>But there is a problem of network, the containers inventory and mysql don't exist in the same network,
so they can not communicate, that's why we are going to use the docker compose</p>
<li type="1"><h5>Create new service for the inventory app in docker-compose.yml </h5></li>
<p>To make the 3 services in the same network, so they can communicate between them </p>
<p>Run again those commands "docker compose down", "docker compose up -d --build" --build to force the creation of the image, for each request of the recreation</p>
<li type="1"><h5>Summary (Run the app with docker)</h5></li>
<ul>
<li>"mvn clean package -DskipTests" --> Generate the jar file </li>
<li>"docker compose down"</li>
<li>"docker compose up -d --build"</li>
<img src="images/img_36.png">
</ul>
</ul>
<h3>Customer front thymeleaf application</h3>
<p>Same thing we did with inventory service</p>
<p>1- Modify keycloak URI in app.properties</p>
<p>2- Generate keycloak, postgres and pgadmin4 services in docker-compose</p>
<img src="images/img_37.png">
<p>In host name we write the name of our service (container name) we declared in the compose file, also the other information</p>
<p>Add the thymeleaf service and also their environment on app.prop</p>
<p>Realm setting in keycloak make the Require ssl none</p>

<h3>Angular</h3>
<ul>
<li><h5>"ng build" -->Generate the jar file </h5></li>
<li><h5>Create Dockerfile</h5></li>
<li><h5>Add the angular service in docker_compose file</h5></li>
<li><h5>Change the onLoad : 'login-required' in app-module, that means it obligatory to authenticate before you inter the app</h5></li>
</ul>


