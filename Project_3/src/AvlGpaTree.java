public class AvlGpaTree {

    AvlGpaNode root;
    int size;

    AvlGpaTree(){
        this.root = null;
    }

    public int getSize(){
        return this.root.getFamilySize();
    }

    public int getHeight(){
        return this.root.getHeight();
    }

    public AvlGpaTree(AvlGpaNode root){
        this.root = root;
        root.setLeft(null);
        root.setRight(null);
        size = 1;
    }

    public boolean isComplete(){
        return root.isComplete();
    }

    public Student [] traverseLevelOrder(){
        return this.root.traverseLevelOrder();
    }

    public void traversePreOrder(){
        this.root.traversePreOrder();
    }

    public void traverseInOrder (){
        this.root.traverseInOrder();
    }

    public AvlGpaNode findMin(){
        return this.root.findMin();
    }

    public AvlGpaNode findMax(){
        return this.root.findMax();
    }

    public void insert (Student inserted){
        insert(this.root, inserted);
        this.balance();
    }

    private void balance() {
        this.root.getHeight();
        if (this.root.getLeftHeight() - this.root.getRightHeight() > 1){
            if (this.root.getLeft().getLeftHeight() > this.root.getLeft().getRightHeight()){
                this.root = this.root.rotateRight();
            } else {
                this.root = this.root.rotateLeftRight();
            }
        } else if (this.root.getRightHeight() - this.root.getLeftHeight() > 1){
            if (this.root.getRight().getRightHeight() > this.root.getRight().getLeftHeight()){
                this.root = this.root.rotateLeft();
            } else {
                this.root = this.root.rotateRightLeft();
            }
        }
    }

    private void insert(AvlGpaNode root, Student inserted){
        if (root == null){
            this.root = new AvlGpaNode(inserted);
            size++;
        } else if(inserted.getGPA() == root.getGrade()){
            root.addStudent(inserted);
            size++;
        }else if (inserted.getGPA() < root.getGrade()){
            if (root.getLeft() == null){
                root.setLeft(new AvlGpaNode(inserted));
                size++;
            } else {
                insert(root.getLeft(), inserted);
            }
        } else if (inserted.getGPA() > root.getGrade()) {
            if (root.getRight() == null) {
                root.setRight(new AvlGpaNode(inserted));
                size++;
            } else {
                insert(root.getRight(), inserted);
            }
        }
    }

    public LnList find (float Gpa){
        return find(this.root, Gpa).getList();
    }

    private AvlGpaNode find(AvlGpaNode root, float Gpa){
        if (root == null){
            return null;
        } else if (Gpa == root.getGrade()){
            return root;
        } else if (Gpa < root.getGrade()){
            return find(root.getLeft(), Gpa);
        } else {
            return find(root.getRight(), Gpa);
        }
    }





}
