class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        Queue<Pair>q=new LinkedList<>();
         for (int i = 0; i < n; i++) 
         { 
            if (board[i][0] == 'O') q.add(new Pair(i, 0));  //checking first row if it conatains 'O'
            if (board[i][m - 1] == 'O') q.add(new Pair(i, m - 1)); //checking last row if it conatains 'O'
         }
        for (int j = 0; j < m; j++) 
        {
            if (board[0][j] == 'O') q.add(new Pair(0, j)); //checking first col if it conatains 'O'
            if (board[n - 1][j] == 'O') q.add(new Pair(n - 1, j));//checking last col if it conatains 'O'
        }
        
        
        int[][] vis=new int[n][m];
        while(q.size()!=0){
            Pair p=q.poll();
            int r=p.first;
            int c=p.second;
            vis[r][c]=1;
            int[] x={-1,0,1,0};
            int[] y={0,1,0,-1};

              for(int k=0;k<4;k++)
                 {
                    int nrow=r+x[k];
                    int ncol=c+y[k];

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O' && vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
 
        
           for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(vis[i][j]==0 && board[i][j]=='O'){
                      board[i][j]='X';
                    }
                }
            }
          

    }
}
class Pair{
    int first;
    int second;
    Pair(int x,int y){
        this.first=x;
        this.second=y;
    }
}