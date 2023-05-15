import java.util.ArrayList;

public class AvlGpaNode {


    private LnList list;

    private int leftHeight;
    private int rightHeight;

    private int count = 1;

    public int height = 0;
    private AvlGpaNode left;

    private AvlGpaNode right;

    public AvlGpaNode(Student student) {
        if (this.list == null) this.list = new LnList();
        this.list.addLast(student);
    }


    public float getGrade() {
        return this.list.getGPA();
    }

    public LnList getList(){
        return this.list;
    }

    public void setLeft(AvlGpaNode left) {
        this.left = left;
    }

    public void setRight(AvlGpaNode right) {
        this.right = right;
    }

    public boolean isLeaf () {
        return this.left == null && this.right == null;
    }

    public boolean hasLeft () {
        return this.left != null;
    }

    public boolean hasRight () {
        return this.right != null;
    }

    public boolean hasBoth () {
        return this.left != null && this.right != null;
    }

    public int getFamilySize() {
        int count = 1;
        if (this.hasLeft()) count += this.getLeft().getFamilySize();
        if (this.hasRight()) count += this.getRight().getFamilySize();
        return count;
    }


    public AvlGpaNode getLeft() {
        return this.left;
    }

    public AvlGpaNode getRight() {
        return this.right;
    }

    public int compareTo(float gpa) {
        return Float.compare(this.getGrade(), gpa);
    }

    public Student [] traverseLevelOrder(){
        return traverseLevelOrder(this);
    }

