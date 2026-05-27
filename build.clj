(ns build
  (:require [clojure.tools.build.api :as b]
            [deps-deploy.deps-deploy :as dd]))

(def lib 'com.cgore/mersenne-twister)
(def version
  "Dynamically get version from git tag (e.g. v0.4.1 → 0.4.1)"
  (-> (b/git-process {:git-args ["describe" "--tags" "--abbrev=0"]})
      (clojure.string/trim)
      (clojure.string/replace #"^v" "")))
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn jar [_]
  (clean nil)
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis basis
                :src-dirs ["src"]
                :pom-data  [[:description "The Mersenne Twister PRNG for Clojure."]
                            [:url "https://github.com/cgore/clojure-mersenne-twister"]
                            [:licenses
                             [:license
                              [:name "Eclipse Public License 1.0"]
                              [:url "http://www.eclipse.org/legal/epl-v10.html"]]]
                            [:scm
                             [:url "https://github.com/cgore/clojure-mersenne-twister"]
                             [:connection "scm:git:git@github.com:cgore/clojure-mersenne-twister.git"]]]
                })
  (b/copy-dir {:src-dirs ["src"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file jar-file}))

(defn deploy [_]
  (jar nil)
  (dd/deploy {:installer :remote
              :artifact jar-file}))
