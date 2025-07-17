class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>>adjl=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adjl.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
           adjl.get(edges[i][0]).add(edges[i][1]);
           adjl.get(edges[i][1]).add(edges[i][0]);
           
        }
        int[] vis=new int[V];
        boolean[] col=new boolean[V];
        boolean color=false;
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                dfs(adjl,vis,col,i,color);
            }
        }
        
        for(int i=1;i<V;i++){
            if(col[i]!=col[i-1])continue;
            else return false;
        }
        return true;
        
        
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adjl,int[] vis,boolean[] col,int node,boolean color){
        col[node]=color;
        for(Integer i:adjl.get(node)){
            if(vis[i]!=1){
                vis[i]=1;
                dfs(adjl,vis,col,i,!color);
               
            }
        }
    }
}