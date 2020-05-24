class Solution {
    public int compareVersion(String version1, String version2) {
        //用.分割并转换为数字
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        int i = 0;
        for(int j = 1; j < version1.length(); j++) {
            if(version1.charAt(j) == '.') {
                v1.add(Integer.parseInt(version1.substring(i, j)));
                i = j + 1;
            }
        }
        v1.add(Integer.parseInt(version1.substring(i, version1.length())));
        int m = 0;
        for(int n = 1; n < version2.length(); n++) {
            if(version2.charAt(n) == '.') {
                v2.add(Integer.parseInt(version2.substring(m, n)));
                m = n + 1;
            }
        }
        v2.add(Integer.parseInt(version2.substring(m, version2.length())));
        //注意要选取最大的长度
        for(int k = 0; k < Math.max(v1.size(), v2.size()); k++) {
            //避免越界用？ 并置零
            int num1 = k < v1.size() ? v1.get(k) : 0;
            int num2 = k < v2.size() ? v2.get(k) : 0;
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
        }
        return 0;
    }
}