# Charity Application
> An application connecting donors with charitable organizations.


## Table of Contents
* [General Info](#general-information)
* [Scope of Work on my part](#scope-of-work-on-my-part)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)


## General Information
The application obtains from the user information about the number of bags they want to donate, as well as about the organization they wish to assist.
Users can choose the organization they wish to assist and the categories of items they want to donate.
The application also enables users to register and log into the system.

## Scope of work on my part
The visual layer, frontend were prepared by a third party as part of a project carried out during the Java course at CodersLab.
As part of my portion of the project, I implemented:
- the backend layer of the application, database management,
- Handling and functioning of the donation form,

## Technologies Used
- Java 17
- Java Script
- Spring Boot v 2.6.2.
- Spring Data
- Spring MVC
- JSTL
- Maven
- HTML
- CSS


## Features
List of completed functionalities:
- The homepage, containing a summary of donated gifts and a list of organizations that can be helped.
- A form in which the user can provide information about the number of bags they want to donate, and about the organization they wish to assist.



## Setup
- Clone the repository.
- Install the necessary dependencies listed in the pom.xml file.
- Build and run the application using Maven.
- Access the application through the url: http://localhost:8080/
- Create a database (database name : charity_donation) and add the necessary data to the application.properties file.
- Use the data.sql file to populate the database with the necessary data.


## Project Status
Project is: _in progress_


## Room for Improvement

To do:
- Add a user layer and assign appropriate roles.
- User registration and login.
- Administrator registration and login.
- Administration of foundations by the administrator.
- User management by the administrator.
- Donation management by the administrator.
- Sending email messages to users by the administrator, e.g. with information about the donated donation.
- Confirmation / activation of the user's account via an activation link sent to the email address.
- Handling forgotten passwords.
- Validation of data entered into forms.
