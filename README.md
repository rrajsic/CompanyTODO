# CompanyTODO

USAGE: Change URL of website in pom.xml to online database.

This a Java aplication created as a task for internship. 

It is a TODO console app that connects and manages an online database.
Database Tables are: 

EMPLOYEE:
  name,
  last name,
  work place,
  oib (personal identification number)
  .....
  
TASKS:
  title,
  description,
  type (bug or task),
  status (open or closed),
  complexity,
  time spent,
  start date_time,
  end date_time
  .....
  
 
There are 3 types of users: User, Superuser and Admin.
Login is as follows


username:pasword
..................
user      : user
..
superuser : superuser
..
admin     : admin

user can:
 -Print Employees,
 -Print Tasks,
 -Print which Employe works on which task.
 
superuser can:
 -Everything a user can,
 -Insert Employee,
 -Insert Task,
 -Connect Employee with Task,
 -Print reports -> 1. Employee count for job position, 2. Overall time spent by employees, 3. Longest task with status: OPEN
 
admin can:
-Everything a superuser can,
-Update Employee,
-Update Task,
-Delete Employee,
-Delete Task

For accessing database Hibernate is used.
