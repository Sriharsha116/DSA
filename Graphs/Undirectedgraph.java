class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adjl=new ArrayList<>();
        int n=edges.length;
        
        for(int i=0;i<V;i++){
            adjl.add(new ArrayList<>()); //since we have v vertices
        }
        
        for(int i=0;i<n;i++){
            adjl.get(edges[i][0]).add(edges[i][1]);
            adjl.get(edges[i][1]).add(edges[i][0]);
        }
       boolean[]vis=new boolean[V]; //since we are having v vertices

      //Remember this for loop is important has it contain multiple components
       for(int i=0;i<V;i++){
           if(!vis[i]){
               if(bfs(adjl,vis,i))return true; 
           }
       }
       return false;
       
    } 
    public boolean bfs(ArrayList<ArrayList<Integer>> adjl,boolean[] vis,int startn){
       Queue<Pair>q=new LinkedList<>();
       q.add(new Pair(startn,-1));
       vis[startn]=true;
       while(q.size()!=0){
           Pair p=q.poll();
           int child=p.first;
           int parent=p.second;
           for(Integer i:adjl.get(child)){
               if(vis[i]!=true){
                   q.add(new Pair(i,child));
                   vis[i]=true;
               }
               else{
                  if(i!=parent) return true;
               }
           }
       }
       return false;
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