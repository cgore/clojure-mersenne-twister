(ns mersenne-twister.core
  (:import [java.lang Integer]
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
