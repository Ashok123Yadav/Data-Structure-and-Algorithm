import java.util.LinkedList; 
import java.util.Queue;


public class BinaryTreeInsertion {

	int key; 
	BinaryTreeInsertion left, right; 
	
	BinaryTreeInsertion(int key){ 
		this.key = key; 
		left = null; 
		right = null; 
	} 

static BinaryTreeInsertion root; 
static BinaryTreeInsertion temp = root; 

static void inorder(BinaryTreeInsertion temp) 
{ 
	if (temp == null) 
		return; 

	inorder(temp.left); 
	System.out.print(temp.key+" "); 
	inorder(temp.right); 
} 


static void insert(BinaryTreeInsertion temp, int key) 
{ 
	Queue<BinaryTreeInsertion> q = new LinkedList<BinaryTreeInsertion>(); 
	q.add(temp); 

	while (!q.isEmpty()) { 
		temp = q.peek(); 
		q.remove(); 

		if (temp.left == null) { 
			temp.left = new BinaryTreeInsertion(key); 
			break; 
		} else
			q.add(temp.left); 

		if (temp.right == null) { 
			temp.right = new BinaryTreeInsertion(key); 
			break; 
		} else
			q.add(temp.right); 
		}
	} 
	public static void main(String[] args) {
		
		root = new BinaryTreeInsertion(10); 
		root.left = new BinaryTreeInsertion(11); 
		root.left.left = new BinaryTreeInsertion(7); 
		root.right = new BinaryTreeInsertion(9); 
		root.right.left = new BinaryTreeInsertion(15); 
		root.right.right = new BinaryTreeInsertion(8); 
	
		System.out.print( "Inorder traversal before insertion:"); 
		inorder(root); 
	
		int key = 12; 
		insert(root, key); 
	
		System.out.print("\nInorder traversal after insertion:"); 
		inorder(root); 

	}

}

