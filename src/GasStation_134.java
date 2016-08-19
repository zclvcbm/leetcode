import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Admin on 2016/8/18.
 */
class Station{
    int gas;
    int cost;
    int i;
    public Station(int i,int gas, int cost){
        this.i = i;
        this.gas = gas;
        this.cost = cost;
    }
}

public class GasStation_134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int resGas = 0;
        Station stations[] = new Station[gas.length];
        for(int i=0;i<stations.length;i++){
            //radios[i] = gas[i]*1.0/cost[i];
            stations[i] = new Station(i,gas[i],cost[i]);
        }
        Arrays.sort(stations, new Comparator<Station>() {
            @Override
            public int compare(Station o1, Station o2) {
                if(o1.cost*o2.gas==o1.gas*o2.cost)
                    return 0;
                else if(o1.gas*o2.cost<o1.cost*o2.gas)
                    return 1;
                return -1;
            }
        });

        for(int i=0;i<gas.length;i++)
        {
            resGas = resGas+stations[i].gas-stations[i].cost;
            if(resGas<0)
                return -1;
        }
        return stations[0].i;
    }

    public static void main(String[] args){
//        int[] gas = {3,4,5,7,4};
//        int[] cost = {2,4,6,6,2};
/*        int[] gas = {3,4,5,5,4};
        int[] cost = {4,5,6,6,2};*/
        int[] gas = {1,2};
        int[] cost = {2,1};
        canCompleteCircuit(gas,cost);
    }
}
