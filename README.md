# 📖 yourStories 📖
***Book Tracking Application - Project Proposal***

## A Brief Overview of the Application

For the CPSC 210 project, I propose a book tracking application. This application would allow
users to input information about the books they have been reading to keep 
track of them. Possible features and functionality could include the book object having a title, 
author name, genre, number of pages, year read, and the user's rating. The application would keep track of all the books 
the user has input in a list of books that could be accessed as the user's collection.

***Who will use this application?***

This application would be open for all, though it would be primarily targeted toward individuals who 
like to read, particularly enough so that they would want to keep track of the books they have read.

***Why is this of interest to me?***

The idea behind this project is meaningful to me because I have always been an avid reader from the moment I learned 
how to read. I am thrilled at the possibility of making my own application that even I could use to input the books 
I have been reading. While there are a few book tracking applications currently out there, I hope to add my own flare 
to this personal project and potentially consider features other applications have not thought of yet.

## User Stories

***Console Based***
- As a user, I want to be able to add a book to a collection of books and specify the name of the book, the author,
the number of pages, the genre, the year I read it,  and the rating from 1 to 5 with 
increments of 0.25
- As a user, I want to be able to view the titles of my collection of books read 
- As a user, I want to be able to sort the order of books from the most recent to the least recent or 
highest rating to the lowest rating
- As a user, I want to be able to filter my collection of books by genre or author and view
the resulting titles after filtering
- As a user, I want to be able to delete a book from the collection of books
- As a user, I want to be able to select a singular book in the collection and view the details specified
- As a user, I want to be provided the option to save my book collection if I choose to
- As a user, I want to be able to reload my book collection when I reopen the application

***GUI Based***
- As a user, I want to be able to add a book to my collection in the Graphical User Interface
and click a button to display my entire book collection
- As a user, I want to be provided the option to save/reload my book collection by clicking on a button in the GUI
- As a user, I want to be able to sort my book collection by year or by rating in descending order,
and view the newly ordered list of books

## Instructions for Grader
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by running the 
Graphical Main class and clicking the "Add to your Collection" button. You will be prompted to a new
page in which you will enter the parameters required for a new Book object
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by running the 
Graphical Main class and clicking the "Add to your Collection" button. If you choose not to reload
a previous collection, add a new book or 2, then click the "List books" or "Sort books" buttons.
List books will list the books in your collection in the order added. Sort books will take you to a new 
page in which you can choose to sort your books in descending order by year read or by rating. The application will then
list the newly sorted books.
- You can locate my visual component by running the Graphical Main class and clicking the "Add to your Collection" 
button. Add a new book by filling in each text field. A JOptionPane with message dialog will show.
Within it is a custom image I made and added to the application.
- You can save the state of my application by running the Graphical Main class and clicking the "Save your Collection"
button
- You can reload the state of my application by running the Graphical Main class and clicking the "Reload Collection"
button. Upon clicking, the application will list the books you reloaded

## Citations
User interface code influenced by the TellerApp: 
https://github.students.cs.ubc.ca/CPSC210/TellerApp

Data persistence code heavily influenced by the JsonSerializationDemo: 
https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

GUI code heavily influenced by the Stack Overflow sample code:
https://stackoverflow.com/questions/6578205/swing-jlabel-text-change-on-the-running-application
https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon