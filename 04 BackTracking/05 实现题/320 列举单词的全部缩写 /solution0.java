//转变思路——每个字母是否要保留/还是替换成数字
//替换成数字时，数字需要累加
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, "", word, 0, 0);
        return res;
    }
    private void helper(List<String> res, String s, String word, int index, int count){
        if( index == word.length()){
            if(count > 0){
                s += count;
            }
            res.add(s);
            return;
        }else{
            helper(res, s, word, index+1, count+1);
            helper(res, s + (count>0? count : "" )+ word.charAt(index), word, index+1, 0);
        }
    }
}