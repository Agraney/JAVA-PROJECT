import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Member {
    private String name;
    private int age;
    private long contact_id;
    private double balance;
    private ArrayList<Book> borrowedbooks = new ArrayList<>();

    public Member(String n, int age, long contact) {
        this.name = n;
        this.age = age;
        this.contact_id = contact;
        this.balance = 0;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setage(int age) {
        this.age = age;

    }

    public void setcontact(int contact) {
        this.contact_id = contact;
    }

    public int returnsize() {
        return borrowedbooks.size();
    }

    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }

    public long getcontact() {
        return contact_id;
    }

    public ArrayList<Book> getsbk() {
        return borrowedbooks;
    }

    public Book getbook(int id) {
        for (int i = 0; i < borrowedbooks.size(); i++) {
            if (borrowedbooks.get(i).getidbk() == id) {
                return borrowedbooks.get(i);
            }
        }
        return null;
    }

    public double currentfine() {
        for (int i = 0; i < borrowedbooks.size(); i++) {
            LocalDateTime currentDate = LocalDateTime.now();
            LocalDateTime DUEDTR = borrowedbooks.get(i).getDueDate();
            long daysLate = Math.max(0, ChronoUnit.SECONDS.between(DUEDTR, currentDate) - 10);
            double fine = daysLate * 3;
            balance += fine;
        }
        return balance;
    }

    public double getbalance() {
        return balance;
    }

    public ArrayList<Book> getavailablebooks(ArrayList<Book> bo) {// This line needs to be converted into a list in Main
                                                                  // Java file inorder to represent the whole Books to
                                                                  // the librarian.
        ArrayList<Book> green = new ArrayList<>();
        for (int i = 0; i < bo.size(); i++) {
            if (bo.get(i).tt() != 0) {
                green.add(bo.get(i));
            } else {
                continue;
            }
        }
        return green;
    }

    public ArrayList<Book> getbooks() { // This line needs to be converted into a list in Main Java file inorder to
                                        // represent the whole Books to the librarian.
        return borrowedbooks;

    }

    public void balancechange(double amount) {
        balance += amount;
    }

    public boolean canborrowbook() {
        if (borrowedbooks.size() < 2) {
            return true;
        } else {
            return false;
        }
    }

    public void returnbook(Book bst) {
        borrowedbooks.remove(bst);
        bst.increasecopies();
    }

    public void Deletebook(Book by) {
        borrowedbooks.remove(by);
        by.increasecopies();
    }

    public void Borowbook(Book bot) {
        borrowedbooks.add(bot);
        bot.decreasecopies();
    }

    public void payfine(double x) {
        System.out.println("You had a total fine of Rs " + balance + ". It has been paid successfully.");
        balance = 0;
    }

    public void issuebook(Book boo) {
        if (boo.tt() != 0 && borrowedbooks.size() == 0 && getbalance() == 0) {
            Borowbook(boo);
            LocalDateTime dueDate = LocalDateTime.now().plus(10, ChronoUnit.SECONDS);
            boo.setDueDate(dueDate);
            System.out.println("Thank you for borrowing the book");
            return;
        } else if (boo.tt() != 0 && borrowedbooks.size() == 1) {
            LocalDateTime drt = borrowedbooks.get(0).getDueDate();
            LocalDateTime currentDate = LocalDateTime.now();
            long daysLate = Math.max(0, ChronoUnit.SECONDS.between(drt, currentDate) - 10);
            double fine = daysLate * 3;
            if (fine == 0) {
                Borowbook(boo);
                LocalDateTime dueDate = LocalDateTime.now().plus(10, ChronoUnit.SECONDS);
                boo.setDueDate(dueDate);
                System.out.println("Thank you for borrowing the book");
                return;
            } else {
                System.out.println("You have to pay the fine first");
                return;
            }
        } else if (getbalance() != 0 && boo.tt() != 0 && canborrowbook() == true) {
            System.out.println("Pay fine of " + getbalance());
            return;
        } else if (borrowedbooks.size() == 2) {
            System.out.println("Sorry Can't issue book as limit already reached.");
        } else {
            System.out.println("Cannot Issue Book due to some unforsaken circumstances.");
        }
    }

    static Book findbook(int id) {
        for (int i = 0; i < Librarian.bookie.size(); i++) {
            if (Librarian.bookie.get(i).getidbk() == id) {
                return Librarian.bookie.get(i);
            } else {
                continue;
            }
        }
        return null;
    }

    public int bookinbag(int id) {
        for (int i = 0; i < borrowedbooks.size(); i++) {
            if (borrowedbooks.get(i).getidbk() == id) {
                return 1;
            }
        }
        return 0;
    }

    public void returnbook(int id) {
        if (bookinbag(id) == 1) {
            LocalDateTime dueDate = getbook(id).getDueDate();
            LocalDateTime currentDate = LocalDateTime.now();
            long daysLate = Math.max(0, ChronoUnit.SECONDS.between(dueDate, currentDate) - 10);
            double fine = daysLate * 3;
            Deletebook(getbook(id));
            balancechange(fine);
            System.out.println("Book ID:" + id + " successfully returned. " + fine
                    + " Ruppess has been charged for a delay of " + daysLate);
        } else {
            System.out.println("Entered Book is not in your borrowed books");
        }
    }
}
