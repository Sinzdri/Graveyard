# RP Character Graveyard
QA DFE Software Skills Bootcamp November 2021

## Index
1. [Brief](#brief)
    + [Project Concept](#project)
2. [Jira Board](#jira)
3. [Risk Assessment](#risk)
4. [Expectations](#expectations)
5. [What went well?](#whatwentwell)
	+ [What didn't go so well?](#whatdidnotgowell)
6. [Possible Improvements](#improvements)
5. [Screenshots](#screenshots)
    + [JUnit Test](#testcov)
9. [Author](#author)
10. [Acknowledgements](#ack)

    
## Brief <a name="brief"></a>
To create a Spring Boot API, with utilisation of supporting tools, methodologies, and technologies, that encapsulates all fundamental and practical modules covered during training.

The requirements for this include:
- Code fully integrated into a Version Control System using the feature-branch model: main/dev/multiple features.
- A project management board with full expansion on user stories, acceptance criteria and tasks needed to complete the project.
- A risk assessment which outlines the issues and risks faced during the project timeframe.
- A relational database, locally or within the Cloud, which is used to persist data for the project. 
- A functional application ‘back-end’, written in a suitable framework of the language covered in training (Java/Spring Boot), which meets the requirements set on your Scrum Kanban board.
- A build (.jar) of the application, including any dependencies it might need, produced using an integrated build tool (Maven).
- A series of API calls designed with postman, used for CRUD functionality. (Create, Read, Update, Delete)
- Fully designed test suites for the application you are creating, including both unit and integration tests.

### Project Concept <a name="project"></a>
My project aims to create a Spring Boot based API for recording dead Role Playing game characters, potentially for deployment as a simple website with some front end development. 

## Jira Board <a name="jira"></a>
I primarily used tasks to organise the project, due to the relatively small scope. Throughout the week several additional tasks were added as required and some tasks proved more time consuming than my initial estimates. [Link to jira board](https://paul-randall.atlassian.net/jira/software/projects/GRAV/boards/1/roadmap)

## Risk Assessment <a name="risk"></a>
A risk assessment is contained in the documents folder. [Link to risk assessment](/documentation/riskassesment.pdf)

## Expectations <a name="expectations"></a>
Going into the project I had a relatively simple concept and a reasonable timeframe to complete it in. I expected to have plenty of time to look into pushing the project beyond the minimum viable product.

## What went well? <a name="whatwentwell"></a>
Meeting the MVP went well, the core functionality had few problems.
### What didn't go so well? <a name="whatdidnotgowell"></a>
I found some of my stretch goals took significantly more time than expected, due to some additions requiring some rework elsewhere in the project to adjust. In the future I would consider incorportating usage of DTOs sooner for example in order to avoid a significant rework of integration tests. In a couple of cases time was wasted working on features that had to be dropped.

## Possible Improvements <a name="improvements"></a>
There is significant room for improvements and additions to the project. Full unit testing with mockito was not fully implemented in the final build, although some tests were made in a feature branch. Similarly seperation of the player's details into a seperate entity with a one to many relationship for multiple classes was worked on for some time in a feature branch but dropped due to escalating complexity with limited time. Similarly a front-end still could be developed for proper deployment.

## Screenshots <a name="screenshots"></a>
Below is a series of screenshots demonstrating the functionality via postman and persistance in the local MySQL server used.
![](documentation/images/createpostman.PNG)
![](documentation/images/deletepostman.PNG)
![](documentation/images/getallpostman.PNG)
![](documentation/images/replacepostman.PNG)
![](documentation/images/getbyidpostman.PNG)
![](documentation/images/getbyracepostman.PNG)
![](documentation/images/mysql.PNG)
![](documentation/images/mysql2.PNG)
### Junit Test <a name="testcov"></a>
Below is the test results with coverage report.
![](documentation/images/tests.PNG)

## Author <a name="author"></a>
Paul Randall

## Acknowledgements <a name="ack"></a>
The trainers at QA and my fellow bootcamp trainee's.
