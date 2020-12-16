# quarkus-bean-scopes
Small demo app to understand the different behaviours of CDI bean scopes
Based on: Quarkus guide: https://quarkus.io/guides/security-jwt

## Compile and run
````
./mvnw compile quarkus:dev
````
## Generate jwt
````
mvn exec:java -Dexec.mainClass=org.acme.security.jwt.GenerateToken -Dexec.classpathScope=test -Dsmallrye.jwt.sign.key-location=privateKey.pem
````
This generates two tokens, one for Peter and one for Max.
## Usage
In the class TokenSecuredResource comment the different bean scopes
````
@RequestScoped
//@ApplicationScoped
//@Dependent
//@Singleton
@Path("/secured")
public class TokenSecuredResource {
````
Call the running Endpoint with the two tokens
````
curl -H "Authorization: Bearer <peter-token>" http://127.0.0.1:8080/secured/roles-allowed;
curl -H "Authorization: Bearer <max-token>" http://127.0.0.1:8080/secured/roles-allowed;
````
Observe how different results are printed in the console for different bean scopes.
## Further reading
https://quarkus.io/guides/cdi
https://quarkus.io/guides/cdi-reference
https://docs.jboss.org/cdi/spec/2.0/cdi-spec.html
https://docs.jboss.org/weld/reference/latest/en-US/html/
