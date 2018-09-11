

public class Link {
	String s;
	Link next;
	Link previous;
	
	public Link (String string) {
		this.s = string;
		this.next = null;
		this.previous = null;
	}
	
	public void displayLink() {
		System.out.print(s + " ");
	}

	public Link getNext() {
		return next;
	}
}
