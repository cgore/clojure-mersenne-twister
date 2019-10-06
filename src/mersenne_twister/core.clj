(ns mersenne-twister.core
  (:import
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

