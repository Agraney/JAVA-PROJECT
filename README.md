LIBRARY SYSTEM

INTRODUCTION:-
1)This code is a pseudo example of how a real life Library system works and has two major options one is by entering as a librarian and the other is entering as a member.
2)In my code I have assumed somethings that I would like to put down in the begining only as it was not clearly mentioned in the PDF provided:-
2.1)My first assumption is that if a book has been borrowed by any member then the librarian cannot remove that particular book with that ID.
2.2)My second assumption is that if a member borrows any book and the librarian decides to remove that member then, they first have to return that book and as well pay the fine before the librarian will be able to remove the member from the library.
2.3)My third and final assumption is that the Members will have a unique ID which is there phone number only as in real life cases we will not find anyone with same phone number.
3)The code is written in JAVA and utilizes many major concepts of JAVA that were taught in class.
4)The given code is explained below that how to run and go around it.

FEATURES:-
Librarian Actions:
1)Register new members.
2)Remove members.
3)Add books to the library.
4)Remove books from the library.
5)View all members along with their borrowed books and fines.
6)View all books in the Library.

Member Actions:
1)List available books.
2)List owned books.
3)Issue books.
4)Return books.
5)Pay fines.

USAGE:-
1)As soon as you run the code in your complier it welcomes you and asks for an input inorder to know if you are entering as a Librarian or a Member or are about to exit the whole system.

2)If you enter as a Librarian then you will be given 7 options which are mentioned above inthe features table with one option left named BACK which allows you to again return to the main page or the initial page.
2.1)The first operation asks for Name,Age and Contact Number of a Member and then allows the Librarian to enter it as a new entry in the Library Database. If the given age or Contact is entered incorrectly then an error message pops up and takes the Librarian back to the Librarian Mode Interface. In my code I have used CONTACT NUMBER as an source for ID of the members of my Library as each contact is individual and unique.
2.2)The second option allows the librarian to remove a member from the library but only on the condition that the Member doesn't occupy any books belonging to the library or that he has any fine to pay (I have assumed it in this way because if the Member is not present in fron of the Librarian at the time when they are removing the member then the book and the fine will be Lost and not possible to fetch hence such steps were taken).
2.3)The Third option allows the Librarian to enter any book given its Name,Author Name,Total Copies. As it was not clearly mentioned about what to do with the ID of the books I have initialized a Number Statically and used a loop to give ID to each book but it comes with a drawback about which I will be discussing ahead.
2.4)The Forth option allows the Librarian to Delete any book from the Library given it's ID but in my code I have assumed that if I delete any book with ID x then no book in the future that will be added in the Library will be given number x as it will be skipped by my method as I explained above. But the code works greatly and properly does its assigned function.
2.5)The fifth option allows the Librarian to view all the members with their information as well as the current fine on them and the borrowed books that they have with them.
2.6)The sixth option allows the Librarian to view all the books in the Library that have been added previously.

3)If you enter as a member then it will ask for your Name and Contact Number(which I have used as ID) and will find you in the Library database if you are registered with the Library then it will Welcome you and will give you 6 options which are mentioned above in the Feature section along with a option to re-enter into the main interface or to go back. Incase you are not registered then it will show error.
3.1)The first option allows the member to see all those books which are available for them to borrow so it won't include those books which are borrowed by some other member or are delelted by the Librarian.
3.2)The second option allows the member to see all the books that the member has borrowed from the library which has limti of 2 books at a time.
3.3)The third option allows the member to get a book issued but under some specific conditions:-
3.3.1)If the member does't have any fine or hasn't borrowed any book or the book is available then the member can easily get the book issued.
3.3.2)If the member has already borrowed 2 books or the book he is asking for is not with the library then it gives an error message telling the member that he can borrow the book.
3.3.3)If the person has borrowed only 1 book but has a fine on it then also he won't be able to borrow another book and will be displayed a message telling him to pay the fine first and he can do that by first returning the book.
3.4)The forth option allows the member to return the borrowed book and also mentions the fine to the member that he has to pay in order to issue another book in future.
3.5)The fifth option allows the Member to pay the fine and resets the balance attribute of the member to 0 which insures that he can again get a book issued from the Library.

4)In my code I have tried to handle as many errors as possible if asked for int given a string or if asking for a book to be issued or returned which was never in the Library or the members list of borrowed books.

5)Used Bufferreader to take all input from the user, used IOException to solve any encounter with I/O related problems or problems with functions provided by the Bufferreader.Used Array List in majority of the code as its inbuild add and remove helps a lot while working on such an assignment,Used LocalDateTime to calculate current time and due date time in seconds which helped me calculating the difference in days as put up a fine,Chronotime allowed to use the standard time output differences inorder to calculate the final fine.

6)In case when the Librarian decides to view member it displays the total fine or the sum of fine if the member has borrowed multiple books.

7)In case of wrong input in multiple cases proper measures have been taken to counter them.

