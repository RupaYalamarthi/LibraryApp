Full stack Java Application(Library)
Rep Link:  https://github.com/RupaYalamarthi/LibraryApp.git 

The basic Library Application for my final case study.
This Application is one stop destination for exploring and selecting the books online.

The navigation bar is present on all pages, I have customized it depending on the user Roles,This 
Application has Spring Security configured for LogIn and Registration pages to Authenticate the users
and it has validation implemented for Username and Password. 

Not all pages will be visible without logging in to their account and Admin will have access to more
pages than User like edit,add and delete.

Index <br>
The Welcome/Home page shows the list of books available in the library.
Search will display all the books in the library or user can also search by book name.
(This is the Read operation).When user click on the book he wants to check out it redirects to Book 
details page where he will be able to add it to the cart.<br>

Cart <br>
Once User is done adding 
books to the cart he clicks on the checkout button to finish the transaction.

Admin 🔒<br>
An Admin page has all Create, Edit and Delete books functionalities available and also can be able
to do new user Registrations and Edit their details.

(TODO) Includes a Reminder section when a user logged in showing his due date to return his books.
(TODO) Includes a "Thank You" section for people and resources of help and support.
(TODO) Also features the external links to various related sites.


Thanks for reading!
