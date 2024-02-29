/*
Day #8: Easy
This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:(There was an attached image. I have recreated the tree as my test case.)
 */
//The idea of creating the "TreeCount" class comes from https://divyabiyani.medium.com/daily-coding-problem-february-23rd-2020-57f97d99e91
//I believe my solution ends up matching the one found there. Not super proud of that but I'll take it.
 class Unival{
    public static void main(String[] args) {
  
        // create an object of BinaryTree
        BinaryTree tree = new BinaryTree();
    
        // create nodes of the tree
        tree.root = new Node(0);
        tree.root.left = new Node(1);
        tree.root.right = new Node(0);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(0);
        tree.root.right.left.left = new Node(1);
        tree.root.right.left.right = new Node(1);
    
        System.out.print("\nBinary Tree: ");
        tree.traverseTree(tree.root);
        System.out.print("\nUnival Tree Count: ");
        System.out.println(UnivalTreeCount(tree.root).count);
      }
      public static TreeCount UnivalTreeCount(Node root){
        if(root==null){
            return new TreeCount(true, 0); //If the root is null, then we want to return true because this does not disqualify the above tree from being unival, but we do not want to increase the count because there are no unival trees at or below this point.
        }
        else if(root.left==null&&root.right==null){
            return new TreeCount(true, 1); //If this root has no branches beneath it, it is necessarily unival.
        }
        TreeCount leftcount = UnivalTreeCount(root.left); //Take the count of all unival trees to the left, as well as whether the left tree is itself unival.
        TreeCount rightcount = UnivalTreeCount(root.right); //Do the same to the right.
        if(leftcount.isUnival&&rightcount.isUnival&&root.left.key==root.key&&root.right.key==root.key){ //If the left and right trees are both unival, and if left and right both match the value of the root, then this tree is unival.
            return new TreeCount(true, (leftcount.count+rightcount.count+1)); //as such, return true, and return the number of unival trees beneath this point, +1 because this tree is unival as well.
        }
        else{
            return new TreeCount(false, (leftcount.count+rightcount.count)); //Otherwise, return false, but still return the number of unival trees beneath this point, because this tree not counting doesn't invalidate them.
        }
      }

}

class Node {
    int key;
    Node left, right;
  
    public Node(int item) {
    key = item;
    left = right = null;
    }
  }
  
  //class for binary tree
  class BinaryTree {
    Node root;
  
    // Traverse tree
    public void traverseTree(Node node) {
      if (node != null) {
        traverseTree(node.left);
        System.out.print(" " + node.key);
        traverseTree(node.right);
      }
    }
  }

  class TreeCount{
    boolean isUnival; //Whether the current tree is a Unival tree or not.
    int count; //The number of unival trees underneath the current tree.
    TreeCount(boolean bool, int thecount){
        this.isUnival=bool;
        this.count=thecount;
    }
  }