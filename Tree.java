public class Tree
{
    public static Tnode root;

    public static Tnode insert_og_order(String[] arr, Tnode root, int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            Tnode temp = new Tnode(arr[i]);
            root = temp;

            // insert left child
            root.left = insert_og_order(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = insert_og_order(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    // Function to print tree nodes in InOrder fashion
    public static void inOrder(Tnode root)
    {
        if (root != null)
        {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

}
