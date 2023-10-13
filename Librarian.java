import java.util.ArrayList;

public class Librarian {
    static ArrayList<Book> bookie = new ArrayList<>();
    static ArrayList<Member> memie = new ArrayList<>();
    static int idr = 1;

    public void addmember(String name, int age, Long contact) {
        int e = 0;
        for (int i = 0; i < memie.size(); i++) {
            if (memie.get(i).getcontact() == contact) {
                e = 1;
                break;
            } else {
                continue;
            }
        }
        if (e == 0) {
            memie.add(new Member(name, age, contact));
            System.out.println("----------");
            System.out.println("Member Successfully Registered with ID: " + contact);
        } else {
            System.out.println("Member with similar ID already exists.");
        }

    }

    static ArrayList<Member> viewmember() {
        return memie;
    }

    static Member callmember(Long id) {
        for (int i = 0; i < memie.size(); i++) {
            if (memie.get(i).getcontact() == id) {
                return memie.get(i);
            }
        }
        return null;
    }

    public void removemember(Long cont) {
        int r = 0;
        for (int i = 0; i < memie.size(); i++) {
            if (memie.get(i).getcontact() == cont) {
                if (memie.get(i).returnsize() != 0 || memie.get(i).getbalance() != 0) {
                    r = 2;
                    break;
                } else {
                    memie.remove(i);
                    r = 1;
                    break;
                }

            } else {
                continue;
            }
        }
        if (r == 0) {
            System.out.println("NO SUCH MEMBER EXISTS.");
        } else if (r == 1) {
            System.out.println("Member with ID: " + cont + " has been removed from the library");
        } else {
            System.out.println(
                    "The member has borrowed books which needs to be returned first or the member hasn't paid fine.");
        }

    }

    static ArrayList<Book> viewbooks() {
        return bookie;
    }

    public void addbooks(String bo, String au, int id) {
        for (int i = 0; i < id; i++) {
            bookie.add(new Book(bo, au, idr));
            idr++;
        }
    }

    public void removebook(int id) {
        int at = 0;
        for (int i = 0; i < bookie.size(); i++) {
            if (bookie.get(i).getid() == id) {
                bookie.remove(i);
                at = 1;
            } else {
                continue;
            }
        }
        if (at == 1) {
            System.out.println("Book with ID: " + id + " removed from the Library");
        } else {
            System.out.println("No book with ID: " + id + " present in the Library to remove.");
        }
    }

}