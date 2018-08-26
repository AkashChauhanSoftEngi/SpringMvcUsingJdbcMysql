# SpringMvcUsingJdbcMysql

* Spring + JDBC Template + Mysql DB + Java Configuration + MVC + Maven , Example
* JDBC Template example for Spring 4 MVC + JSP View with pure Java Configuration (no XML), using Maven build tool.
* Spring4 + MVC, Integration without using the web.xml and Spring_Servlet.xml file. 
* By using WebMvcConfigurerAdapter class and WebApplicationInitializer interface to replace above files.
* Ref: https://www.codejava.net/frameworks/spring/spring-mvc-with-jdbctemplate-example

> **###1. Technologies**
* Spring 4.0.6.RELEASE
* JDBC Template?
* Maven 3.1
* JSTL 1.2

> **###2. To Run this project locally**
* $ git clone https://github.com/AkashChauhanSoftEngi/SpringMvcUsingJdbcMysql
* $ mvn tomcat7:run

> **###3.  Access** 
* http://localhost:8080/SpringMvcUsingJdbcTemplate/

> **###4. Important points to keep in mind**
```diff
- JDBC throw only few exceptions {SQLException, SQLWarning, DataTruncation, BatchUpdateException}
- JDBC throws only general type of exceptions, it is difficult to find the actual reason behind the exception, sometime.
- JDBC lets you work with much lower level than the presistant freameworks {Hibernate, JPA, iBATIS}
- But Spring JDBC provides more specific type of exceptions, so it is easy to figure out the actual reason.
- One popular exception in Spring JDBC is DataAccessException {Unchecked Exception}
- Unchecked Exception: RuntimeException classes are unchecked exceptions, usually can't be addressed in a catch block
- Throwable Interface->{Errors + Exception{Unchecked[usually no  catch] + Checked[there is a catch]}}
- Spring separates the fixed and variable parts of data access process. templates & callback respectively.
- Fixed parts, template{prepare resources, start transection, commit, rollback, close resource, handling errors}
- callback{Execute in transection, binding parameters, return data}
- templates {ex. JDBCTemplate, HibernateTemplate, JDOTemplate, JpaTemplate}
- To proceed with Spring JDBC, we need to configure datasource to be able to connect to the database
- Java EE Application Servers: WebSphare, JBoss, even Tomcat(Web container) {Suitable for Spring Application}
- If we create datasource using JNDI, this can be managed by outside application, externally {JndiObjectFactoryBean}, good for production
- datasource classes: BasicDataSource, DriverManagerDataSource, SimpleDriverSataSource and SingleConnectionDataSource
- BasicDataSource {support multithreading, good for QA}
- DriverManagerDataSource{Return a new connection everytime}
- SingleConnectionDataSource{Return the same connection everytime, deos not work in multi threaded environment}
- SimpleDriverSataSource{support multithreading}
- EmbeddedDatabaseBuilder{Good for development, save time a lot}
- If not using JDBC template {need to create sql statements, closing the statements and connections, exception handling as extra work need to do}
- If using JDBC template: no need to do all the above mentioned work explicitely
- JDBC Templates
- - JdbcTemplate[Classis one]
- - NamedparameterJdbcTemplate{"values(:name, :password)" in SQL query}
- - SimpleJdbcTemplate[suitable with variable parameter and generic]
- Need to inject DataSource into JdbcTemplate(dataSource)
- RowMapper Interface and mapRow() method main when using JDBCTemplate
```
