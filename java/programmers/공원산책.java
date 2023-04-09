class Solution {
    public int[] solution(String[] park, String[] routes) {
        boolean[][] board = makeBoard(park);
        Point point = startPoint(park);

        for (int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            String dir = route[0];
            int cnt = Integer.parseInt(route[1]);
            
            if (dir.equals("N") && point.getX() - cnt >= 0) {
                boolean flag = false;
                for(int j = 1; j <= cnt; j++) {
                    if(!board[point.getX() - j][point.getY()]) {
                        flag = true;
                    }
				}
                if(!flag) {
                        point.moveX(cnt * -1);                    
                }
            } else if (dir.equals("S") && point.getX() + cnt < park.length) {
                boolean flag = false;
                for(int j = 1; j <= cnt; j++) {
                    if(!board[point.getX() + j][point.getY()]) {
                        flag = true;
                    }
				}
                if(!flag) {
                    point.moveX(cnt);
                }
            } else if (dir.equals("W") && point.getY() - cnt >= 0) {
                boolean flag = false;
                for(int j = 1; j <= cnt; j++) {
                    if(!board[point.getX()][point.getY() - j]) {
                        flag = true;
                    }
				}
                if(!flag) {
                        point.moveY(cnt * -1);                    
                }
            } else if (dir.equals("E") && point.getY() + cnt < park[0].length()) {	
                boolean flag = false;
                for(int j = 1; j <= cnt; j++) {
                    if(!board[point.getX()][point.getY() + j]) {
                        flag = true;
                    }
				}
                if(!flag) {
                    point.moveY(cnt);       
                }
            }
        }

        return new int[]{point.getX(), point.getY()};
    }

    private Point startPoint(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    private boolean[][] makeBoard(String[] park) {
        boolean[][] board = new boolean[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                board[i][j] = park[i].charAt(j) != 'X';
            }
        }
        return board;
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveX(int dx) {
        this.x += dx;
    }

    public void moveY(int dy) {
        this.y += dy;
    }
}
