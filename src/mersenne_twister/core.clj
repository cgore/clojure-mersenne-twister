(ns mersenne-twister.core
  "This namespace provides a Clojure-friendly wrapper around the MersenneTwister
  class from The Apache Commons Mathematics Library:

  http://commons.apache.org/proper/commons-math/

  This class implements a powerful pseudo-random number generator developed by
  Makoto Matsumoto and Takuji Nishimura during 1996-1997.

  This generator features an extremely long period (219937-1) and
  623-dimensional equidistribution up to 32 bits accuracy. The home page for
  this generator is located at:

  http://www.math.sci.hiroshima-u.ac.jp/~m-mat/MT/emt.html

  This generator is described in a paper by Makoto Matsumoto and Takuji
  Nishimura in 1998: Mersenne Twister: A 623-Dimensionally Equidistributed
  Uniform Pseudo-Random Number Generator, ACM Transactions on Modeling and
  Computer Simulation, Vol. 8, No. 1, January 1998, pp 3--30"
  (:import [java.lang Integer Long]
           ;; http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/random/MersenneTwister.html
           [org.apache.commons.math3.random MersenneTwister]))

(defn new-generator
  "Creates a new Mersenne Twister random number generator.

  The instance is initialized using the current time plus the system identity
  hash code of this instance as the seed."
  []
  (new MersenneTwister))

(def generator
  "Default generator to use if none is specified."
  (delay (new-generator)))

(defn next-boolean
  "Returns the next pseudorandom, uniformly distributed boolean value from this
  random number generator's sequence."
  ([]
   (next-boolean @generator))
  ([^MersenneTwister generator]
   (.nextBoolean ^MersenneTwister generator)))

(defn next-double
  "Returns the next pseudorandom, uniformly distributed double value between 0.0
  and 1.0 from this random number generator's sequence."
  ([]
   (next-double @generator))
  ([^MersenneTwister generator]
   (.nextDouble ^MersenneTwister generator)))

(defn next-float
  "Returns the next pseudorandom, uniformly distributed float value between 0.0
  and 1.0 from this random number generator's sequence."
  ([]
   (next-float @generator))
  ([^MersenneTwister generator]
   (.nextFloat ^MersenneTwister generator)))

(defn next-gaussian
  "Returns the next pseudorandom, Gaussian (\"normally\") distributed double value
  with mean 0.0 and standard deviation 1.0 from this random number generator's
  sequence."
  ([]
   (next-gaussian @generator))
  ([^MersenneTwister generator]
   (.nextGaussian ^MersenneTwister generator)))

(defn next-int
  "Returns the next pseudorandom, uniformly distributed int value from this
  random number generator's sequence. All 232 possible int values should be
  produced with (approximately) equal probability.

  This optionally takes a value `n`, such that it returns a pseudorandom,
  uniformly distributed int value between 0 (inclusive) and the specified
  value (exclusive), drawn from this random number generator's sequence.

  When `n` is specified:

   * If n is a power of 2, this method returns (int) ((n * (long) next(31)) >> 31).

   * If n is not a power of 2, what is returned is next(31) % n with next(31)
     values rejected (i.e. regenerated) until a value that is larger than the
     remainder of Integer.MAX_VALUE / n is generated. Rejection of this initial
     segment is necessary to ensure a uniform distribution."
  ([]
   (.nextInt ^MersenneTwister @generator))
  ([thing]
   (cond (= Integer         (class thing)) (.nextInt ^MersenneTwister @generator ^Integer thing)
         (= MersenneTwister (class thing)) (.nextInt ^MersenneTwister thing)))
  ([^MersenneTwister generator ^Integer n]
   (.nextInt ^MersenneTwister generator ^Integer n)))

(defn next-long
  "Returns the next pseudorandom, uniformly distributed long value from this
  random number generator's sequence. All 264 possible long values should be
  produced with (approximately) equal probability.


  This optionally takes a value `n`, such that it returns a pseudorandom,
  uniformly distributed long value between 0 (inclusive) and the specified
  value (exclusive), drawn from this random number generator's sequence. "
  ([]
   (.nextLong ^MersenneTwister @generator))
  ([thing]
   (cond (= Long            (class thing)) (.nextLong ^MersenneTwister @generator ^Long thing)
         (= MersenneTwister (class thing)) (.nextLong ^MersenneTwister thing)))
  ([^MersenneTwister generator ^Long n]
   (.nextLong ^MersenneTwister generator ^Long n)))