    private Student []  traverseLevelOrder(AvlGpaNode node){
        if (node == null) return null;
        Student [] studentsList = null;
        Queue queue = new Queue(node.getFamilySize());
        queue.enqueue(node);
        while (!queue.isEmpty()){
            AvlGpaNode temp = (AvlGpaNode) queue.dequeue();
            if (studentsList == null) studentsList = temp.getList().extractStudents();
            else studentsList = mergeArrays(studentsList, temp.getList().extractStudents());
//            System.out.println(temp.getGrade());
            if (temp.getLeft() != null) {
                queue.enqueue(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.enqueue(temp.getRight());
            }
        }
        return studentsList;
    }

    public AvlGpaNode findMin(){
        return findMin(this);
    }

    protected AvlGpaNode findMin(AvlGpaNode node){
        if (node.getLeft() == null) return node;
        return findMin(node.getLeft());
    }

    public AvlGpaNode findMax(){
        return findMax(this);
    }

    protected AvlGpaNode findMax(AvlGpaNode node){
        if (node.getRight() == null) return node;
        return findMax(node.getRight());
    }
    public void insert (Student inserted){
        insert(this, inserted);
    }

    protected void insert (AvlGpaNode node, Student inserted){
        if (node == null) {
            return;
        }
        if (node.compareTo(inserted.getGPA()) > 0){
            if (node.getLeft() == null){
                node.setLeft(new AvlGpaNode(inserted));
            } else {
                insert(node.getLeft(), inserted);
            }
        } else if (node.compareTo(inserted.getGPA()) < 0) {
            if (node.getRight() == null){
                node.setRight(new AvlGpaNode(inserted));
            } else {
                insert(node.getRight(), inserted);
            }
        }
        else if (node.compareTo(inserted.getGPA()) == 0) {
            node.list.addLast(inserted);
        }
    }

    public AvlGpaNode find (float gpa){
        return find(this, gpa);
    }

    protected AvlGpaNode find (AvlGpaNode node, float gpa){
        if (node == null) return null;
        if (node.compareTo(gpa) == 0) return node;
        else if (node.compareTo(gpa) > 0) return find(node.getLeft(), gpa);
        else return find(node.getRight(), gpa);
    }
//    public void delete (Student student){
//        NumberBinaryTree successor = null;
//        NumberBinaryTree parent = null;
//        NumberBinaryTree current = find(student);
//        //no node with value found
//        if (current == null) return;
//        //current is the first root and the only node in the tree
//        if (current == this && current.isLeaf()){
//            this.list = null;
//            return;
//        }
//        //current is not the first root but is leaf
//        parent = findParent(current);
//        if (current.isLeaf()){
//            if (parent.getLeft() == current) parent.left = null;
//            else parent.right = null;
//        }
//        //current is in the middle
//        else {
//            if (current.hasLeft()) {
//                successor = current.getLeft().findMax();
//            }
//            else if (current.hasRight()) {
//                successor = current.getRight().findMin();
//            }
//            if (successor != null) {//it will never be null here
//                parent = findParent(successor);
//                current.list = successor.list;
//                if (parent.getLeft() == successor) parent.left = successor.left;
//                else parent.right = successor.right;
//            }
//        }
//    }

//    protected NumberBinaryTree findParent (NumberBinaryTree child){
//        if(child == this) return null;
//        NumberBinaryTree parent = this;
//        NumberBinaryTree current = null;
//        if(child.compareTo(parent.list) < 0) {
//            current = parent.getLeft();
//        } else {
//            current = parent.getRight();
//        }
//        while (current != child) {
//            parent = current;
//            if (current.hasLeft() && child.compareTo(current.getNumber()) < 0) {
//                current = current.getLeft();
//            } else if ( current.hasRight() && child.compareTo(current.getNumber()) >= 0) {
//                current = current.getRight();
//            }
//        }
//        return parent;
//    }


    public void traverseInOrder (){
        traverseInOrder(this);
    }

    public void traversePreOrder (){
        traversePreOrder(this);
    }

    public void traversePostOrder (){
        traversePostOrder(this);
    }

    protected void traverseInOrder(AvlGpaNode root){
        if (root == null) return;
        if (root.hasLeft()) traverseInOrder(root.getLeft());
        System.out.println(root.getGrade());
        if (root.hasRight()) traverseInOrder(root.getRight());
    }

    protected void traversePreOrder(AvlGpaNode root){
        if (root == null) return;
        System.out.println(root.getGrade());
        if (root.hasLeft()) traversePreOrder(root.getLeft());
        if (root.hasRight()) traversePreOrder(root.getRight());
    }

    protected void traversePostOrder(AvlGpaNode root) {
        if (root == null) return;
        if (root.hasLeft()) traversePostOrder(root.getLeft());
        if (root.hasRight()) traversePostOrder(root.getRight());
        System.out.println(root.getGrade());
    }

    public boolean isComplete() {
        return isComplete(this);
    }

    protected boolean isComplete(AvlGpaNode node) {
        if (node == null) return true;
        if (node.getLeft() == null && node.getRight() == null) return true;
        if (node.getLeft() != null && node.getRight() != null) {
            return isComplete(node.getLeft()) && isComplete(node.getRight());
        }
        return false;
    }

    public void addStudent(Student inserted) {
        if (this.list == null) {
            this.list = new LnList();
            this.list.addLast(inserted);
        } else {
            this.list.addLast(inserted);
        }
    }

    public int getLeftHeight() {
        if (this.getLeft() == null) return 0;
        return this.getLeft().getHeight();
    }


    public int getRightHeight() {
        if (this.getRight() == null) return 0;
        return this.getRight().getHeight();
    }

    public int getHeight() {
        leftHeight = getLeftHeight();
        rightHeight = getRightHeight();
        height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    public AvlGpaNode rotateLeft() {
        AvlGpaNode newRoot = this.getRight();
        this.setRight(newRoot.getLeft());
        newRoot.setLeft(this);
        newRoot.getHeight();
        return newRoot;
    }

    public AvlGpaNode rotateRight() {
        AvlGpaNode newRoot = this.getLeft();
        this.setLeft(newRoot.getRight());
        newRoot.setRight(this);
        newRoot.getHeight();
        return newRoot;
    }

    public AvlGpaNode rotateLeftRight() {
        this.setLeft(this.getLeft().rotateLeft());
        return this.rotateRight();
    }

    public AvlGpaNode rotateRightLeft() {
        this.setRight(this.getRight().rotateRight());
        return this.rotateLeft();
    }

    private Student [] mergeArrays (Student [] a, Student [] b){
        Student [] merged = new Student[a.length + b.length];
        for (int i = 0; i < a.length; i++){
            merged[i] = a[i];
        }
        for (int i = 0; i < b.length; i++){
            merged[i + a.length] = b[i];
        }
        return merged;
    }

}
