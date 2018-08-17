package chapter2;

import java.util.HashSet;
import java.util.Set;

public class FindFactors {
  static Set<Integer> findFactors(int n) {
    Set<Integer> factors = new HashSet<>();
    int i = 2;
    while (i < n) {
      while (n % i == 0) {
        factors.add(i);
        n = n / i;
      }
      i++;
    }
    if (n > 1) {
      factors.add(n);
    }

    return factors;
  }

  static Set<Integer> findFactorsFaster(int n) {
    Set<Integer> factors = new HashSet<>();
    while (n % 2 == 0) {
      factors.add(2);
      n = n / 2;
    }
    int i = 3;
    int upperLimit = (int) Math.ceil(Math.sqrt(n));
    while (i < upperLimit) {
      while (n % i == 0) {
        factors.add(i);
        n = n / i;
        upperLimit = (int) Math.ceil(Math.sqrt(n));
      }
      i = i + 2;
    }
    if (n > 1)
      factors.add(n);
    return factors;

  }

  public static void main(String[] args) {
    System.out.println("factor : " + findFactors(84));
    System.out.println("factor : " + findFactorsFaster(1230));
    System.out.println("factor : " + findFactorsFaster(13 * 37));
  }

}
