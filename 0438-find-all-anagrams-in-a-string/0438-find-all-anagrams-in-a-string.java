class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        var r=new ArrayList<Integer>();
        if (s.length()<p.length()) return r;
        var pc = new int[26];
        var sc = new int[26];
        for (var c:p.toCharArray()) pc[c-'a']++;
        var pl =p.length();
        for (int i=0;i<s.length();i++) {
            sc[s.charAt(i)-'a']++;
            if (i>=pl) sc[s.charAt(i-pl)-'a']--;
            if(Arrays.equals(pc, sc)) r.add(i-pl +1);
        } 
        return r;
    }
}