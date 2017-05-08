/**
 * Created by udingji on 5/5/17.
 */
public class GasStation {


    // Idea: premise: unique solution (one or no solution)
    // Calculate the total gas and total cost. If total cost is greater than total gas, there is no solution.
    // Iterate through each gas station while keep track of the gas left in the tank
    // If the gas left is negative, there is no way to get to this point from any previous gas station. Set the next gas station as the new start position and reset tank
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, start = 0, tank = 0;

        for (int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            tank += (gas[i] - cost[i]);
            if (tank < 0){
                start = i + 1;
                tank = 0;
            }
        }

        if (totalCost > totalGas){
            return -1;
        }

        return start;
    }

    // TLE
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//
//        if (gas == null || cost == null || gas.length != cost.length)
//            return -1;
//
//        for (int i = 0; i < gas.length; i++){
//            boolean nextI = false;
//            int gasLeft = 0;
//            for (int j = i; j < gas.length; j++){
//                gasLeft += gas[j];
//                if (gasLeft-cost[j] < 0){
//                    nextI = true;
//                    break;
//                }
//                gasLeft -= cost[j];
//            }
//            if (nextI)
//                continue;
//            for (int k = 0; k < i; k++){
//                gasLeft += gas[k];
//                if (gasLeft-cost[k] < 0){
//                    nextI = true;
//                    break;
//                }
//                gasLeft -= cost[k];
//            }
//            if (nextI)
//                continue;
//            return i;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        int[] gas = {1,2};
        int[] cost = {2,1};

        System.out.println(canCompleteCircuit(gas,cost));
    }
}
