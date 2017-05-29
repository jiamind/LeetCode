/**
 * Created by jmding on 5/28/17.
 */
public class WaterAndJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {

        if (x + y < z)
            return false;

        // In case x or y is zero
        if (x == z || y == z || x + y == z)
            return true;

        return z % gcd(x,y) == 0;
    }

    private int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
