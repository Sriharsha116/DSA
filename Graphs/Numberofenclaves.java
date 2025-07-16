// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(grid[i][0]==1)q.add(new Pair(i,0));
            if(grid[i][m-1]==1)q.add(new Pair(i,m-1));
        }
         for(int j=0;j<m;j++){
            if(grid[0][j]==1)q.add(new Pair(0,j));
            if(grid[n-1][j]==1)q.add(new Pair(n-1,j));
        }
        int[][] vis=new int[n][m];
        
        while(q.size()!=0){
            Pair p=q.poll();
            int r=p.first;
            int c=p.second;
            vis[r][c]=1;
            int[]x={-1,0,1,0};
            int[]y={0,1,0,-1};
            
            for(int k=0;k<4;k++){
                int nrow=r+x[k];
                int ncol=c+y[k];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m  && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
        
    }
}
class Pair{
    int first;
    int second;
    
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}