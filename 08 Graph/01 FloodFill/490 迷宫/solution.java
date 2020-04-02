class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //方法1：深度优先搜索
        boolean [][] visited=new boolean[maze.length][maze[0].length];
        return dfs(maze,start,destination,visited);
    }

    public boolean dfs(int [][] maze, int []start, int [] destination,boolean [] [] visited){
        if(visited[start[0]][start[1]])
            return false;
        if(start[0]==destination[0]&&start[1]==destination[1])
            return true;
        visited[start[0]][start[1]]=true;
        int r=start[1]+1,l=start[1]-1,u=start[0]-1,d=start[0]+1;  //四个方向
        while(r<maze[0].length&&maze[start[0]][r]==0) //右边可以搜索
        {
            r++;
        }
        if(dfs(maze,new int[]{start[0],r-1},destination,visited))
            return true;
        while(l>=0&&maze[start[0]][l]==0)  //左边可以搜索
        {
            l--;
        }
        if(dfs(maze,new int[]{start[0],l+1},destination,visited))
            return true;
        while(u>=0&&maze[u][start[1]]==0)  //上边可以搜索
        {
            u--;
        }
        if(dfs(maze,new int[]{u+1,start[1]},destination,visited))
            return true;
        while(d<maze.length&&maze[d][start[1]]==0)  //下边可以搜索
        {
            d++;
        }
        if(dfs(maze,new int[]{d-1,start[1]},destination,visited))
            return true;
        //如果之前搞了这些都失败了
        return false;
    }
}