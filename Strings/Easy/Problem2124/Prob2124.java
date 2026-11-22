class Solution {
    public boolean checkString(String s) {
        int index = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a'){
                continue;
            }else{
                index = i;
                break;
            }
        }
        if(index != -1){
            for(int i=index+1;i<s.length();i++){
                if(s.charAt(i)=='a'){
                    return false;
                }
            }
        }
        return true;
    }
}