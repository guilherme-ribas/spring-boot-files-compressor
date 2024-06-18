# Spring Boot File Zipper

This project is a simple Spring Boot application that provides an endpoint to zip multiple files into a single .zip file.

## Prerequisites

- Java 17 or higher
- Maven

## Getting Started

### Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/seu-usuario/spring-boot-file-zipper.git
cd spring-boot-file-zipper
```

### Build and Run the Application
You can build and run the application using Maven:

```bash
mvn spring-boot:run
```

Alternatively, you can build a JAR file and run it:

```bash
mvn clean package
java -jar target/spring-boot-file-zipper-0.0.1-SNAPSHOT.jar
```

The application will start on port 8080 by default.

### Usage
Endpoint
```
POST /api/zipFiles
```
This endpoint accepts multipart/form-data requests with files to be zipped into a single .zip file.

### Request Parameters
files: The files to be zipped. You can add multiple files using the same key.

### Example
To zip two files using cURL:

```bash
curl -X POST -F "files=@/path/to/file1.txt" -F "files=@/path/to/file2.txt" http://localhost:8080/api/zipFiles --output files.zip
````
### Response
The response will be a .zip file containing all the uploaded files.

### Dependencies
Spring Boot Starter Web
These dependencies are managed via Maven and are included in the pom.xml file.

