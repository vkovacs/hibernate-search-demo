# Test project for hibernate search

## Functionalities:

* GET http://localhost:8080/books - Get all books without search
* GET http://localhost:8080/books/isbn/9780544003415 - get book by searching for isbn
* GET http://localhost:8080/initialIndexing - do initial indexing
* POST localhost:8080/book - add new book