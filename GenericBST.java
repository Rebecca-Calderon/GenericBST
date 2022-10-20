
	// Rebecca Calderon
	// NID: 4877902
	// COP 3503, Fall 2022

	// ====================
	// GenericBST: BST.java
	// ====================
	// Basic binary search tree (BST) implementation that supports insert() and
	// delete() operations. This framework is provided for you to modify as part of
	// Programming Assignment #2.


	import java.io.*;
	import java.util.*;

	class Node <T>
	{
		T data;
		Node<T> left, right;

		Node(T data)
		{
			this.data = data;
		}
	}
	// here the type parameter is supporing the comparison with other
	// instances of its own type
	public class GenericBST<T extends Comparable <T>>
	{
		private Node<T> root;
		
		// this public method is delegating a call to the private method 
		// same name, different parameters
		public void insert(T data) 
		{
			root = insert(root, data);
		}

		// we compare the data in the root node to see where exactly the node will be placed in the tree 
		// either to left if less than root and right if greater than root
		private Node<T> insert(Node<T> root, T data) 
		{
			if (root == null)
			{
				return new Node<T>(data); 
			}
			else if (data.compareTo(root.data) < 0)
			{
				root.left = insert(root.left, data);
			}
			else if (data.compareTo(root.data) > 0)
			{
				root.right = insert(root.right, data);
			}
			
			// returning root of newly updated tree with new node
			return root;
		}


		// this public method is delegating a call to the private method 
		// this ensures that the private method is still accessible 
		public void delete(T data) 
		{
			root = delete(root, data);
		}
		
		// This method is deleting from one of three places:
		// the leaf, a one child node, or a two children node
		private Node<T> delete(Node<T> root, T data)
		{
			if (root == null)
			{
				return null;
			}
			// going into the left subtree
			else if (data.compareTo(root.data) < 0)
			{
				root.left = delete(root.left, data);
			}
			// going into the right subtree
			else if (data.compareTo(root.data) > 0)
			{
				root.right = delete(root.right, data);
			}
			// deleting from root here 
			else
			{
				if (root.left == null && root.right == null)
				{
					return null;
				}
				// nodes with one or no child
				else if (root.left == null)
				{
					return root.right;
				}
				else if (root.right == null)
				{
					return root.left;
				}
				// grabbing largest value in right subtree to be replacement for deleted node
				else // two children deletion
				{
					root.data = findMax(root.left);
					root.left = delete(root.left, root.data); 
				}
			}
			// returning new updated bst after deletion
			return root; 
		}


		// This method assumes root is non-null, since this is only called by
		// delete() on the left subtree, and only when that subtree is not empty.
		// returns the largest values right subtree from deletion method
		private T findMax(Node<T> root)
		{
			while (root.right != null)
			{
				root = root.right;
			}

			return root.data;
		}


		// this public method is delegating a call to the private method 
		// this ensures that the private method is still accessible 
		public boolean contains(T data)
		{
			return contains(root, data);
		}

		// this method checks if specific node and value are in the bst
		// it returns true if found, else false
		private boolean contains(Node<T> root, T data)
		{
			if (root == null)
			{
				return false;
			}
			else if (data.compareTo(root.data) < 0)
			{
				return contains(root.left, data);
			}
			else if (data.compareTo(root.data) > 0)
			{
				return contains(root.right, data);
			}
			else
			{
				return true;
			}
		}
		

		// this public method is delegating a call to the private method 
		// this ensures that the private method is still accessible 
		public void inorder()
		{
			System.out.print("In-order Traversal:");
			inorder(root);
			System.out.println();
		}

		// this method outputs value of nodes in tree in a specific order
		// traversing from left subree to the root and then to the right subtree
		private void inorder(Node<T> root)
		{
			if (root == null)
				return;

			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}


		// this public method is delegating a call to the private method 
		// this ensures that the private method is still accessible 
		public void preorder()
		{
			System.out.print("Pre-order Traversal:");
			preorder(root);
			System.out.println();
		}

		// this method outputs value of nodes in tree in a specific order
		// traversing from the root to the left subtree and then to the right
		private void preorder(Node<T> root)
		{
			if (root == null)
				return;

			System.out.print(" " + root.data);
			preorder(root.left);
			preorder(root.right);
		}


		// this public method is delegating a call to the private method 
		// this ensures that the private method is still accessible 
		public void postorder()
		{
			System.out.print("Post-order Traversal:");
			postorder(root);
			System.out.println();
		}

		// this method outputs value of nodes in tree in a specific order
		// traversing from the left subtree, to the right, and then to the root
		private void postorder(Node<T> root)
		{
			if (root == null)
				return;

			postorder(root.left);
			postorder(root.right);
			System.out.print(" " + root.data);
		}

		
		public static void main(String [] args)
		{
			GenericBST<Integer> myTree = new GenericBST<Integer>();

			for (int i = 0; i < 5; i++)
			{
				int r = (int)(Math.random() * 150) + 1;
				System.out.println("Inserting " + r + "...");
				myTree.insert(r);
			}

			myTree.inorder();
			myTree.preorder();
			myTree.postorder();
		}
		
		public static double difficultyRating()
		{
			return 1.0;	
		}
		public static double hoursSpent()
		{
			return 4.0;
		}
	}


