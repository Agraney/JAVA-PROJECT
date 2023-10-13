import java.time.LocalDateTime;

public class Book {
    private String bookname;
    private String authorname;
    private int bookld;
    private int totalcopies;
    private LocalDateTime dd;
    

    public Book(String book, String auth, int iduo) {
        this.bookname = book;
        this.authorname = auth;
        this.totalcopies = 1;
        this.bookld = iduo;
    }

    public String getauth() {
        return authorname;
    }

    public int getidbk() {
        return bookld;
    }

    public String getname1() {
        return bookname;
    }

    public LocalDateTime getDueDate() {
        return dd;
    }

    public void setid(int id) {
        this.bookld = id;

    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dd = dueDate;
    }

    public int getid() {
        return bookld;

    }

    public void increasecopies() {
        totalcopies++;
    }

    public int tt() {
        return totalcopies;
    }

    public void decreasecopies() {
        if (totalcopies > 0) {
            totalcopies--;

        } else {
            System.out.println("No copies left");
        }
    }
}
