package Utils;

public class StudentObject {
    int id;
    String firstname;
    String lastname;
    int age;
    double grade;
    public StudentObject() {

    };

    public StudentObject(int id, String firstname, String lastname, int age, double grade) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentObject{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
