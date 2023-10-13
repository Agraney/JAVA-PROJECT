import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(read);

        while (true) {
            try {
                System.out.println("Library Portal Intialised");
                System.out.println("----------");
                System.out.println("1. Enter as a librarian\n2. Enter as a member\n3. Exit");
                System.out.println("----------");
                int n = Integer.parseInt(br.readLine());
                if (n == 1) {
                    System.out.println("----------");
                    System.out.println("You have Entered as a Librarian");
                    Librarian obj = new Librarian();
                    while (true) {
                        try {
                            System.out.println("----------");
                            System.out.println(
                                    "1. Register a member\n2. Remove a member\n3. Add a book\n4. Remove a book\n5. View all members along with their books and fine to be paid\n6. View all books\n7. Back\n");
                            System.out.println("----------");
                            int v = Integer.parseInt(br.readLine());
                            if (v == 1) {
                                System.out.println("----------");
                                System.out.print("Name: ");
                                String hy = br.readLine();
                                try {
                                    System.out.print("Age: ");
                                    int age = Integer.parseInt(br.readLine());
                                    System.out.print("Phone No.: ");
                                    Long cont = Long.parseLong(br.readLine());
                                    System.out.println("----------");
                                    System.out.println("NAME: " + hy + "\nAGE: " + age + "\nCONTACT NUMBER: " + cont);
                                    obj.addmember(hy, age, cont);
                                } catch (Exception ex) {
                                    System.out.println("----------");
                                    System.out.println("You have entered wrong type of Input.");
                                }

                            } else if (v == 2) {
                                System.out.println("----------");
                                System.out.print("ENTER MEMBER ID TO BE REMOVED: ");
                                try {
                                    Long contr = Long.parseLong(br.readLine());
                                    System.out.println("----------");
                                    obj.removemember(contr);
                                } catch (Exception ert) {
                                    System.out.println("You have entered wrong type of Input.");
                                }

                            } else if (v == 3) {
                                System.out.println("----------");
                                System.out.print("Book Name: ");
                                String bk = br.readLine();
                                System.out.print("Author Name: ");
                                String ak = br.readLine();
                                System.out.print("No. of Copies: ");
                                try {
                                    int idf = Integer.parseInt(br.readLine());
                                    System.out.println("----------");
                                    System.out.println(
                                            "BOOK TITLE: " + bk + "\nAUTHOR: " + ak + "\nTOTAL COPIES: " + idf);
                                    obj.addbooks(bk, ak, idf);
                                } catch (Exception ghy) {
                                    System.out.println("----------");
                                    System.out.println("You have enterned wrong type of Input.");
                                }

                            } else if (v == 4) {
                                System.out.println("----------");
                                System.out.print("Enter Book ID: ");
                                try {
                                    int truck = Integer.parseInt(br.readLine());
                                    System.out.println("----------");
                                    obj.removebook(truck);
                                } catch (Exception kol) {
                                    System.out.println("You have entered wrong type of Input.");
                                }

                            } else if (v == 5) {
                                System.out.println("----------");
                                ArrayList<Member> kilo = new ArrayList<>();
                                kilo.addAll(Librarian.viewmember());
                                for (int i = 0; i < kilo.size(); i++) {
                                    Member m = kilo.get(i);
                                    ArrayList<Book> jimbe = new ArrayList<>();
                                    String result = " ";
                                    jimbe.addAll(m.getsbk());
                                    for (int h = 0; h < jimbe.size(); h++) {
                                        result += " Book Name: " + jimbe.get(h).getname1() + " Book ID:  "
                                                + jimbe.get(h).getid();

                                    }
                                    System.out.println("MEMBER NAME: " + m.getname() + " AGE: " + m.getage()
                                            + " CONTACT: "
                                            + m.getcontact() + " BALANCE: " + m.currentfine() + " Borrowed Books: "
                                            + result);
                                }
                            } else if (v == 6) {
                                System.out.println("----------");
                                ArrayList<Book> kimbo = new ArrayList<>();
                                kimbo.addAll(Librarian.viewbooks());
                                for (int i = 0; i < kimbo.size(); i++) {
                                    Book b = kimbo.get(i);
                                    System.out.println(
                                            "Book Name: " + b.getname1() + "\nID: " + b.getidbk() + "\nAuthor: "
                                                    + b.getauth());
                                    System.out.println();
                                }
                            } else if (v == 7) {
                                System.out.println("----------");
                                break;
                            } else {
                                System.out.println("Wrong Input Choosen");
                                continue;
                            }
                        } catch (Exception ufo) {
                            System.out.println("----------");
                            System.out.println("You have entered wrong type of Input.");
                        }
                    }
                } else if (n == 2) {
                    System.out.print("ENTER NAME: ");
                    String name = br.readLine();
                    System.out.print("ENTER CONTACT NUMBER: ");
                    long number = Long.parseLong(br.readLine());
                    int a = 0;
                    for (int i = 0; i < Librarian.viewmember().size(); i++) {
                        boolean euqla = name.equals(Librarian.viewmember().get(i).getname());
                        if (Librarian.viewmember().get(i).getcontact() == number
                                && euqla == true) {
                            System.out.println("----------");
                            System.out.println("WELCOME " + name + " MEMBER ID: " + number);
                            System.out.println("----------");
                            a = 1;
                            break;
                        }
                    }
                    if (a == 0) {
                        System.out.println("----------");
                        System.out.println("YOU ARE NOT REGISTERED AS A MEMBER OF THIS LIBRARY.");
                        System.out.println("----------");
                        continue;
                    }
                    Member obj1 = Librarian.callmember(number);
                    while (true) {
                        try {
                            System.out.println(
                                    "1. List Available Books\n2. List My Books\n3. Issue Book\n4. Return Book\n5. Pay Fine\n6. Back\n");
                            System.out.println("----------");
                            int g = Integer.parseInt(br.readLine());

                            if (g == 1) {
                                System.out.println("----------");
                                ArrayList<Book> b2 = new ArrayList<>();
                                b2.addAll(Librarian.viewbooks());
                                ArrayList<Book> b3 = new ArrayList<>();
                                b3 = obj1.getavailablebooks(b2);
                                for (int i = 0; i < b3.size(); i++) {
                                    System.out
                                            .println("BOOK NAME: " + b3.get(i).getname1() + "\nID: "
                                                    + b3.get(i).getidbk()
                                                    + "\nAuthor: " + b3.get(i).getauth());
                                    System.out.println("\n");
                                }
                                System.out.println("----------");

                            } else if (g == 2) {
                                System.out.println("----------");
                                ArrayList<Book> b5 = new ArrayList<>();
                                b5.addAll(obj1.getsbk());
                                for (int i = 0; i < b5.size(); i++) {
                                    System.out
                                            .println("BOOK NAME:" + b5.get(i).getname1() + " ID: " + b5.get(i).getid());
                                }
                                System.out.println("----------");
                            } else if (g == 3) {
                                System.out.println("----------");
                                ArrayList<Book> uy = obj1.getavailablebooks(Librarian.bookie);
                                for (int i = 0; i < uy.size(); i++) {
                                    System.out
                                            .println("Book Name: " + uy.get(i).getname1() + " ID: "
                                                    + uy.get(i).getidbk());
                                    System.out.print("\n");
                                }
                                System.out.print("BOOK ID: ");
                                try {
                                    int ko = Integer.parseInt(br.readLine());
                                    System.out.println("----------");
                                    obj1.issuebook(Member.findbook(ko));
                                } catch (Exception hui) {
                                    System.out.println("Entered Value ID Book Doesn't exist.");
                                }
                                System.out.println("----------");
                            } else if (g == 4) {
                                System.out.println("----------");
                                ArrayList<Book> b965 = new ArrayList<>();
                                b965.addAll(obj1.getsbk());
                                for (int i = 0; i < b965.size(); i++) {
                                    System.out
                                            .println("BOOK NAME:" + b965.get(i).getname1() + " ID: "
                                                    + b965.get(i).getid());
                                }
                                System.out.println("----------");
                                System.out.print("BOOK ID: ");
                                try {
                                    int yu = Integer.parseInt(br.readLine());
                                    System.out.println("----------");
                                    obj1.returnbook(yu);
                                } catch (Exception ty) {
                                    System.out.println("Entered Value is Incorrect");
                                }
                                System.out.println("----------");
                            } else if (g == 5) {
                                System.out.println("----------");
                                obj1.payfine(obj1.getbalance());
                                System.out.println("----------");
                            } else if (g == 6) {
                                System.out.println("----------");
                                break;
                            } else {
                                System.out.println("Wrong Input Choosen");
                                continue;
                            }
                        } catch (Exception ghy) {
                            System.out.println("----------");
                            System.out.println("You have entered wrong type of Input.");
                        }
                    }

                } else if (n == 3) {
                    System.out.println("----------");
                    System.out.println("Thanks for Visiting.");
                    System.out.println("----------");
                    break;
                } else {
                    System.out.println("Wrong Input Choosen.");
                    continue;
                }
            } catch (Exception yut) {
                System.out.println("----------");
                System.out.println("You have entered wrong type of Input.");
                System.out.println("----------");

            }
        }
    }
}
// To add Try except in member and librarian separately.
// Check for any other error.