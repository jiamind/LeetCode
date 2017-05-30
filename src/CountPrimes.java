/**
 * Created by udingji on 5/26/17.
 */
public class CountPrimes {

    // Count the number of prime numbers less than a non-negative number, n.

    // Idea: create an array of size n. Starting from 2 (which is a prime number), all numbers which is a multiply of this number are not prime number
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++){
            if (!isNotPrime[i]){
                count++;
                for (int j = 2; i * j <= n; j++){
                    isNotPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
