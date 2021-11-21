# 🗃MongoDB-Java-driver🗂

Introduce how to connect MongoDB to the application in Java.

## Introduction
This is part of a MEAN-stack project. We will go through this step by step.
To begin with, we will take a look at the database management system (DBMS) and use MongoDB as a tool.
</br>MongoDB is the 'M' of MEAN, which has become a standard solution to implement full stack web applications.

## [What is Mongo DB?](https://searchdatamanagement.techtarget.com/definition/MongoDB)
MongoDB is an open source NoSQL database management program.
There are two types of database, SQL and NoSQL. </br>
Simply speaking, the main difference between them is that SQL stores data in a table format whereas NoSQL stores data as documents in each collection.
Because there is no strict schema in MongoDB (NoSQL), it gives Mongo DB a huge adventage.
If you want faster performance with unstructured data, go for Mongo DB! </br>
You will find more info here: https://www.mongodb.com/

The tool I downloaded and used through out the project is MongoDB compass. It's free to use and you can install it in your local machine.
Please have a look: https://www.mongodb.com/products/compass

## CRUD pattern?
You probably heard CRUD pattern many many times if you ever studied implementation of DBMS. 
</br>It's important to check if the control class funfills the CRUD pattern entirely.
Then what is CRUD pattern and why is it so crucial?
CRUD stands for Create, Read, Update and Delete.
They are the 4 main functionalities dealing with the data in the database.
Imagine a user can't delete a document or update it. You probably don't want to face this kind of problems as a developer.
In the project folder, you will find an interface of a controller class that implements CRUD pattern. </br>
Make sure you also have these methods properly in your controller class.

## Senario of the project
Let's say we have a hypothetical company and we can access the data of all employees. </br>
Each employee gets two types of payments. One is a regular salary and the other is bonus payment calculated based on their performance.
Our goal of this project is to implement DBMS based on this senario in Java.
We will need a database called 'SalesMenDB'. This data base contains two collections, each is called 'generalData' and 'EvaluationRecords', respectably.
'generalData' has firstname, lastname and sid of an emplyee.
'EvaluationRecords' can be divided into two parts. 'orders evaluation' contains the name of products, clients of each products and their rating and number of sold items.
'social performance evaluation' has 6 criteria with a received value for each. I will visualy demonstrate the relationships between the data later.


## Code Structure
Let's talk about the code structure. 
There are 4 packages in the main java folder.
'contract' has the interface of the control class. It has CRUD methods for both general data and evaluation records of salesmen. 
</br>
'controller' package has the main controller class that provides a basic user interface. Users are able to try and execute methods in a repository class.
</br>
'data' has all of the data classes for salesmen. The main two classes are general data class and evaluation record class.
</br>
'repository' package is for the actual implementation of the interface of a control class.
</br>
There is also a test package to test the CRUD methods in the repo class. I tested general data part and evaluation record part separately.

## I think we are ready to start!
The idea of this project is from https://github.com/aldaGit/integrationArch









