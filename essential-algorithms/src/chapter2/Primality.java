package chapter2;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Primality {

  static boolean isPrime(int n, int maxTests) {
    Set<BigInteger> selectedNums = new HashSet<>();
    BigInteger bigIntOfN = BigInteger.valueOf(n);
    for (int i = 0; i < maxTests; i++) {

      Random rand = new Random();
      BigInteger randNum = BigInteger.valueOf(2 + rand.nextInt(n - 2));
      while (selectedNums.contains(randNum)) {
        randNum = BigInteger.valueOf(2 + rand.nextInt(n - 2));
      }
      selectedNums.add(randNum);
      System.out.println("test with " + randNum);

      if (randNum.pow(n - 1).mod(bigIntOfN).intValue() != 1) {
        System.out.println("Fermat witness " + randNum);
        return false;
      }

    }
    // The number is probably prime.
    // (There is a 1/(2^max_tests) chance that it is not prime.)
    return true;
  }

  public static void main(String[] args) {
    boolean result1 = isPrime(105943, 20);
    boolean result2 = isPrime(1301081, 20);
    System.out.println("is 105943 prime ? " + result1);
    System.out.println("is 1301081 prime ? " + result2);

  }

}
