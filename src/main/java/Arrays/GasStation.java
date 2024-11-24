package Arrays;

public class GasStation {

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        for(int i=0; i<gas.length; i++){
//            if(gas[i] > cost[i] && canComplete(gas, cost, i)){
//                return i;
//            }
//        }
//        return -1;
//    }

    private boolean canComplete(int[] gas, int[] cost, int index){
        boolean isComplete = false;
        int temp = index;
        int tank = gas[index];
        while(!isComplete){
            tank = gas[temp]-cost[temp];
            if(temp >= gas.length){
                temp = 0;
            }
            tank = tank+gas[temp];
            if(temp+1 < gas.length && tank >= gas[temp+1]){
                temp++;
            }
            else{
                return false;
            }
        }
        return true;
    }


    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];
            totalTank += netGas;
            currTank += netGas;
            if (currTank < 0) {
                startingStation = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startingStation : -1;
    }


    public static void main(String[] args) {

        GasStation gs = new GasStation();
        System.out.println(gs.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(gs.canCompleteCircuit(new int[]{2,3,4}, new int[]{2,3,4}));

    }
}
