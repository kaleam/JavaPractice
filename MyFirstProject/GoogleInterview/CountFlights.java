package GoogleInterview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CountFlights {
    private int maxFlightsInAir(Integer[][] flights){
        Arrays.sort(flights,(a,b)-> a[1]-b[1]);
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(flights[0]);
        int tempAns = 1;
        int ans = 1;

        for(int i=1;i<flights.length;i++){
            Integer[] currFlight = flights[i];
            Integer[] firstFlight = queue.peek();

            if(currFlight[0] < firstFlight[1]){
                queue.add(currFlight);
                tempAns++;
            }
            else{
                while(currFlight[0] >= firstFlight[1] && !queue.isEmpty()){
                    queue.remove();
                    tempAns--;
                }
                queue.add(currFlight);
                tempAns++;
            }
            ans = Math.max(ans,tempAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[][] flights = new Integer[][]{{1,5},{2,4},{4,6}};
        CountFlights countFlights = new CountFlights();
        System.out.println(countFlights.maxFlightsInAir(flights));
    }
}
