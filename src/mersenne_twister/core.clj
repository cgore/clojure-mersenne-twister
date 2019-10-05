(ns mersenne-twister.core
  (:import
   ;; http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/random/MersenneTwister.html
   [org.apache.commons.math3.random MersenneTwister]))

(defn new-generator
  "Create a new Mersenne Twister generator instance."
  []
  (new MersenneTwister))

(def generator
  "Default generator to use if none is specified."
  (delay (new-generator)))

(defn next-boolean
  "Return the next boolean value from the generator."
  ([]
   (next-boolean @generator))
  ([generator]
   (.nextBoolean ^MersenneTwister generator)))
