import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    ArrayList<String> res = new ArrayList<String>();
    StringBuilder list = new StringBuilder();
    List<List<String>>  re = new ArrayList<List<String>>();
    public ArrayList<String> Permutation(String str) {
        int[] vis = new int[str.length()];//0表示没被访问过
        if(str.length()==0){
            String st = "";
            res.add(st);
            return res;
        }
        //[a-z]转换为[1-26][A-Z]转换为[27-]
        //for(int i=0;i<str.length();i++) count[str.charAt(i)-'a'+1]++;
        dfs(str,vis,0);
        return res;

    }
    public void dfs(String str, int[] vis, int index){
        String s = list.toString();
        if(index==str.length())  res.add(s);//还是复制
        for(int i=0;i<str.length();i++){
            if(vis[i]==1) continue;
            vis[i]=1;
            list.append(Character.toString(str.charAt(i)));
            dfs(str,vis,index+1);
            vis[i]=0;
            list.deleteCharAt(list.length()-1);
        }

    }
}