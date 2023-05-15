import java.io.FileWriter;
import java.io.IOException;

public class LnList {
    private LnNode first;
    private LnNode last;
    private int size;

    float gpa;

    public LnList() {
        first = last = null;
        size = 0;
    }

    public LnNode getFirst(){
        if (size <= 0){
            return null;
        }
        return first;
    }

    public float getGPA(){
        return this.gpa;
    }

    public LnNode getLast(){
        if (size <= 0){
            return null;
        }
        return last;

    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void addFirst(Student student){
        if (this.isEmpty()) gpa = student.getGPA();
        if (size == 0){
            this.first = this.last = new LnNode(student);
            this.size = 1;
            return;
        }
        LnNode node = new LnNode(student);
        node.next = this.first;
        this.size++;
        this.first = node;
        return;
    }

    public void addLast (Student elemnet){
        if (this.isEmpty()) gpa = elemnet.getGPA();
//        if (this.size < 0){
//            System.out.println("NO");
//            return;
//        }
//        LnNode node = new LnNode(elemnet);
        if (this.size == 0){
            this.first = this.last = new LnNode(elemnet);
            this.size = 1;
            return;
        }
        // LnNode current = this.first;
        // for (int i = 0; i < size; i++){
        //     current = current.next;
        // }
        // current = node;
        // this.last = current;

        this.last.next = new LnNode(elemnet);
        this.last = this.last.next;
        this.size++;
        return;

    }
    public boolean removeFirst(){
        if (size <= 0){
            System.out.println("NO");
            return false;
        }
        first = first.next;
        if (size == 1){
            last = first;
        }
        size--;
        return true;
    }

    public boolean removeLast(){
        if (size <= 0 ){
            System.out.println("NO");
            return false;

        }
        LnNode current = new LnNode();
        current = first;
        for (int i = 0; i < size -1; i++){
            current = current.getNext();
        }
        if (size == 1){
            first = last = null;
        }
        current.setNext(null);
        size--;
        return true;
    }
    //Not used
    public void add (Student element, int index){
        if (size <= 0 || index >= size){
            System.out.println("NO");
            return;
        }
        if (index == 0){
            addFirst(element);
            return;
        }
        LnNode current = new LnNode();
        current = first;
        for (int i =0; i < size; i++){
            current = current.getNext();
            if (i == index){
                break;
            }
        }
        LnNode newNode = new LnNode();
        current.setNext(newNode);
        newNode.setStudent(element);
        size++;
        return;

    }
    //Not used
    public void remove (int index){
        if (size <= 0 || index >= size){
            System.out.println("NO");
            return;
        }
        if (index == 0){
            removeFirst();
            // size--;
            return;
        }
        if (index == size - 1){
            removeLast();
            // size--;
            return;
        }
        LnNode current = new LnNode();
        current = first;
        for (int i = 0; i < size; i ++){
            current = current.getNext();
            if (i == index - 1){
                break;
            }
        }
        current.next = current.next.next;
        size--;
        return;

    }
//    Removes a node contatining a student in a linked list by searching for the student object name
    public void remove( Student examinee){
        int i;
        if (size <= 0){
            System.out.println("No");
            return;
        }
        LnNode current = new LnNode();
        LnNode prev = new LnNode();
        current = first;
        if (((Student) current.getStudent()).getID() == examinee.getID()){
            removeFirst();
            return;
        }
        prev = first;
        current = first.getNext();
        for (i = 0; i < size; i++){
            if (((Student) current.getStudent()).getID() == examinee.getID()){
                break;
            }
            current = current.getNext();
            prev = prev.getNext();
        }
        prev.setNext(current.getNext());
//        current.next = null;
        size--;
//        System.out.println("Removed!");
        return;

    }

    //Merges two lists
     public static LnList appendList(LnList list, LnList list2){

        list.last.next = list2.first;
        list.last = list2.last;
        list.size += list2.size;
        return list;
     }





    public void printExaminees(){
//        removeNonExaminees();

        LnNode current = first;
        for (int i = 0; i < this.size; i++){
            System.out.println(((Student)current.data).getID() + " " + ((Student) current.data).branch + " " + ((Student) current.data).gpa);
            current = current.next;
        }
//        System.out.println(this.size);
    }
//    public void removeNonExaminees(){
//        LnNode current = first.next;
//        LnNode prev = first;
//        while (this.getFirst().data instanceof Examinee == false){
//            removeFirst();
//        }
//        while (this.getLast().data instanceof Examinee == false){
//            removeLast();
//        }
//        if (size == 1 || size == 0){
//            return;
//        }
//        for (int i = 0; i < this.getSize(); i++){
//            if (!(current.data instanceof Examinee)){
//                System.out.println("here");
//                prev.next = current.next;
//                current = current.next;
//                size--;
//            }
//            current = current.next;
//            prev = prev.next;
//        }
//    }
    //Method that sorts by GPA then branch then ID
//    public void sortByGPA(){
//        LnNode current = first;
//        LnNode next = first.next;
//        for (int i = 0; i < this.size; i++){
//            for (int j = 0; j < this.size - 1; j++){
//                if (((Examinee)current.data).gpa < ((Examinee)next.data).gpa){
//                    Examinee temp = (Examinee)current.data;
//                    current.data = next.data;
//                    next.data = temp;
//                }
//                else if (((Examinee)current.data).gpa == ((Examinee)next.data).gpa){
//                    if (!(((Examinee)current.data).branch.equals(((Examinee)next.data).branch))){
//                        Examinee temp = (Examinee)current.data;
//                        current.data = next.data;
//                        next.data = temp;
//                    }
//                    else if (((Examinee)current.data).id > ((Examinee)next.data).id){
//                            Examinee temp = (Examinee)current.data;
//                            current.data = next.data;
//                            next.data = temp;
//                    }
//                }
//                current = current.next;
//                next = next.next;
//            }
//            current = first;
//            next = first.next;
//        }
//    }
    //Method to sort by branch then ID
//    public LnList sortByBranch(LnList sci, LnList lit){
//        LnList tempList1= sci.copy();
//        LnList tempList2 = lit.copy();
//        tempList1.sortByID();
//        tempList2.sortByID();
//        appendList(tempList1, tempList2);
//        return tempList1;
//    }
    //method to sort by ID then gpa then branch
//    public void sortByID(){
//        LnNode current = first;
//        LnNode next = first.next;
//        for (int i = 0; i < this.size; i++){
//            for (int j = 0; j < this.size - 1; j++){
//                if (((Examinee)current.data).id > ((Examinee)next.data).id){
//                    Examinee temp = (Examinee)current.data;
//                    current.data = next.data;
//                    next.data = temp;
//                }
//                else if (((Examinee)current.data).id == ((Examinee)next.data).id){
//                    if (((Examinee)current.data).gpa < ((Examinee)next.data).gpa){
//                        Examinee temp = (Examinee)current.data;
//                        current.data = next.data;
//                        next.data = temp;
//                    }
//                    else if (((Examinee)current.data).gpa == ((Examinee)next.data).gpa){
//                        if (!(((Examinee)current.data).branch.equals(((Examinee)next.data).branch))){
//                            Examinee temp = (Examinee)current.data;
//                            current.data = next.data;
//                            next.data = temp;
//                        }
//                    }
//                }
//                current = current.next;
//                next = next.next;
//            }
//            current = first;
//            next = first.next;
//        }
//    }
    //Searches the list for a node with given ID in its data and returns all data stored for that student
    public Student search(int id){
        LnNode current = first;
        for (int i = 0; i < this.size; i++){
            if (((Student)current.data).getID() == id){
                return (Student) current.data;
            }
            current = current.next;
        }
//        System.out.println("Not found");
        return null;

    }

    public LnList copy(){
        LnList copy = new LnList();
        LnNode current = first;
        for (int i = 0; i < this.size; i++){
            copy.addLast(current.data);
            current = current.next;
        }
        return copy;
    }

    public Student [] extractStudents() {
        LnNode current = first;
        Student [] students = new Student[this.size];
        for (int i = 0; i < this.size; i++){
            students[i] = current.data;
            current = current.next;
        }
        return students;
    }
    //Saves the list to a file

//    public void saveToFile(String filename) throws IOException {
//        FileWriter fw = new FileWriter(filename);
//        LnNode current = first;
//        for (int i = 0; i < this.size; i++) {
//            fw.write(((Student) current.data).getGPA() + "," + ((Student) current.data).branch + "," + ((Student) current.data).gpa + "\n");
//            current = current.next;
//        }
//        fw.close();
//    }

}



