class Solution {
    private String[] mapping = new String[] {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        helper(res, "", digits, 0);
        return res;
    }
    public void helper(List<String> res, String s, String digits, int index){
        if(s.length() == digits.length()){
            res.add(s);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++){
            helper(res,s+letters.charAt(i),digits,index+1);
            //避免值传递带来的麻烦直接将其放进函数参数中，使用局部变量避免回溯操作
        }
    }
}