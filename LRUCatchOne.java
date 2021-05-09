// in this implimentation i have used linked hash set for tracking
import java.util.*;

public class LRUCatchOne {
	private int capacity;
	private HashMap<Integer,Integer> map;
	private LinkedHashSet<Integer> linkedSet;
	public LRUCatchOne(int capacity){
		this.capacity=capacity;
		this.linkedSet = new LinkedHashSet<>(capacity);
		this.map = new HashMap<>();
	}
	
	public int get(int key) {
		if(linkedSet.contains(key)) {
			linkedSet.remove(key);
			linkedSet.add(key);
			return map.get(key);
		}else {
			return -1;
		}
	}
	
	public void put(int key, int value) {
        if(linkedSet.contains(key)){
            linkedSet.remove(key);
            linkedSet.add(key);
            map.remove(key);
            map.put(key,value);
            return;
        }
        if(linkedSet.size()>this.capacity-1){
        	Object[] ar = linkedSet.toArray();
        	int temp = (int)ar[0];
            linkedSet.remove(ar[0]);
            map.remove(temp);
            linkedSet.add(key);
            map.put(key,value);
        }else{
            linkedSet.add(key);
            map.put(key,value);
        }
    }
}
