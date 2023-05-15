public class LnNode {
    public Student data;
    public LnNode next;

    public LnNode(){
        data = null;
        next = null;
    }
    public LnNode(Student data) {
        this.data = data;
        next = null;
    }

    public Student getStudent(){
        return data;
    }

    public LnNode getNext(){
        return next;
    }

    public void setNext(LnNode next){
        this.next = next;
    }

    public void setStudent(Student student){
        this.data = student;
    }
}
