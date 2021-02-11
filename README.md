# Covid 19 Stats App

## Task

...

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
