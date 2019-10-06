# mersenne-twister

The Mersenne Twister PRNG for Clojure.

This library provides a Clojure-friendly wrapper around the MersenneTwister
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

(next-boolean) ; get a boolean
(next-float) ; get a float
(next-double) ; get a double
(next-gaussian) ; get a normally distributed double
(next-int) ; get an int
;; ... other stuff ...
```

* `new-generator`
* `generator`
* `next-boolean`
* `next-double`
* `next-float`
* `next-gaussian`
* `next-int`

## TODO 

* ClojureScript support.

## License

Copyright © 2019 Christopher Mark Gore, Soli Deo Gloria, all rights reserved.

This program and the accompanying materials are made available under the
terms of the Apache License Version 2.0 which is available at
https://www.apache.org/licenses/LICENSE-2.0.txt
