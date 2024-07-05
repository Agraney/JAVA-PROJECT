# LIBRARY SYSTEM

## INTRODUCTION

1. This code is a pseudo example of how a real-life Library system works and has two major options: entering as a librarian or as a member.
2. Assumptions:
   - If a book is borrowed, the librarian cannot remove it.
   - Before removing a member, they must return all books and pay fines.
   - Members are identified uniquely by their phone number.
3. The code utilizes major Java concepts taught in class.

## FEATURES

### Librarian Actions:

1. Register new members.
2. Remove members (conditions apply).
3. Add books to the library.
4. Remove books from the library.
5. View all members with borrowed books and fines.
6. View all books in the library.
7. Return to main menu.

### Member Actions:

1. List available books.
2. List owned books.
3. Issue books (conditions apply).
4. Return books (conditions apply).
5. Pay fines.
6. Return to main menu.

## USAGE

1. Upon running the code, it prompts for librarian or member input, or to exit.
2. Librarian Interface:
   - Options to manage members, books, and view details.
3. Member Interface:
   - Options to view and borrow books, manage fines, etc.
4. Error handling for incorrect inputs and various scenarios.

## IMPLEMENTATION DETAILS

1. Used BufferedReader for input handling.
2. Handled exceptions with IOException.
3. Used ArrayList for dynamic data management.
4. Utilized LocalDateTime for time calculations (fines, due dates).
5. Error handling for input validation and logic flow.
6. Detailed comments and documentation in the code.

