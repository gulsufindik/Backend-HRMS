  <h2 align="center">HR Management System</h2>

### About This Project

This is a human resources application that includes four distinct roles: admin, company manager, employee, and guest. Each role is equipped with its own dashboard, profile, and pages tailored to their specific responsibilities.

When a company manager registers, their registration is subject to approval by the admin. Once approved, the company manager gains access to the system and can subsequently add employees to the system.

The Employee profile page encompasses personal information, salary details, and shift schedules. The employee dashboard also provides information about public holidays and details about the company they are employed by.

Employees have the option to submit comments regarding their company, but these comments will only be published after receiving approval from the admin.

For company managers, there is a dedicated page with comprehensive information about their company's financial status, including income, expenses, and profit and loss data.

Guests who register with the application can access information and comments pertaining to all companies that are registered within the application.

### Usage
You will need to have Gradle and JDK 8 or higher. The recommended way to run the sample applications is with IDEs like IntelliJ IDEA or Eclipse. You will also need to run MongoDB, PostgreSQL and RabbitMQ in Docker container, so you must have Docker installed on your local machine.

### Scripts
- PostgreSQL
```
docker run -d --name some-postgres -e POSTGRES_PASSWORD=secret -e PGDATA=/var/lib/postgresql/data/pgdata -v /custom/mount:/var/lib/postgresql/data -p 5432:5432 postgres
```
- pgAdmin
```
https://www.pgadmin.org/download
```
- RabbitMQ
```
docker run -d name some-rabbit -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=secret -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```
