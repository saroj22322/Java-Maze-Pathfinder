/**
*	Maze Class to implement Maze as Object
*	@author Saroj Tripathi
*/
public class Maze {

	private MazeEntry[][] maze2D;
	private int height;
	private int width;
	public final int dimension = 2;

	/**
	*	Constructor function for Maze
	*	@param mazeString Structure of maze as string
	*/
	Maze(String mazeString){
		String mazeDimension = mazeString.substring(0,mazeString.indexOf('\n'));

		String mazeHeight = mazeDimension.substring(0, mazeDimension.indexOf(' '));
		String mazeWidth = mazeDimension.substring(mazeDimension.indexOf(' ') + 1);
		this.height = Integer.parseInt(mazeHeight);
		this.width = Integer.parseInt(mazeWidth);

		this.maze2D = new MazeEntry[this.height][this.width];

		String mazePath = mazeString.substring(mazeString.indexOf('\n') + 1);

		char[] mazeChar = mazePath.toCharArray();
		int k = 0;
		for (int i = 0; i < this.height ; i++) {
			for (int j = 0;j < this.width ; j++) {
				this.maze2D[i][j] = MazeEntry.zuweisen(mazeChar[k]);
				k++;
			}
			k++;
		}
	}

	// Setter and Getter functions start here

	public void setPos(int x, int y, MazeEntry data) {
		this.maze2D[x][y] = data;
	}

	public MazeEntry getPos(int x, int y) {
		return this.maze2D[x][y];
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	// Getter and Setter Functions end here

	/**
	*	Method to give starting point in maze
	*	@return Starting point coordinates as array
	*/
	public int[] getStart(){
		int[] pos = new int[this.dimension];
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width ; j++) {
				if(this.maze2D[i][j] == MazeEntry.ENTRY) {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}

	/**
	*	Print the whole maze structure
	*/
	public void print() {
		for (int i = 0; i < this.height ; i++) {
			for (int j = 0; j < this.width ; j++) {
				System.out.print(MazeEntry.getchar(this.maze2D[i][j]));
			}
			System.out.println();
		}
	}

	/**
	*	Set the solution in the structure of maze
	*	@param path Way to follow for solution
	*/
	public void setSolution(WaypointList path) {
		for (WaypointList list = path; list != null; list = list.getNext()) {
			MazeEntry current = this.getPos(list.getXcord(), list.getYcord());
			if(current == MazeEntry.PATH) {
				this.setPos(list.getXcord(), list.getYcord(), MazeEntry.SOLUTION);
			}
		}
	}
}