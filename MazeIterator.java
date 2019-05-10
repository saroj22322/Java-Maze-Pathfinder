/**
*	This class calls the maze for iteration.
*	@author Saroj Tripathi
*
*/
public class MazeIterator {

	public static int[][] vektoren = {{0,1},{0,-1},{1,0},{-1,0}};

	/**
	*	Get starting point intialize path and call recursive maze Algorithm
	*	@param myMaze Maze object to play with
	*	@return Solved Maze Path (Linked list)
	*/
	public static WaypointList iterateMaze(Maze myMaze) {
		int[] startPos = myMaze.getStart();
		WaypointList myPath = new WaypointList(startPos[0],startPos[1]);
        myPath = MazeIterator.iterateMazeRec(myMaze,myPath);
        return myPath;
	}


	/**
	*	Iterate through maze and find path using 4 direction vectors
	*	@param myMaze Maze object to play with
	*	@return Null if Path not found else Path
	*/
	public static WaypointList iterateMazeRec(Maze myMaze, WaypointList myPath) {
		for (int[] vektor : MazeIterator.vektoren)  
        { 
        	int newXpos = myPath.getXcord() + vektor[0];
        	int newYpos = myPath.getYcord() + vektor[1];
        	if(newXpos >= 0 && newXpos < myMaze.getWidth() && 
        		newYpos >= 0 && newYpos < myMaze.getHeight()) {
        		if(myMaze.getPos(newXpos, newYpos) == MazeEntry.PATH && 
        			myPath.contains(newXpos, newYpos) == 0) {
        			WaypointList copyPath = new WaypointList(newXpos, newYpos, myPath);
        			copyPath = MazeIterator.iterateMazeRec(myMaze, copyPath);
        			if(copyPath != null) {
        				myPath = new WaypointList(newXpos, newYpos, copyPath);
        				return myPath;
        			}
        		} else if(myMaze.getPos(newXpos, newYpos) == MazeEntry.EXIT){
        			myPath = new WaypointList(newXpos, newYpos, myPath);
        			return myPath;
        		}
        	}
        }
        return null;
	}
}