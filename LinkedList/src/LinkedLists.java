import java.util.LinkedList;

public class LinkedLists {

		public static void main(String[] args) {
			LinkedList<String> ll = new LinkedList<String>();
			
			ll.add("A");
			ll.add("B");
			ll.addLast("C");
			ll.addFirst("D");
			ll.add("E");
			ll.add(2,"F");
			
			ll.push("Z");
			
			System.out.println(ll);
			if (ll.contains("Z")) System.out.println("Z is in the list.");
			
			String myStr = ll.get(3);
			
			System.out.println(myStr);
			ll.remove("");
			ll.remove(3);
			ll.removeFirst();
			ll.removeLast();
			System.out.println(ll);
		}
	
}
