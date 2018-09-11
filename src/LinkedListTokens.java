/*
 * Use linked list to store tokens
 */
public class LinkedListTokens {
	private Link first;
	private Link last;

	public LinkedListTokens() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	//Not implemented yet
	public int getLength() {
		Link temp = first;
		  int counter = 0;
		  while(temp != null){
		   temp = temp.next;
		   counter++;
		   }
		   return counter; 
	}

	public String insertFirst(String s) {
		Link newLink = new Link(s);

		if (isEmpty()) {
			last = newLink;
		}
		else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = last;
		return s;
	}

	public void insertLast(String s) {
		Link newLink = new Link(s);
		if(isEmpty()) {
			first = newLink;
		} else{
			last.next = newLink;
			newLink.previous = last;
		}

		last = newLink;
	}

	public Link deleteFirst() {
		Link temp = first; //assume list is not empty
		if(first.next == null) { //only one item in the list
		last = null;
		} else {
			first.next.previous = null;

		}
		first = first.next;
		return temp;
	}

	



}
