import java.util.Stack;

public class PostOrder {
	class Node{
	    int val;
	    Node left, right;
	 
	    Node(int value){
	        val = value;
	        left = right;
	    }
	}
	
	public void postOrderIterative(Node root) {
        Stack<Node> stk = new Stack<>();
        while(true) {
            while(root != null) {
                stk.push(root);
                stk.push(root);
                root = root.left;
            }
            if(stk.empty()) return;
            root = stk.pop();
             
            if(!stk.empty() && stk.peek() == root) root = root.right;
             
            else {
                 
                System.out.print(root.val + " "); root = null;
            }
        }
    }

}