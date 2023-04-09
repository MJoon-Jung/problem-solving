class Solution {
   public int[] solution(String[] wallpaper) {
       int minX, minY = minX = 51;
       int maxX, maxY = maxX = -1;

       for(int y = 0; y < wallpaper.length; y++) {
           String[] values = wallpaper[y].split("");
           for(int x = 0; x < values.length; x++) {
               if(values[x].equals(".")){
                   continue;
               }
               minX = Math.min(minX, x);
               minY = Math.min(minY, y);
               maxX = Math.max(maxX, x);
               maxY = Math.max(maxY, y);
           }
    	}
    int[] answer = { minY, minX, maxY + 1, maxX + 1 };
    return answer;
   }
}
