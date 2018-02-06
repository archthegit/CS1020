import java.util.*;

/******* Class definition for ListNode *******/
class ListNode <E> {
	/* data attributes */
	private E element;
	private ListNode <E> next;

	/* constructors */
	public ListNode(E element) { 
		this(element, null); 
	}

	public ListNode(E element, ListNode <E> next) { 
		this.element = element; 
		this.next = next; 
	}

	public ListNode <E> getNext() {
		return this.next;
	}

	public E getElement() {
		return this.element;
	}

	public void setNext(ListNode <E> next) {
		this.next = next;
	}
}
/******* Class definition for MyLinkedList *******/
class MyLinkedList <E> {

	// Data attributes
	private ListNode <E> head = null;
	private int numNodes = 0;

	// Return true if list is empty; otherwise return false.
	public boolean isEmpty() { 
		return (numNodes == 0);  // or return (head == null);
	}

	// Return number of nodes in list.
	public int size() { 
		return numNodes; 
	}

	// Return value in the first node.
	public E getFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("List is empty!");
		else 
			return head.getElement();
	}

	// Return true if list contains item, otherwise return false.
	public boolean contains(E item) {
		for (ListNode <E> curr = head; curr != null; curr = curr.getNext())
			if (curr.getElement().equals(item)) 
				return true;

		return false;
	}

	// Add item to front of list.
	public void addFirst(E item) {
		head = new ListNode <E> (item, head);
		numNodes++;
	}

	// Remove first node of list.
	public E removeFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("Can't remove from an empty list!");
		else { 
			ListNode <E> first = head;
			head = head.getNext();
			numNodes--;
			return first.getElement();
		}
	}
	public void removeAfter(ListNode <E> current) {
		E temp;
		if (current != null) {
			ListNode<E> nextPtr = current.getNext();
			if (nextPtr != null) {
				temp = nextPtr.getElement();
				current.setNext(nextPtr.getNext());
				numNodes--;
				
			}
		} 
		 else { 
			if (head != null) {
				temp = head.getElement();
				head = head.getNext(); 
				numNodes--;
			}
		}

		}

	public void remove(int count){
		ListNode<E> curr=head;
		for (int i=1;i<count;i++){
				curr=curr.getNext();
			}
			
			removeAfter(curr);
	}

	

	// Return string representation of list.
	public String toString() {
			ListNode <E> ln = head;
			String str= new String();
			str= "["+ln.getElement().toString();
			for (int i=1; i < numNodes; i++) {
				ln = ln.getNext();
				str= (str+", " + ln.getElement());
			}
			str=str+"]";
			return str;
		}

	// Return the number of probes to search item in list.
	public int search(E item) {
		int count=0;
		int flag=1;
		ListNode<E> ln = head;
		
		for (int i=0;i<numNodes;i++){
			if (!ln.getElement().equals(item)){
				
				if (ln.getNext()!=null){
					ln=ln.getNext();
					count++;
				}
			}
			else{
				flag=0;

				break;
			}
		
		}
		if ((flag==0)&&(count>1)){
			this.remove(count);
			this.addFirst(ln.getElement());
			count+=1;
		}
		else{count++;}
	
		return count;
	
	}
	
	
 

}

