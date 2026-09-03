class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        while(read < chars.length){
            int count = 0;
            char currentchar = chars[read];
            while((read < chars.length) && (currentchar == chars[read])){
                read++;
                count++;
            }
            chars[write++] = currentchar;
            if(count > 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}