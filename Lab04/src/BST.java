// Java program to demonstrate
// insert operation in binary
// search tree
class BST {
 
    // Root of BST
    BSTNode root;
 
    // Constructor
    BST() { root = null; }
 
    BST(Dollar value) { root = new BSTNode(value); }
    
 // This method mainly calls deleteRec()
    void deleteKey(Dollar key) { root = deleteRec(root, key); }
 
    /* A recursive function to
      delete an existing key in BST
     */
    BSTNode deleteRec(BSTNode root, Dollar key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        if (key.getValue() < root.key.getValue())
            root.left = deleteRec(root.left, key);
        else if (key.getValue() > root.key.getValue())
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key.setValue(minValue(root.right));
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
 
        return root;
    }
 
    double minValue(BSTNode root)
    {
        double minv = root.key.getValue();
        while (root.left != null)
        {
            minv = root.left.key.getValue();
            root = root.left;
        }
        return minv;
    }
 
 
    // This method mainly calls insertRec()
    void insert(Dollar key) { root = insertRec(root, key); }
 
    /* A recursive function to
       insert a new key in BST */
    BSTNode insertRec(BSTNode root, Dollar key)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key.getValue() < root.key.getValue())
            root.left = insertRec(root.left, key);
        else if (key.getValue() > root.key.getValue())
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
  void printPostorder(BSTNode node)
  {
      if (node == null)
          return;

      // first recur on left subtree
      printPostorder(node.left);

      // then recur on right subtree
      printPostorder(node.right);

      // now deal with the node
      System.out.print(node.key.getValue() + " ");
  }

  /* Given a binary tree, print its nodes in inorder*/
  void printInorder(BSTNode node)
  {
      if (node == null)
          return;

      /* first recur on left child */
      printInorder(node.left);

      /* then print the data of node */
      System.out.print(node.key.getValue() + " ");

      /* now recur on right child */
      printInorder(node.right);
  }

  /* Given a binary tree, print its nodes in preorder*/
  void printPreorder(BSTNode node)
  {
      if (node == null)
          return;

      /* first print data of node */
      System.out.print(node.key.getValue() + " ");

      /* then recur on left subtree */
      printPreorder(node.left);

      /* now recur on right subtree */
      printPreorder(node.right);
  }

  // Wrappers over above recursive functions
  void printPostorder() { printPostorder(root); }
  void printInorder() { printInorder(root); }
  void printPreorder() { printPreorder(root); }
    
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(BSTNode root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
 
    /* Print nodes at the current level */
    void printCurrentLevel(BSTNode root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key.getValue() + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
 
    
}