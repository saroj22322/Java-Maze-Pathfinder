/**
*	Main class to call main function and 
*	start the program
*	@author Saroj Tripathi
*/
public class Application {
	public static void main(String[] args) {
		String m1 = "33 33\n"
          + "#########e#######################\n"
          + "#                 #           # #\n"
          + "# ######### ### ### ### ##### # #\n"
          + "# #   #   #   #   # # # #   # # #\n"
          + "# # ### # ####### # # # # # # # #\n"
          + "# # #   #     #   # # # # # #   #\n"
          + "# # # ####### # ### # # # # ### #\n"
          + "# # #       # #     # #   # # # #\n"
          + "# # ##### # # ##### # ####### # #\n"
          + "#   #   # # #     # # #         #\n"
          + "##### # # # ##### # # # #########\n"
          + "#   # # # #     # # # # #     # #\n"
          + "# # # # # ####### # # # ### # # #\n"
          + "# #   # # #       # # #     #   #\n"
          + "# ### # ### ####### # ######### #\n"
          + "# #   #   # #     # # #     #   #\n"
          + "# # ### # # # ### # # # ### # ###\n"
          + "# # #   #   #   #   # # #   #   #\n"
          + "### ########### ##### # ####### #\n"
          + "#         #   #       # #     # #\n"
          + "# ### ### # ##### ##### # # # # #\n"
          + "# # # # #       #     # # # # # #\n"
          + "# # # # ####### ##### # # # ### #\n"
          + "# #   # #       #   # #   #     #\n"
          + "# ### # # ####### # # ####### ###\n"
          + "#   # # #   #     # # #       # #\n"
          + "### # # ##### ##### # # ####### #\n"
          + "#   # #         #   # #       # #\n"
          + "# # ##### ##### # ### # ####### #\n"
          + "# #     # #   # #   # # #       #\n"
          + "# ##### # # # # ### # # # ### ###\n"
          + "#     #   # #     #   #   #     #\n"
          + "#######################E#########";
		Maze myMaze = new Maze(m1);
		WaypointList myPath = MazeIterator.iterateMaze(myMaze);
		if(myPath != null) {
			myMaze.setSolution(myPath);
			myMaze.print();
		} else {
			System.out.println("No path found!!");
		}
	}
}