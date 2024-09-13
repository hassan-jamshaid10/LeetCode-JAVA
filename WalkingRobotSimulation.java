class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0; 
        int dir = 0; 
        int maxDist = 0;

     
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

      
        for (int command : commands) {
            if (command == -1) {
                             dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir + 3) % 4;
            } else {
       
                int dx = directions[dir][0];
                int dy = directions[dir][1];
                for (int k = 0; k < command; k++) {
                    int newX = x + dx;
                    int newY = y + dy;
                    if (obstacleSet.contains(newX + "," + newY)) {
                        break; 
                    }
                    x = newX;
                    y = newY;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}