public class node {
    node right;
    node left;
    Integer Value;
    node parent;

    public node(node right, node left, node parent, Integer value) {
        this.right = right;
        this.left = left;
        Value = value;
        this.parent = parent;
    }

    public node getParent() {
        return parent;
    }

    public void setParent(node parent) {
        this.parent = parent;
    }

    public node getRight() {
        return right;
    }

    public void setRight(node right) {
        this.right = right;
    }

    public node getLeft() {
        return left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public Integer getValue() {
        return Value;
    }

    public void setValue(Integer value) {
        Value = value;
    }


}
