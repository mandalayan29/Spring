# Spring
Repository for Spring applications


Spring boot includes Embedded Servlet Container.

Spring Boot automatically configures your application based on the dependencies you have added to the project by using @EnableAutoConfiguration annotation. For example, if MySQL database is on your classpath, but you have not configured any database connection, then Spring Boot auto-configures an in-memory database.
The entry point of the spring boot application is the class contains @SpringBootApplication annotation and the main method.
Spring Boot automatically scans all the components included in the project by using @ComponentScan annotation.

Spring Boot Starter Actuator dependency is used to monitor and manage your application.

If you added @SpringBootApplication annotation to the class, you do not need to add the @EnableAutoConfiguration, @ComponentScan and @SpringBootConfiguration annotation. The @SpringBootApplication annotation includes all other annotations.
Spring Boot application scans all the beans and package declarations when the application initializes. You need to add the @ComponentScan annotation for your class file to scan your components added in your project.

To create an executable jar file : mvn clean install
To run the JAR file: java -jar <jarfile_name>.jar

For jar file deployment it is normal
We need to extend the class SpringBootServletInitializer to support WAR file deployment

@SpringBootApplication
public class DemoApplication  extends SpringBootServletInitializer {
   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(DemoApplication.class);
   }
   public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
   }
}
need to mention the main class that should start in the build file.
<start-class>com.tutorialspoint.demo.DemoApplication</start-class>
To update the packaging style from jar to war:
	<packaging>war</packaging>
For Maven, use the command mvn package for packaging your application.

Spring Boot automatically configures the dependencies version based on the release. Remember that when you upgrade the Spring Boot version, dependencies also will upgrade automatically.
For Maven configuration, we should inherit the Spring Boot Starter parent project to manage the Spring Boot Starters dependencies.
<parent>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-parent</artifactId>
   <version>1.5.8.RELEASE</version>
</parent>

@SpringBootApplication
public class Application {
   public static void main(String[] args) {SpringApplication.run(Application.class, args);}
}

In Spring Boot, we can use Spring Framework to define our beans and their dependency injection. The @ComponentScan annotation is used to find beans and the corresponding injected with @Autowired annotation.
If you followed the Spring Boot typical layout, i.e. proper package structure. no need to specify any arguments for @ComponentScan annotation. All component class files are automatically registered with Spring Beans.
Application.properties allow us to run our spring boot application in different environment.
Command line properties take precedence over the other property sources.
Java -jar demo.jar –server.port=9000   // we can use multiple properties also

application.properties
server.port = 9090
spring.application.name = demoservice

application.yml
spring:
   application:
      name: demoservice
   Server:
port: 9090

For external property file
Java -jar -Dspring.config.location = C:\application.properties <file_name>.jar
@Value annotation is used to read the environment or application property value in Java code.
@Value("${property_key_name}")
@Value("${spring.application.name}")
We can also assign default value 
@Value("${property_key_name:default_value}")
@Value("${spring.application.name:demoservice}")

Spring Boot supports different properties based on the Spring active profile.
application.properties
server.port = 8080
spring.application.name = demoservice

application-dev.properties
server.port = 9090
spring.application.name = demoservice

application-prod.properties
server.port = 4431
spring.application.name = demoservice

While running jar file:
Java -jar <file_name>.jar –spring.profiles.active=dev
For application.yml in a single file we can create multiple profiles
spring:
   application:
      name: demoservice
server:
   port: 8080
---
spring:
   profiles: dev
   application:
      name: demoservice
server:
   port: 9090


Spring Boot uses Apache Commons logging for all internal logging. Spring Boot’s default configurations provides a support for the use of Java Util Logging, Log4j2, and Logback. Using these, we can configure the console logging as well as file logging.
If you are using Spring Boot Starters, Logback will provide a good support for logging. Besides, Logback also provides a use of good support for Common Logging, Util Logging, Log4J, and SLF4J.
Log Format
The default Spring Boot Log format is shown in the screenshot given below.

which gives you the following information −
Date and Time that gives the date and time of the log
Log level shows INFO, ERROR or WARN
Process ID
The --- which is a separator
Thread name is enclosed within the square brackets []
Logger Name that shows the Source class name
The Log message

For Debug level log:
java –jar demo.jar --debug
debug = true

File log: we need to set file or path in properties file, after 10mb file will change
logging.path = /var/tmp/
logging.file = /var/tmp/mylog.log

Spring Boot supports all logger levels such as “TRACE”, “DEBUG”, “INFO”, “WARN”, “ERROR”, “FATAL”, “OFF”.
private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
 logger.info(“sad asda sdA S”) 
Restful web services
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>    
</dependency>

 @RestController annotation is used to define the RESTful web services. It serves JSON, XML and custom response.
@RequestMapping annotation is used to define the Request URI to access the REST Endpoints. We can define Request method to consume and produce object. The default request method is GET.
@RequestMapping(value = "/products")
@RequestBody annotation is used to define the request body content type.
@RequestParam annotation is used to read the request parameters from the Request URL. By default, it is a required parameter. We can also set default value for request parameters as shown here −
public ResponseEntity<Object> getProduct( @RequestParam
(value = "name", required = false, defaultValue = "honey") String name) {
}

