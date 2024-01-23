public class BST {
    public node header;
    public String inOrderString = "";
    public String preOrderString = "";
    public String postOrderString = "";
    public boolean start = true;


    public void insert(int value) {
        node current = header;
        if (header == null) {
            header = new node(null, null, null, value);
        } else {
            boolean placing = true;
            while (placing) {
                if (current.getValue() > value && current.getLeft() != null) {
                    current = current.getLeft();
                } else if (current.getValue() < value && current.getRight() != null) {
                    current = current.getRight();
                } else if (current.getValue() > value && current.getLeft() == null) {
                    current.setLeft(new node(null, null, current, value));
                    placing = false;
                } else if (current.getValue() < value && current.getRight() == null) {
                    current.setRight(new node(null, null, current, value));
                    placing = false;
                } else if (value == current.getValue()) {
                    placing = false;
                }
            }
        }
    }

    public boolean searching(int value) {
        node current = header;
        boolean exists = false;
        if (header != null) {
            boolean searching = true;
            while (searching) {
                if (current.getValue() > value && current.getLeft() != null) {
                    current = current.getLeft();
                } else if (current.getValue() < value && current.getRight() != null) {
                    current = current.getRight();
                } else if (current.getValue() == value) {
                    searching = false;
                    exists = true;
                } else if (current.getValue() != value) {
                    searching = false;
                }
            }
        }
        return exists;
    }

    public Integer getMax() {
        Integer max = null;
        node current = header;

        if (header != null) {
            while (current.getRight() != null) {
                current = current.getRight();
            }
            max = current.getValue();
        }
        return max;
    }

    public String InOrder(node n) {
        if (n!= null) {
            if (n.getLeft()!= null) {
                this.InOrder(n.getLeft());
            }

            if (n.getValue() != null) {
                inOrderString += n.getValue() + ",";
            }

            if (n.getRight()!= null) {
                this.InOrder(n.getRight());
            }
            n = header;
            return inOrderString;
        } else {
            return null;
        }

    }

    public String displayInOrder() {
        String displayInOrder = this.InOrder(header);
        inOrderString = "";
        return displayInOrder;
    }

    public String PreOrder(node n) {
        if (n != null) {
            preOrderString += n.getValue() + ",";
            if (n.getLeft() != null) {
                this.PreOrder(n.getLeft());
            }
            if (n.getRight() != null) {
                this.PreOrder(n.getRight());
            }
            start = true;
            n = header;
            return preOrderString;
        } else {
            return "null";
        }

    }

    public String displayPreOrder() {
        String displayPreOrder = this.PreOrder(header);
        preOrderString = "";
        return displayPreOrder;
    }

    public String PostOrder(node n) {
        if (n != null) {
            if (n.getLeft() != null) {
                this.PostOrder(n.getLeft());
            }
            if (n.getRight() != null) {
                this.PostOrder(n.getRight());
            }
            start = true;
            postOrderString += n.getValue() + ",";
            n = header;
            return postOrderString;
        } else {
            return "null";
        }

    }

    public String displayPostOrder() {
        String displayPostOrder = this.PostOrder(header);
        postOrderString = "";
        return displayPostOrder;
    }

    public node search(Integer value) {
        node current = header;

        if (header == null) {

        } else {
            boolean searching = true;
            while (searching) {
                if (current.getValue() > value && current.getLeft() != null) {
                    current = current.getLeft();
                } else if (current.getValue() < value && current.getRight() != null) {
                    current = current.getRight();
                } else if (current.getValue().equals(value)) {
                    searching = false;
                    return current;
                } else if (!current.getValue().equals(value)) {
                    searching = false;
                }
            }
        }
        return current;
    }

    public void delete(Integer value) {
        node delete = search(value);
        //Neither left nor right have value
        if (delete.getLeft() == null && delete.getRight() == null) {
            if (delete.getValue() > delete.getParent().getValue()) {
                delete.getParent().setRight(null);
            } else if (delete.getValue() < delete.getParent().getValue()) {
                delete.getParent().setLeft(null);
            }
        }

        //Right has a value only
        else if (delete.getLeft() == null && delete.getRight() != null) {
            node replacement = delete.getRight();
            //delete = header
            if (delete == header) {
                header = delete.getRight();
                delete = null;
            }
            // delete is parent's left
            else if (delete.getValue() < delete.getParent().getValue()) {
                delete.getParent().setLeft(delete.getRight());
                delete = null;
            }
            // delete is parent's right
            else if (delete.getValue() > delete.getParent().getValue()) {
                delete.getParent().setRight(delete.getRight());
                delete = null;
            }
        }

        //Left has a value only
        else if (delete.getLeft() != null && delete.getRight() == null) {
            node replacement = delete.getLeft();
            //delete = header
            if (delete == header) {
                header = delete.getLeft();
                delete = null;
            }
            // delete is parent's left
            else if (delete.getValue() < delete.getParent().getValue()) {
                delete.getParent().setLeft(delete.getLeft());
                delete = null;
            }
            // delete is parent's right
            else if (delete.getValue() > delete.getParent().getValue()) {
                delete.getParent().setRight(delete.getLeft());
                delete = null;
            }
        }

        //Both Left and right nodes have values
        else if (delete.getRight() != null && delete.getLeft() != null) {
            node replacement = delete.getRight();
            while (replacement.getLeft() != null) {
                replacement = replacement.getLeft();
            }
            //delete = header
            if (delete == header) {
                if (header.getRight().getLeft() == null) {
                    header.setValue(replacement.getValue());
                    header.setRight(replacement.getRight());
                    replacement = null;
                    replacement = header;
                } else if (header.getRight().getLeft() != null) {
                   replacement.getParent().setLeft(replacement.getRight());
                   header.setValue(replacement.getValue());
                   replacement = null;
                   replacement = header;
                }
            }
            // delete is parent's left
            else if (delete.getValue() < delete.getParent().getValue()) {
                replacement.setLeft(delete.getLeft());
                delete.getParent().setLeft(replacement);
                replacement.setParent(null);
                delete = null;
            }
            // delete is parent's right
            else if (delete.getValue() > delete.getParent().getValue()) {
                replacement.setLeft(delete.getLeft());
                delete.getParent().setRight(replacement);
                if (delete.getLeft() != null) {
                    delete.getLeft().setParent(delete.getRight());
                }
                delete.getRight().setParent(delete.getParent());


            }
        }
    }

}
