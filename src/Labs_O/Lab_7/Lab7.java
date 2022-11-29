package Labs_O.Lab_7;

import java.util.*;

public class Lab7 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(eratosfenPrimes(100).toArray()));
    }

    public static List<Integer> eratosfenPrimes(int max) {
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < max; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        List<Integer> null_count = new ArrayList<>();

        for (int i = 2; i < max; i++) {
            if (isPrime[i]) {
                int a, b, c;
                a = i;
                c = 0;
                while(a != 0){
                    b = a % 2;
                    if (b == 0){
                        c = c + 1;
                    }
                    a = a / 2;
                }
                null_count.add(c);
                primes.add(i);
            }
        }

        int k;
        k = null_count.indexOf(Collections.max(null_count));
        System.out.println("Прості числа з максимальною кылькістю нулів у двійковій системі числення:");
        int maxZerosValue = null_count.get(k);
        primes.stream()
                .filter(p -> null_count.get(primes.indexOf(p)) == maxZerosValue )
                .forEach(System.out::println);
        System.out.println("Прості числа:");
        return primes;
    }
}