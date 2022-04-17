package BDProjectv7;


public class User {
    protected String username, password, CNP, nume, prenume, adresa,  nr_telefon, email, IBAN, nr_contract, role;
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
}   

class Student extends User{
    int an_studiu;
    int nr_ore;

    public Student(String username,String password){
        super(username, password);
    }
    public Student(String username, String password, String role){
        super(username, password, role);
    }
  }

class Profesor extends User{
    int min_ore, max_ore;
    String departament;
  
    public Profesor(String username,String password){
        super(username, password);
    }
    public Profesor(String username, String password, String role){
        super(username, password, role);
    }
}
