/**
*	Enum class to define the characters in maze
*	@author Saroj Tripathi
*
*/
public enum MazeEntry {
	WALL, PATH, ENTRY, EXIT, SOLUTION;
	/**
	*	Static function to set a enum to a character
	*	@param a Character to set
	*	@return Corresponding Enum if found else null
	*/
	public static MazeEntry zuweisen(char a) {
		switch(a) {
			case '#':
				return MazeEntry.WALL;
			case ' ':
				return MazeEntry.PATH;
			case 'e':
				return MazeEntry.ENTRY;
			case 'E':
				return MazeEntry.EXIT;
			default:
				return null;
		}
	}

	/**
	*	Static Method to return corresponding character in maze for the enum type
	*	@param a MazeEntry enum type to define a character in maze
	*	@return Character in the position
	*/
	public static char getchar(MazeEntry a) {
	 	switch(a) {
	 		case WALL:
	 			return '#';
	 		case ENTRY:
	 			return 'e';
	 		case EXIT:
	 			return 'E';
	 		case SOLUTION:
	 			return 'S';
	 		default:
	 			return ' ';
	 	}
	}
}