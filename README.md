# mersenne-twister

The Mersenne Twister PRNG for Clojure.

This library provides a Clojure-friendly wrapper around the `MersenneTwister`
class from The Apache Commons Mathematics Library:

http://commons.apache.org/proper/commons-math/

This class implements a powerful pseudo-random number generator developed by
Makoto Matsumoto and Takuji Nishimura during 1996-1997.

This generator features an extremely long period (219937-1) and 623-dimensional
equidistribution up to 32 bits accuracy. The home page for this generator is
located at:

http://www.math.sci.hiroshima-u.ac.jp/~m-mat/MT/emt.html

This generator is described in a paper by Makoto Matsumoto and Takuji Nishimura
in 1998: Mersenne Twister: A 623-Dimensionally Equidistributed Uniform
Pseudo-Random Number Generator, ACM Transactions on Modeling and Computer
Simulation, Vol. 8, No. 1, January 1998, pp 3--30

## Usage

```clojure
(ns your.cool.code
  (:require [mersenne-twister.core :as twist]))

(twist/next-boolean) ; get a boolean
(twist/next-float) ; get a float
(twist/next-double) ; get a double
(twist/next-gaussian) ; get a normally distributed double
(twist/next-int) ; get an int
(twist/next-long) ; get a long
;; ... other stuff ...
```

* `new-generator` - Creates a new Mersenne Twister random number generator.
* `generator` - Default generator to use if none is specified.
* `next-boolean` - Returns the next pseudorandom, uniformly distributed boolean
  value from this random number generator's sequence.
* `next-double` - Returns the next pseudorandom, uniformly distributed double
  value between 0.0 and 1.0 from this random number generator's sequence.
* `next-float` - Returns the next pseudorandom, uniformly distributed float
  value between 0.0 and 1.0 from this random number generator's sequence.
* `next-gaussian` - Returns the next pseudorandom, Gaussian (\"normally\")
  distributed double value with mean 0.0 and standard deviation 1.0 from this
  random number generator's sequence.
* `next-int` - Returns the next pseudorandom, uniformly distributed int value
  from this random number generator's sequence.
* `next-long` - Returns the next pseudorandom, uniformly distributed long value
  from this random number generator's sequence. All 264 possible long values
  should be produced with (approximately) equal probability.

## TODO 

* ClojureScript support.

## License

Copyright © 2019 Christopher Mark Gore, Soli Deo Gloria, all rights reserved.

This program and the accompanying materials are made available under the
terms of the Apache License Version 2.0 which is available at
https://www.apache.org/licenses/LICENSE-2.0.txt
