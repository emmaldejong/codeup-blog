Spring

In this section we will be learning how to work with the Spring framework. Spring is an open source framework for building Java applications. We will primarily be looking at the web portion of the framework. We will be using Spring Boot to get a quicker start building a spring application.

Project Setup

Throughout the course of this section we will be building a blogging application.

Our application will eventually have the following features:

Any user can view the blog posts
Users can create an account
Logged in users can create posts
Logged in users can edit and delete their own posts
Building this application will allow you to learn how spring handles basic CRUD operations, as well as user authentication. In addition, you can use your blog as a personal site to show off your Java chops!

IntelliJ Setup

IntelliJ has built-in integration with the spring initializr, which we will be using to bootstrap our application.

1. Create a new Project in IntelliJ.

2. For the project type, select "Spring Initializr"

- Make sure "Maven Project" is selected (it should be by default).
- For the group and package name enter com.codeup.
- For the "Artifact" and "Name" fields enter a name for your project without spaces.
- Enter a brief description of your project in the "Description" field.

3. Next we will be prompted for the dependencies of our project.

Here we will select any dependencies that our project will have. This is just a shortcut for adding spring-boot-starter <dependency> elements to our pom.xml. If you know what pieces of the spring framework you are going to use, you would select them here.

For now, just check "Web" -> "Web".

4. Now we will be prompted for a project name and location. Choose whatever name you prefer, this is just how we will refer to the project on your computer.

5. Add the following line to your .gitignore file
src/main/resources/application.properties

6. Create an empty file at src/main/resources/example.properties and add it to Git. We'll use this file to communicate to other developers what are the settings needed to run this application, without sharing our passwords or API keys in Github.

7. Create a new repository locally and on github for this project.