The default HTTP request method is GET. This method does not require any Request Body. You can send request parameters and path variables to define the custom or dynamic URL.
The HTTP POST request is used to create a resource. This method contains the Request Body. We can send request parameters and path variables to define the custom or dynamic URL.
@RequestMapping(value = "/products", method = RequestMethod.POST)

The HTTP PUT request is used to update the existing resource. This method contains a Request Body. We can send request parameters and path variables to define the custom or dynamic URL.
The HTTP Delete request is used to delete the existing resource. This method does not contain any Request Body. We can send request parameters and path variables to define the custom or dynamic URL.

Exception Handling
@ControllerAdvice is an annotation, to handle the exceptions globally.
@ExceptionHandler is an annotation used to handle the specific exceptions and sending the custom responses to the client.




Servlet Filter
A filter is an object used to intercept the HTTP requests and responses of your application. By using filter, we can perform two operations at two instances −
Before sending the request to the controller
Before sending a response to the client.
The following code shows the sample code for a Servlet Filter implementation class with @Component annotation.
@Component
public class SimpleFilter implements Filter {
   @Override
   public void destroy() {}

   @Override
   public void doFilter
      (ServletRequest request, ServletResponse response, FilterChain filterchain) 
      throws IOException, ServletException {}

   @Override
   public void init(FilterConfig filterconfig) throws ServletException {}
}


Server port: By default port is 8080
server.port = 9090
Rest Template
Rest Template is used to create applications that consume RESTful Web Services. You can use the exchange() method to consume the web services for all HTTP methods. 
@SpringBootApplication
public class DemoApplication {
   public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
   }
   @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }
}

points to consume the API −
Autowired the Rest Template Object.
Use HttpHeaders to set the Request Headers.
Use HttpEntity to wrap the request object.
Provide the URL, HttpMethod, and Return type for Exchange() method.

Consuming the GET API by using RestTemplate - exchange() method
@RestController
public class ConsumeWebService {
   @Autowired
   RestTemplate restTemplate;

   @RequestMapping(value = "/template/products")
   public String getProductList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      
      return restTemplate.exchange("
         http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
   }
}

POST
@RequestMapping(value = "/template/products", method = RequestMethod.POST)
   public String createProducts(@RequestBody Product product) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
      
      return restTemplate.exchange(
         "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
   }
URL, HttpMethod, and Return type for exchange() method.
PUT
restTemplate.exchange( "http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
DELETE
restTemplate.exchange( "http://localhost:8080/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
WebClient, are non blocking api, use web flux.

File Upload
For uploading a file, you can use MultipartFile as a Request Parameter and this API should consume Multi-Part form data value. 
@RequestMapping(value = "/upload", method = RequestMethod.POST, 
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   
 public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
      File convertFile = new File("/var/tmp/"+file.getOriginalFilename());
      convertFile.createNewFile();
      FileOutputStream fout = new FileOutputStream(convertFile);
      fout.write(file.getBytes());
      fout.close();
      return "File is upload successfully";
   }

File Download
For file download, you should use InputStreamResource for downloading a File. We need to set the HttpHeader Content-Disposition in Response and need to specify the response Media Type of the application.
@RequestMapping(value = "/download", method = RequestMethod.GET) 
   public ResponseEntity<Object> downloadFile() throws IOException  {
      String filename = "/var/tmp/mysql.png";
      File file = new File(filename);
      InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
      HttpHeaders headers = new HttpHeaders();
      
      headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
      headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
      headers.add("Pragma", "no-cache");
      headers.add("Expires", "0");
      
      ResponseEntity<Object> 
      responseEntity = ResponseEntity.ok().headers(headers).contentLength(
         file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
      
      return responseEntity;
   }

Service
Service Components are the class file which contains @Service annotation. These class files are used to write business logic in a different layer, separated from @RestController class file.
public interface ProductService {
	//methods
}
The class that implements the Interface with @Service annotation is as shown −
@Service
public class ProductServiceImpl implements ProductService {
	//method implementations
}


Thymeleaf templates to create a web application in Spring Boot. You will have to follow the below steps to create a web application in Spring Boot by using Thymeleaf.
Use the following code to create a @Controller class file to redirect the Request URI to HTML file
Location: resources/templates/index.html
@Controller
public class WebController {
   @RequestMapping(value = "/index")
   public String index() {
      return "index";
   }
}



CORS
Cross-Origin Resource Sharing (CORS) is a security concept that allows restricting the resources implemented in web browsers. It prevents the JavaScript code producing or consuming the requests against different origin.
For example, your web application is running on 8080 port and by using JavaScript you are trying to consuming RESTful web services from 9090 port. Under such situations, you will face the Cross-Origin Resource Sharing security issue on your web browsers.
Two requirements are needed to handle this issue −
RESTful web services should support the Cross-Origin Resource Sharing.
RESTful web service application should allow accessing the API(s) from the 8080 port.
@CrossOrigin(origins = "http://localhost:8080")
-> add this at method or controller
@Bean
public WebMvcConfigurer corsConfigurer() {
   return new WebMvcConfigurerAdapter() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/products").allowedOrigins("http://localhost:9000");
      }    
   };
}
-> add this in @SpringBootApplication



















