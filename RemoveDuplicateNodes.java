import java.util.*;

public class RemoveDuplicateNodes {
	
	public void removeNodes(Node head) {
		HashSet<Integer> set = new HashSet<>();
		Node current = head;
		Node previous = null;
		while(current !=null) {
			if(set.contains(current.val)) {
				previous.next=current.next;
			}else {
				set.add(current.val);
				previous=current;
			}
			current = current.next;
		}
	}
	class Node{
        int val;
        Node next;
 
        public Node(int val)
        {
            this.val = val;
        }
    }

}
