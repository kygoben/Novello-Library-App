# SpringBoot JPA: One to Many relation example

### Swagger-UI 
Swagger UI is an open source library which can be used to document all the API end points in a SpringBoot application. In addition to being a very good tool for documentation, it can also serve as a makeshift manual testing framework. The process for enabling Swagger in a springboot project is trivially easy.
1. Observe the pom.xml file in this example, and add both the dependencies into your project.
2. Check the Main class and follow the exact steps to create a Docket Bean. This Bean exposes the API and its documentation as a webpage.
3. After the @SpringBootApplication add the @EnableSwagger2 annotation
4. Check the URL: http://localhost:8080/swagger-ui.html


### Pre-requisites

0. Go through the springboot_unit1_2_hellopeople
1. Go through the springboot_unit2_1_onetoone example
2. Maven has to be installed on command line OR your IDE must be configured with maven
3. Java version 1.8 - 1.10 (Some versions of springboot are really unhappy with java 11)

### To Run the project 
1. Command Line (Make sure that you are in the folder containing pom.xml)</br>
<code> mvn clean package</code></br>
<code>java -jar target/onetoone-1.0.0.jar</code>
2. IDE : Right click on Application.java and run as Java Application

### Available End points from POSTMAN: CRUDL
1. CREATE requests - 
POST request: 
    1. /laptops - Create a new Laptop. The request has to be of type application/JSON input format 
    {
        "cpuClock" : "1.7",
        "cpuCores"  : "4",
        "ram"   : "4",
        "manufacturer" : "apple",
        "cost" : "1000000"
    }
    2. /users - Create a new User with laptop. Request Format : application/json
    {
        "name" : "John",
        "email"  : "johndoe@somemail.com",
        laptop   : {
            "cpuClock" : "2.3",
            "cpuCores"  : "4",
            "ram"   : "8",
            "manufacturer" : "Hp",
            "cost" : "600"
        }
    }. 
    3. /users - Create user without laptop. Request Format : application / json
    {
        "name" : "John",
        "email"  : "johndoe@somemail.com"
    }
    4. /users - create the user and associate it with an existing phone.
    {
        "name" : "John",
        "email" : "johndoe@somemail.com",
        "phones" : [
            { "id" : "1"},
            { "id" : "2" }
        ]
    }. Note that you cannot create phones(cascade option not present on @OneToMany), but you can associate a user to the phone which will overwrite the previous user for the phone.
    4. /phones - Create a new Phone. cannot create a new user(no cascade option), but you can associate an existing user to the phone 
    {
        "name" : "iPhone X",
        "price" : "2000",
        "cameraQuality": "13",
        "manufacturer: : "apple",
        "battery" : "3000",
        "user" : {
            "id" : 3
        }
    }
2. READ requests -
GET request:
    1. /laptops/{id} - Get laptop object for provided id
    2. /users/{id} - Get user object with associated laptop and phones for provided user id
    3. /phones/{id} - Get phone objects with provided id

3. UPDATE requests -
PUT request : 
    1. /laptops/{id} - Update info on a laptop whose id is provided on the URL. The modified info is sent in the body of the message
    {
        "cpuClock" : "2.7",
        "cpuCores"  : "4",
        "ram"   : "4",
        "manufacturer" : "apple",
        "cost" : "2000000"
    }
    2. /users/{id} - Update User and optionally laptop and phone associated with him/her for id provided in the url
    {
        "name" : "John",
        "email"  : "johndoe@newmail.com",
        laptop   : {
            "id" : "5"
            "cpuClock" : "3.3",
            "cpuCores"  : "8",
            "ram"   : "16",
            "manufacturer" : "new Laptop",
            "cost" : "1000"
        },
        "phones" : [{"id":1},{"id":2} ]
    }.
    3. /phones/{id} - Update the Phone for given id and optionally modify the user_id associated with phone
     {
        "name" : "iPhone X",
        "price" : "2000",
        "cameraQuality": "13",
        "manufacturer: : "apple",
        "battery" : "3000",
        "user" : {
            "id" : 5
        }
    }
4. DELETE a record - 
 DELETE request:
    1. /laptops/{id} - Delete the entry with id in te url
    2. /users/{id} - delete a user with the id provided in the url
    3. /phones/{id} - delete the phone for the given id

5. LIST all -  
GET request
    1. /laptops - Get/List all the laptops stored in the db
    2. /users - Get/List all the users along with their associated laptops
    3. /phones = Get/List all the phones stores in the database

#

### Note :
### 1. /laptops APIs are defined in Laptops/LaptopController, 
### 2. /users APIs are defined in the Users/UserController
### 3. /phones APIs are defined in the Phones/PhoneController

# 
## Some helpful links:
[SpringBoot + Swagger](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api) 

