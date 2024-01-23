package anoop.test.sample;

import java.util.HashSet;

public class RobotRoomCleaner {
    /*
    You are controlling a robot that is located somewhere in a room.
    The room is modeled as an m x n binary grid where 0 represents a wall and 1 represents an empty slot.

    The robot starts at an unknown location in the root that is guaranteed to be empty,
    and you do not have access to the grid, but you can move the robot using the given API Robot.

    You are tasked to use the robot to clean the entire room (i.e., clean every empty cell in the room).
    The robot with the four given APIs can move forward, turn left, or turn right. Each turn is 90 degrees.

    When the robot tries to move into a wall cell, its bumper sensor detects the obstacle, and it stays on the current cell.

    Input: room = [[1,1,1,1,1,0,1,1],[1,1,1,1,1,0,1,1],[1,0,1,1,1,1,1,1],[0,0,0,1,0,0,0,0],[1,1,1,1,1,1,1,1]], row = 1, col = 3
    Output: Robot cleaned all rooms.
    Explanation: All grids in the room are marked by either 0 or 1.
    0 means the cell is blocked, while 1 means the cell is accessible.
    The robot initially starts at the position of row=1, col=3.
    From the top left corner, its position is one row below and three columns right.

    Input: room = [[1]], row = 0, col = 0
    Output: Robot cleaned all rooms.
     */
    /*public static void main(String[] args) {
        new RobotRoomCleaner().cleanRoom(new Robot() {
            @Override
            public boolean move() {
                return false;
            }

            @Override
            public void turnLeft() {

            }

            @Override
            public void turnRight() {

            }

            @Override
            public void clean() {

            }
        });
    }

    private int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        backTrack(robot, 0, 0, 0);
    }

    private void goBack(Robot robot){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    private void backTrack(Robot robot, int row, int col, int d){
        visited.add(new Pair(row, col));
        robot.clean();

        for(int i=0; i<4; i++){
            int newD = (i+d)%4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];
            Pair newPair = new Pair(newRow, newCol);
            if(!visited.contains(newPair) && robot.move()){
                backTrack(robot, newRow, newCol, newD);
                goBack(robot);
            }
            robot.turnRight();
        }
    }

     // This is the robot's control interface.
     // You should not implement it, or speculate about its implementation
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();
        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();
        // Clean the current cell.
        public void clean();
    }*/
}
