package Stack.Easy.Problem844;
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int length = sb1.length();
            if(s.charAt(i) != '#'){
                sb1.append(s.charAt(i));
            }else if(length > 0){
                sb1.deleteCharAt(length-1);
            }      
        }
        String newS = sb1.toString();
        for(int i=0;i<t.length();i++){
            int length = sb2.length();
            if(t.charAt(i) != '#'){
                sb2.append(t.charAt(i));
            }else if(length > 0){
                sb2.deleteCharAt(length-1);
            }      
        }
        String newT = sb2.toString();
        return newT.equals(newS)?true:false;

    }
}