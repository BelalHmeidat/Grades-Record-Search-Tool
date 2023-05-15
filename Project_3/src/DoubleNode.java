public class DoubleNode {
    Student student;
    DoubleNode next;
    DoubleNode prev;

    public DoubleNode(){
        student = null;
        next = null;
        prev = null;
    }
    public DoubleNode(Student student) {
        this.student = student;
        next = null;
        prev = null;
    }

    public Student getStudent(){
        return student;
    }
}
