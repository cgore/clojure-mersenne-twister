(defproject com.cgore/mersenne-twister "1.0.0"
  :description "The Mersenne Twister PRNG for Clojure and ClojureScript."
  :url "https://github.com/cgore/clojure-mersenne-twister"
  :scm {:name "git"
        :url "https://github.com/cgore/clojure-mersenne-twister"}
  :license {:name "Apache License Version 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0.txt"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 ;; https://github.com/apache/commons-math
                 [org.apache.commons/commons-math3 "3.6.1"]]
  :repl-options {:init-ns mersenne-twister.core})
