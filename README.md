# reading-log
project for LC liftoff 2020

### Overview
For my LaunchCode Liftoff 2020 Project, I plan to create a reading log.  I intend it to be simple enough to be used 
by kids for summer reading but have enough features that adults could enjoy using it, too. 
I plan to have accounts for individual users.  I plan to query available JSON data or an API (
like https://developers.google.com/books/docs/v1/getting_started) so users 
can search for a book and then select the picture of the book cover that matches exactly what version
of the book they are reading.  Users can log reading progress by time, pagecount, or both.  
Pulling from JSON/API will allow the app 
to display selected info about the book in addition to just the title.  
Stretch goal(s) will be to allow parents 
to set up accounts for and monitor kids use of the app, and award "prizes" or points based on 
reading goals including pages, minutes, book difficulty, etc.  possibly allow friends/parents to 
assign or suggest books to other users.  I got the idea from using both paper and online reading logs.
the paper logs are cumbersome, and the online logs don't have either the "select the matching cover page"
or "give me lots of other info" features.
### Features
User login: Users will be able to create accounts and log in to the application. 
Search: Users will be able to search by title or author for books.
Selection: Users will be able to select from multiple book covers for the specific edition 
that matches what they are reading.
Logging: Users will be able to log their reading activity.  Activity can be logged as either 
hours, or pages, or both.
Comments: Users will be able to log comments on the books they've read.
### Technologies
I currently plan to emulate the tech we were using at the end of LC101 unit 2.
Specifically:
Java
Spring Boot
MySQL
Hibernate
Thymeleaf templates
### What I'll Have to Learn
Interface with book API, probably Google Books (https://developers.google.com/books/docs/v1/getting_started)
