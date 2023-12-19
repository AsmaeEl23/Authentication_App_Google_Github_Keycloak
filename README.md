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


<h3>With Docker</h3>

