class Solution {
    private static int day(String s){
        int [] arr={0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int n=Integer.parseInt(s.substring(0,2));
        int res=Integer.parseInt(s.substring(3));
        for(int i=0;i<n;i++){
            res+=arr[i];
        }
        return res;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        if(day(arriveAlice)<=day(arriveBob) && day(leaveAlice)>=day(arriveBob)){
            if(day(arriveAlice)<=day(leaveBob) && day(leaveAlice)>=day(leaveBob)){
                return day(leaveBob)-day(arriveBob)+1;
            }
            return day(leaveAlice)-day(arriveBob)+1;
        }else if(day(arriveBob)<=day(arriveAlice) && day(leaveBob)>=day(arriveAlice)){
            if(day(arriveBob)<=day(leaveAlice) && day(leaveBob)>=day(leaveAlice)){
                return day(leaveAlice)-day(arriveAlice)+1;
            }
            return day(leaveBob)-day(arriveAlice)+1;
        }else{
            return 0;
        }
    }
}