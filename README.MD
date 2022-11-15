# Test project for hibernate search
Demonstration of usage of hibernate search
https://docs.jboss.org/hibernate/stable/search/reference/en-US/html_single/

## Use cases:
* A book in the repository by default cannot be found by searching for it's isbn by hibernate search
* A book in the repository can be found by hibernate search AFTER triggering initial indexing
* A book added to the repository by the POST endpoint can be searched AFTER initial indexing was already executed

## Note:
Initial indexing needs to be executed only ONCE during the lifetime of the application.

https://docs.jboss.org/hibernate/stable/search/reference/en-US/html_single/#getting-started-initialization-indexing

## Functionalities:

* GET http://localhost:8080/books - Get all books without search
* GET http://localhost:8080/books/isbn/9780544003415 - get book by searching for isbn
* GET http://localhost:8080/initialIndexing - do initial indexing
* POST http://localhost:8080/book - add new book