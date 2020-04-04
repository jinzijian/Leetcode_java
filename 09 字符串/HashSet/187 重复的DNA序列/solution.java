//hashset 解法； 
//hashset.add 返回 true和false（没有重复返回true，重复返回false)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>(); 
        HashSet<String> repeated = new HashSet<>();
        for(int i = 0; i < s.length() - 9; i++){
            String temp = s.substring(i, i + 10);
            if(!seen.add(temp)){
                repeated.add(temp);
            }
        }
        return new ArrayList<>(repeated);
    }
}