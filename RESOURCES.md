# RESOURCES — Session 2 (SQLite + Repository + Validation)

Odkazy ke každému tématu, ze kterých si můžeš dočíst víc / further reading for each topic.
Primárně oficiální dokumentace. *(CZ: čti v pořadí kroků 1–7, jak jdou ve workshopu.)*

---

## Základ / Foundation
- **Spring Boot — reference docs:** https://docs.spring.io/spring-boot/3.3/
- **Kotlin + Spring Boot (getting started):** https://kotlinlang.org/docs/jvm-get-started-spring-boot.html
- **Spring Framework — Kotlin support:** https://docs.spring.io/spring-framework/reference/languages/kotlin.html
- **Dependency Injection / IoC (proč konstruktorové injektování):** https://docs.spring.io/spring-framework/reference/core/beans.html
- **REST — HTTP metody:** https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods · **stavové kódy:** https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
- **Maven — getting started:** https://maven.apache.org/guides/getting-started/
- **Session 1 (předchozí workshop):** https://github.com/UnityInFlow/expense-tracker-workshop-01

---

## Step 1 — SQLite setup & schema
- **SQLite — dokumentace:** https://www.sqlite.org/docs.html
- **SQLite — CREATE TABLE / typy:** https://www.sqlite.org/lang_createtable.html · https://www.sqlite.org/datatype3.html
- **sqlite-jdbc (Xerial) — driver, co používáme:** https://github.com/xerial/sqlite-jdbc
- **Spring Boot — inicializace DB pomocí `schema.sql`:** https://docs.spring.io/spring-boot/how-to/data-initialization.html

## Step 2 & 3 — Repository (JdbcTemplate, CRUD)
- **Spring — Data Access with JDBC (`JdbcTemplate`):** https://docs.spring.io/spring-framework/reference/data-access/jdbc.html
- **Spring guide — Accessing Relational Data using JDBC:** https://spring.io/guides/gs/relational-data-access/
- **`JdbcTemplate` — javadoc (API):** https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
- **Repository pattern (vzor):** https://martinfowler.com/eaaCatalog/repository.html

## Step 4 — Service → Repository (vrstvená architektura)
- **Spring — Beans & Dependency Injection:** https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html
- **Layered architecture (controller / service / repository) — přehled:** https://www.baeldung.com/spring-boot-3-tier-architecture-example

## Step 5 — OpenAPI / Swagger
- **springdoc-openapi (co generuje Swagger UI):** https://springdoc.org/
- **OpenAPI Specification:** https://swagger.io/specification/
- **Swagger UI:** https://swagger.io/tools/swagger-ui/

## Step 6 (BONUS) — Error handling (`@RestControllerAdvice`)
- **Spring — `@ExceptionHandler` / controller advice:** https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-exceptionhandler.html
- **Baeldung — Error Handling for REST with Spring:** https://www.baeldung.com/exception-handling-for-rest-with-spring
- **Problem Details (RFC 9457) — moderní formát chyb:** https://www.rfc-editor.org/rfc/rfc9457.html

---

## Bonus / kam dál
- **Testování Spring Boot aplikací:** https://docs.spring.io/spring-boot/reference/testing/index.html
- **Spring Data JPA (až přerosteš `JdbcTemplate`):** https://spring.io/projects/spring-data-jpa
- **Twelve-Factor App (config, logy, …):** https://12factor.net/
