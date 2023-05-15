public class AvlIdTree {

    AvlIdNode root;
    int height;
    int leftHeight;
    int rightHeight;
    int size;

    AvlIdTree(){
        this.root = null;
    }
    public int getSize(){
        return this.root.getFamilySize();
    }

    public int getHeight(){
        return this.root.getHeight();
    }

    public AvlIdTree(AvlIdNode root){
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

    public void traversePostOrder(){
        this.root.traversePostOrder();
    }
    public AvlIdNode findMin(){
        return this.root.findMin();
    }
    public AvlIdNode findMax(){
        return this.root.findMax();
    }

    public void insert (DoubleNode inserted){
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
                System.out.println(this.root.getHeight());
                this.root = this.root.rotateLeft();
            } else {
                this.root = this.root.rotateRightLeft();
            }
        }
    }

    private void insert (AvlIdNode node, DoubleNode inserted){
        if (node == null) {
            return;
        }
        if (node.compareTo(inserted.getStudent().getID()) > 0){
            if (node.getLeft() == null){
                node.setLeft(new AvlIdNode(inserted));
            } else {
                insert(node.getLeft(), inserted);
            }
        } else {
            if (node.getRight() == null){
                node.setRight(new AvlIdNode(inserted));
            } else {
                insert(node.getRight(), inserted);
            }
        }
    }
    public DoubleNode find (int id){
        if (find(this.root, id) == null) return null;
        else return find(this.root, id).getStuNode();
    }

    private AvlIdNode find (AvlIdNode node, int id){
        if (node == null) return null;
        if (node.compareTo(id) == 0) return node;
        else if (node.compareTo(id) > 0) return find(node.getLeft(), id);
        else return find(node.getRight(), id);
    }


}
