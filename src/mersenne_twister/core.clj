(ns mersenne-twister.core
  (:import
   ;; http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/random/MersenneTwister.html
   [org.apache.commons.math3.random MersenneTwister]))

(defn generator []
  (new MersenneTwister))

(defn next-boolean [generator]
  (.nextBoolean ^MersenneTwister generator))
