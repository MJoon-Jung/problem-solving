import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> result = new ArrayList<>();
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean[][] check = new boolean[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'X' || check[i][j]) continue;
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i,j));
                check[i][j] = true;
                int sum = 0;
                while(!queue.isEmpty()) {
                    Point p = queue.poll();
                    sum += (maps[p.x].charAt(p.y) - '0');

                    for(int dir = 0; dir < 4; dir++) {
                        int nx = p.x + dx[dir];
                        int ny = p.y + dy[dir];

                        if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()) continue;
                        if(maps[nx].charAt(ny) == 'X' || check[nx][ny]) continue;
                        check[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
                result.add(sum);
            }
        }
        if(result.size() == 0) result.add(-1);
        return result.stream()
                    .mapToInt(Integer::intValue)
                    .sorted()
                    .toArray();
    }
}
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

