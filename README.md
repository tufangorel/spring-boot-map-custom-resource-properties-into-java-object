## spring-boot-map-custom-resource-properties-into-java-object

1- Read custom properties files from src/main/resources into Java object depending on active profile. <br/>
2- Start Spring Boot application with a specific profile such as "-Dspring.profiles.active=dev" . <br/>

### Tech Stack
Java 11 <br/>
H2 Database Engine <br/>
spring boot <br/>
spring data jpa <br/>
spring web <br/>
hibernate <br/>
logback <br/>
maven <br/>
junit <br/>
<br/>

## API OPERATIONS
### Save customer sucessfully to database

Method : HTTP.POST <br/>
URL : http://localhost:8080/customer/save <br/>

Request : 
<pre>
curl --location --request POST 'localhost:8080/customer/save' \
     --header 'Content-Type: application/json' \
     --data-raw '{ 
                   "name":"name1",
                   "age":1,
                   "addresses":[{"streetName":"software","city":"ankara","country":"TR"}]
    }'
</pre><br/>

Response : 

HTTP response code 200 <br/>
<pre>
{
    "id": 1,
    "name": "name1",
    "age": 1,
    "addresses": [
        {
            "id": 1,
            "streetName": "software",
            "city": "ankara",
            "country": "TR"
        }
    ]
}
</pre><br/>

<pre>
Console log message :

com.company.customerinfo.controller.CustomerController: user
com.company.customerinfo.controller.CustomerController: password
com.company.customerinfo.controller.CustomerController: true
com.company.customerinfo.controller.CustomerController: false
com.company.customerinfo.controller.CustomerController: write/false
com.company.customerinfo.controller.CustomerController: read/true
com.company.customerinfo.controller.CustomerController: C:\root
com.company.customerinfo.controller.CustomerController: true
</pre>
<br/>
