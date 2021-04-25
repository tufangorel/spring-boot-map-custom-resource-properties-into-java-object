## spring-boot-map-custom-resource-properties-into-java-object

1- Read Http Request header values sent to the server spring mvc rest end point inside servlet Filter before processing rest controller method.<br/>

### Tech Stack
Java 11 <br/>
H2 Database Engine <br/>
spring boot <br/>
spring data jpa <br/>
spring web <br/>
javax.servlet <br/>
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
  --header 'transaction-id: 123-123-123' \
  --header 'trace-id: 456-456-456' \
  --header 'span-id: 789-789-789' \
  --header 'request-id: 123-456-789' \
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

com.company.customerinfo.config.RequestHeaderReaderFilter: transaction-id : 123-123-123
com.company.customerinfo.config.RequestHeaderReaderFilter: trace-id : 456-456-456
com.company.customerinfo.config.RequestHeaderReaderFilter: span-id : 789-789-789
com.company.customerinfo.config.RequestHeaderReaderFilter: request-id : 123-456-789
com.company.customerinfo.config.RequestHeaderReaderFilter: content-type : application/json
com.company.customerinfo.config.RequestHeaderReaderFilter: user-agent : PostmanRuntime/7.26.10
com.company.customerinfo.config.RequestHeaderReaderFilter: accept : */*
com.company.customerinfo.config.RequestHeaderReaderFilter: postman-token : f3bf2678-3975-41bd-a44e-bf7504693b56
com.company.customerinfo.config.RequestHeaderReaderFilter: host : localhost:8080
com.company.customerinfo.config.RequestHeaderReaderFilter: accept-encoding : gzip, deflate, br
com.company.customerinfo.config.RequestHeaderReaderFilter: connection : keep-alive
com.company.customerinfo.config.RequestHeaderReaderFilter: content-length : 102
</pre>
<br/>
