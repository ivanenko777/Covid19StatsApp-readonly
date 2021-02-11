# Covid 19 Stats App

## Task

Create an application which is showing the COVID-19 statistics (cases and death) by country. The application backend should read the data from this endpoint https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/ ([more information here](https://www.ecdc.europa.eu/en/publications-data/data-national-14-day-notification-rate-covid-19)). Data should be read from external source only once when application is starting. The COVID-19 data should be kept in memory. You need to create rest api endpoint which provides covid-19 case and death data by country. The country should be passed as a parameter to the rest api. The web application should display the chart with two lines (cases and deaths) by week. In web application it should be possible to select the country from the dropdown list. After the country is selected the data in the chart should be refreshed. 
Technical requirements: 
1.	Backend should be created with node.js or springboot 
2.	Front end needs to be created with angular.js or react.js 
3.	Instructions how to build and run the application should be written 
4.	Source code should be placed in github 
5.	Docker image creation of application is optional


## Technologies and libraries
* Java 11 LTS
* Spring Boot 2.4.2
* Spring Framework 5.3.3
* h2 1.4.200
* NodeJs 14.15.5 LTS
* react 17.0.1
* react-dom 17.0.1
* react-scripts 4.0.2
* web-vitals 1.1.0
* react-chartjs-2 2.11.1
* chart.js 2.9.4
* lodash 4.17.20

## Requirements

**This guide was tested on Windows 10**

On your computer must be installed:

- Git [installation instuctions](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- Java 11 LTS [installation instuctions](https://www.oracle.com/java/technologies/javase-downloads.html)
- Maven 3.6.3 [installation instuctions](http://maven.apache.org/install.html)
- NodeJs 14.15.5 [installation instuctions](https://nodejs.org/en/download/)

## Build and run project

1. Clone repository

```
git clone https://github.com/ivanevla/Covid19App-JAVA_SPRING_REACT.git
```

2. Go to <code>Covid19App-JAVA_SPRING_REACT</code> folder

3. Run the following command in a terminal window to build and run backend

```powershell
cd .\backend\
.\mvnw spring-boot:run
```

4. You can check by running the following command in a new terminal window (shown with its output):

```powershell
> curl http://localhost:8080/api/stats/countries

StatusCode        : 200
StatusDescription :
Content           : [{"id":1,"name":"Afghanistan"},{"id":118,"name":"Africa (total)"},{"id":235,"name":"Albania"},{"id":334,"name":"Algeria"},{"id":451,"name":"America (total)"},{"id":568,"name":"Andorra"},{"id":665,"nam..."}]
RawContent        : HTTP/1.1 200
                    Vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers
                    Transfer-Encoding: chunked
                    Content-Type: application/json
                    Date: Thu, 11 Feb 2021 19:25:39 GMT

                    [{"id":1,"n..."}]
Forms             : {}
Headers           : {[Vary, Origin,Access-Control-Request-Method,Access-Control-Request-Headers], [Transfer-Encoding, chunked], [Content-Type, application/json], [Date, Thu, 1 Feb 2021 19:25:39 GMT]}
Images            : {}
InputFields       : {}
Links             : {}
ParsedHtml        : mshtml.HTMLDocumentClass
RawContentLength  : 7007
```

5. Run the following command in a new terminal window to build and run frontend

```powershell
cd .\frontend\
npm run build
serve -s build
```

6. Open [http://localhost:5000](http://localhost:5000) in browser.

## Try it with Docker

You need Docker installed

```
# Run app:
docker-compose up -d
```

Open [http://localhost:3000](http://localhost:3000) in browser.

```
# Stop app:
docker-compose down
```
