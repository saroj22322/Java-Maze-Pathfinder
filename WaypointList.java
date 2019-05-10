/**
*	Class to save taken path
*	@author Saroj Tripathi
*
*/
public class WaypointList {
	private int xcord;
	private int ycord;
	private WaypointList next;

	// Constructor function
	WaypointList(int x, int y, WaypointList next) {
		this.setXcord(x);
		this.setYcord(y);
		this.setNext(next);
	}

	WaypointList(int x, int y) {
		this(x, y, null);
	}

	WaypointList() {
		this(0,0,null);
	}

	// Getter and Setter Function start here

	public void setXcord(int x) {
		this.xcord = x;
	}

	public int getXcord() {
		return this.xcord;
	}

	public void setYcord(int y) {
		this.ycord = y;
	}

	public int getYcord() {
		return this.ycord;
	}

	public void setNext(WaypointList next) {
		this.next = next;
	}

	public WaypointList getNext() {
		return this.next;
	}

	// Getter and setter ends here

	/**
	*	Check if the position if already in the linked list (path)
	*	@param X-coordinate to search
	*	@param Y-coordinate to search
	*	@return 1 if found else 0
	*/
	public int contains(int x, int y) {
		if(this.getXcord() == x && this.getYcord() == y) {
			return 1;
		} else {
			for (WaypointList list = this.next; list != null; list = list.getNext()) {
				if(list.getXcord() == x && list.getYcord() == y) {
					return 1;
				}
			}
		}
		return 0;
	}


}