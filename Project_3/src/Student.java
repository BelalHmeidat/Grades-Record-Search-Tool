import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Student {
    int ID;
    float gpa;

    String branch;



    Student(int ID, String branch, float gpa) {
        this.ID = ID;
        this.gpa = gpa;
        this.branch = branch;
    }

    public int getID() {
        return this.ID;
    }

    public float getGPA() {
        return this.gpa;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGPA(float gpa) {
        this.gpa = gpa;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String toString() {
        return "ID: " + this.ID + " GPA: " + this.gpa + " Branch: " + this.branch;
    }

    public boolean equals(Student student) {
        return this == student;
    }

    public IntegerProperty getIDProperty() {
        return new SimpleIntegerProperty(this.ID);
    }

    public FloatProperty getGPAProperty() {
        return new SimpleFloatProperty( this.gpa);
    }


}
