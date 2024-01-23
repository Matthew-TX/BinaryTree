import org.junit.Assert;
import org.junit.Test;

public class TestInteger {
    @org.junit.Test
    public void Insert() {
        BST test = new BST();
        test.insert(5);
        test.insert(10);
        test.insert(8);
        test.insert(5);
        test.insert(2);
        test.insert(3);
        test.insert(2);
        String inOrder = test.displayInOrder();
        Assert.assertEquals("2,3,5,8,10,", inOrder);
    }

    @Test
    public void searching() {
        BST test = new BST();

        test.insert(4);
        Assert.assertTrue(test.searching(4));

        test.insert(5);
        Assert.assertFalse(test.searching(6));

        test.insert(2);
        Assert.assertTrue(test.searching(2));

        test.insert(1);
        Assert.assertTrue(test.searching(1));
    }

    @Test
    public void getMax() {
        BST test = new BST();
        Integer maxValue = 8;

        test.insert(4);
        test.insert(maxValue);
        test.insert(2);
        test.insert(1);

        Assert.assertEquals(maxValue, test.getMax());

    }

    @Test
    public void order() {
        //Make BST
        BST test = new BST();

        //In Order
        test.insert(4);
        test.insert(8);
        test.insert(8);
        test.insert(2);
        test.insert(1);
        test.insert(5);
        test.insert(7);
        String inOrder = test.displayInOrder();
        Assert.assertEquals("1,2,4,5,7,8,", inOrder);

        //Pre Order
        String preOrder = test.displayPreOrder();
        Assert.assertEquals("4,2,1,8,5,7,", preOrder);

        //Post Order
        String postOrder = test.displayPostOrder();
        Assert.assertEquals("1,2,7,5,8,4,", postOrder);
    }

    @Test
    public void delete() {
        BST test = new BST();
        Integer maxValue = 8;
        test.insert(4);
        test.insert(maxValue);
        test.insert(2);
        test.insert(1);
        test.insert(5);
        test.insert(7);

        //Delete Leaf Node
        String inOrder = test.displayInOrder();
        Assert.assertEquals("1,2,4,5,7,8,", inOrder);
        test.delete(7);
        inOrder = test.displayInOrder();
        Assert.assertEquals("1,2,4,5,8,", inOrder);

        //Deleting with null left
        test = new BST();
        Integer[] nullLeft = {4, 1, 3, 2, 7, 9, 8};
        for (Integer value : nullLeft) {
            test.insert(value);

        }
        test.delete(1);
        inOrder = test.displayInOrder();
        Assert.assertEquals("2,3,4,7,8,9,", inOrder);

        test.delete(7);
        inOrder = test.displayInOrder();
        Assert.assertEquals("2,3,4,8,9,", inOrder);

        //header delete with null left
        test = new BST();
        Integer[] nullLeftHeader = {4, 7, 9, 8};
        for (Integer value : nullLeftHeader) {
            test.insert(value);
        }
        test.delete(4);
        inOrder = test.displayInOrder();
        Assert.assertEquals("7,8,9,", inOrder);

        //Null Right Delete
        test = new BST();
        Integer[] nullRight = {4, 3, 2, 1, 9, 8, 7};
        for (Integer value : nullRight) {
            test.insert(value);
        }

        inOrder = test.displayInOrder();
        Assert.assertEquals("1,2,3,4,7,8,9,", inOrder);

        test.delete(9);
        inOrder = test.displayInOrder();
        Assert.assertEquals("1,2,3,4,7,8,", inOrder);


        test.delete(3);
        inOrder = test.displayInOrder();
        Assert.assertEquals("1,2,4,7,8,", inOrder);

        test = new BST();
        Integer[] insert2 = {4, 3, 2, 1};
        for (Integer value : insert2) {
            test.insert(value);
        }
        test.delete(4);
        inOrder = test.displayInOrder();
        Assert.assertEquals("1,2,3,", inOrder);

        //Both of Delete's Nodes are Null
        test = new BST();
        Integer[] insert = {4, 2, 3, 1, 7, 6, 9};
        for (Integer value : insert) {
            test.insert(value);
        }
        test.delete(7);
        inOrder = test.displayInOrder();
        Assert.assertEquals("1,2,3,4,6,9,", inOrder);

        test.delete(2);
        inOrder = test.displayInOrder();
        Assert.assertEquals("1,3,4,6,9,", inOrder);

        //Delete Header
        Integer[] headerBoth = {4, 2, 3, 1, 7, 6, 8, 9};
        for (Integer value : headerBoth) {
            test.insert(value);
        }
        test.delete(7);
        test.delete(2);
        test.delete(4);
        inOrder = test.displayInOrder();
        Assert.assertEquals("1,3,6,8,9,", inOrder);


    }

}
