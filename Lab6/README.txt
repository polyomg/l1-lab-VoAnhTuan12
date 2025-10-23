Lab6 - JPARepository #1 (Bài 1-4)
Project generated for user.

How to use:
1. Create MySQL database using src/main/resources/WebShop.sql (run in MySQL client).
2. In application.properties the DB is configured as:
   spring.datasource.username=root
   spring.datasource.password=123
   database: WebShop at localhost:3306

3. Open project in IntelliJ, enable Annotation Processing (for Lombok):
   File -> Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors -> Enable

4. Load Maven changes, then run Lab6Application.

Endpoints:
- Category CRUD UI: http://localhost:8080/category/index
- Product sort UI: http://localhost:8080/product/sort
- Product pagination UI: http://localhost:8080/product/page
