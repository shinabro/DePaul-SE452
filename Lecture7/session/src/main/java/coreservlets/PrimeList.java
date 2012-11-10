package coreservlets;

import java.util.*;
import java.math.BigInteger;

/** Creates a Vector of large prime numbers, usually in
 *  a low-priority background thread. Provides a few small
 *  thread-safe access methods.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2000 Marty Hall; may be freely used or adapted.
 */

public class PrimeList implements Runnable {
  private Vector primesFound;
  private int numPrimes, numDigits;

  /** Finds numPrimes prime numbers, each of which are
   *  numDigits long or longer. You can set it to only
   *  return when done, or have it return immediately,
   *  and you can later poll it to see how far it
   *  has gotten.
   */
  
  public PrimeList(int numPrimes, int numDigits,
                   boolean runInBackground) {
    // Using Vector instead of ArrayList
    // to support JDK 1.1 servlet engines
    primesFound = new Vector(numPrimes);
    this.numPrimes = numPrimes;
    this.numDigits = numDigits;
    if (runInBackground) {
      Thread t = new Thread(this);
      // Use low priority so you don't slow down server.
      t.setPriority(Thread.MIN_PRIORITY);
      t.start();
    } else {
      run();
    }
  }

  public void run() {
    BigInteger start = Primes.random(numDigits);
    for(int i=0; i<numPrimes; i++) {
      start = Primes.nextPrime(start);
      synchronized(this) {
        primesFound.addElement(start);
      }
    }
  }

  public synchronized boolean isDone() {
    return(primesFound.size() == numPrimes);
  }

  public synchronized Vector getPrimes() {
    if (isDone())
      return(primesFound);
    else
      return((Vector)primesFound.clone());
  }

  public int numDigits() {
    return(numDigits);
  }
  
  public int numPrimes() {
    return(numPrimes);
  }
  
  public synchronized int numCalculatedPrimes() {
    return(primesFound.size());
  }
}
