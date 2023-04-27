import java.io.*;
import java.util.*;

class Main {

    int[][] board = new int[51][51];
    int[] dx = { 1, 0, -1 , 0 };
    int[] dy = { 0, 1, 0, -1 };

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = toInt(st);
        int M = toInt(st);

        List<int[]> store = new ArrayList<>();
        List<int[]> cities = new ArrayList<>();
        int cIdx = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = toInt(st);
                if(board[i][j] == 0) continue;

                int[] ar = new int[2];
                ar[0] = i;
                ar[1] = j;
                if(board[i][j] == 2) store.add(ar);
                else if(board[i][j] == 1) cities.add(ar);
            }
        }

        // 치킨집 하나씩 bds로 거리를 담은 board를 만든다.
        List<int[][]> distanceBoard = new ArrayList<>();
        for(int[] s: store) {
            int[][] ar = new int[N][N];
            for(int i = 0; i < N; i++) Arrays.fill(ar[i], 0);
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(s[0], s[1]));
            while(!q.isEmpty()) {
                Point p = q.poll();

                for(int dir = 0; dir < 4; dir++) {
                    int nx = p.x + dx[dir];
                    int ny = p.y + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(ar[nx][ny] != 0) continue;
                    ar[nx][ny] = ar[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
            distanceBoard.add(ar);
        }

        // 치킨집 M개 조합 리스트를 만든다.
        int result = Integer.MAX_VALUE;
        List<int[]> combisList = generate(store.size(), M);
        
        // 치킨집 M개 조합 순회
        for(int[] combis: combisList) {
            // 도시까지의 최소 거리를 담을 배열 선언
            int[] total = new int[cities.size()];
            Arrays.fill(total, 3000);
            // 치킨집 idx값
            for(int val : combis) {
                int[][] dis = distanceBoard.get(val);
                // 도시 순회
                for(int i = 0; i < cities.size(); i++) {
                    // 배열에서 도시까지 거리 꺼내기
                    total[i] = Math.min(total[i], dis[cities.get(i)[0]][cities.get(i)[1]]);
                }
            }
            result = Math.min(result, Arrays.stream(total).sum());
        }
        System.out.println(result);
    }

    List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1, 0);
        return combinations;
    }

    void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if(index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    int toInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException  {
        new Main().solution();
    }
}
