public class Easy{
    public static void sum(int arr[]){
        int index4 = 0;
        int sum4 =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 4){
                index4 = i;
                break;
            }
            sum4+=arr[i];
        }
        int index7 = 0;
        int sum7 =0;
        String result = "";
        for(int i=index4;i<arr.length;i++){
            result = result + arr[i];
            if(arr[i] == 7){
                index7 = i;
                break;
            }
    
        }
        for(int i=index7+1;i<arr.length;i++){
            sum7+=arr[i];
        }
        int result1 = Integer.parseInt(result);
        int resultfinal = result1 + sum4 + sum7;
        System.out.print(resultfinal);
    }
    public static void main(String[] args) {
        int[] nums = {2, 3,4,8, 5, 7, 11};
        sum(nums);
    }
}