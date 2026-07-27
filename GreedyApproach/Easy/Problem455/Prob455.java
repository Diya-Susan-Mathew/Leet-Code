class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookiePtr=0,childPtr =0;
        while((cookiePtr<s.length) && (childPtr < g.length)){
            if(s[cookiePtr] >= g[childPtr]){
                cookiePtr++;
                childPtr++;
            }else if(s[cookiePtr]<g[childPtr]){
                cookiePtr++;
            }
        }
        return childPtr;
    }
}