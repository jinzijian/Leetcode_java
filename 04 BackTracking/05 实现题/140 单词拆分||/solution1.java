//DFS+记忆化思路：
//Step1:拆解子问题
//Step2：保存子问题的值并返回到上一层
//Step3：解拼接到最后的结果上

class Solution {
    //定义hashmap为记忆化做准备
    //HashMap本质储存的是一个子问题的解或者解集（存储的是递归里一个小递归的结果）
    //所以HashMap存储的值得形式一定和要求的解形式一致
    HashMap<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    private List<String> helper(String s, List<String> wordDict, int start) {
        //当子问题已经被解决过的时候传回之前存储好的的结果
        if(map.containsKey(start)){
            return map.get(start);
        }
        //创建一个变量去存储每一层的答案
        List<String> res = new ArrayList<>();
        //当这层递归走到最后也没有解得情况下，res维持不变
        if(start == s.length()){
            res.add("");
        }
        for(int end = start + 1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start,end))){
                //创建一个变量来接上一层子问题的结果
                List<String> list = helper(s, wordDict, end);
                //拼接出这一层的答案
                for(String sinl:list){
                    res.add(s.substring(start,end) + (sinl.equals("")? "":" ") + sinl);
                }        
            } 
        } 
        //将这个解存入map中 
        map.put(start,res);
        //返回这一层的答案
        return res;        
    }
}