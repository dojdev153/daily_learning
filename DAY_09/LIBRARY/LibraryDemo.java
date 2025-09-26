package DAY_09.LIBRARY;

class Book{
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle(){ return title;}
    public String getAuthor(){return author;}
    public boolean isAvailable(){return isAvailable;}

    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
}

class Person{
    private String name;
    private String id;

    public Person(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
}
class Student extends Person{
    private String department;
    public Student(String name,String id,String department){
        super(name,id);
        this.department = department;
    }

    public void borrowBook(Book b){
        if(b.isAvailable()){
            b.setAvailable(false);
            System.out.println(getName() + " borrowed " + b.getTitle());
        }else{
            System.out.println(b.getTitle() + " is not available");
        }
    }
}

class Staff extends Person{
    public Staff (String name,String id){
        super(name,id);
    }

    public void manageBook(Book b, boolean add){
        if(add){
            b.setAvailable(true);
            System.out.println(getName() + " added " + b.getTitle());
        }else{
            b.setAvailable(false);
            System.out.println(getName() + " removed " + b.getTitle());
        }
    }
}

abstract class LibraryUser{
    protected String name;
    public LibraryUser(String name){
        this.name = name;
    }
    abstract void accessLibrary();
}

class StudentUser extends LibraryUser{
    public StudentUser(String name){
        super(name);
    }
    @Override
    void accessLibrary(){
        System.out.println(name + " borrows books from the library.");
    }
}
class StaffUser extends LibraryUser{
    public StaffUser(String name){
        super(name);
    }
    @Override
    void accessLibrary(){
        System.out.println(name + " manages books in the library.");
    }
}
public class LibraryDemo {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "Frank Duff");
        Book book2 = new Book("Data Structures", "John Doe");

        Student student1 = new Student("Milla", "S001", "Computer Science");
        Staff staff1 = new Staff("Max", "ST02");

        LibraryUser uStudent = new StudentUser("Milla");
        LibraryUser uStaff = new StaffUser("Max");

        uStudent.accessLibrary();
        uStaff.accessLibrary();

        staff1.manageBook(book1, true);
        staff1.manageBook(book2, true);

        student1.borrowBook(book1);
        student1.borrowBook(book2);
        student1.borrowBook(book1);

        System.out.println("Availability of " + book1.getTitle() + ": " + book1.isAvailable());
        System.out.println("Availability of " + book2.getTitle() + ": " + book2.isAvailable());

        staff1.manageBook(book2, false);
        System.out.println("Availability of " + book2.getTitle() + ": " + book2.isAvailable());
    }
}
