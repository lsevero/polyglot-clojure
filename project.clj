(defproject polyglot-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :plugins [[haruyama/lein-scalac "0.1.1"]
            [cider/cider-nrepl "0.23.0"]]
  :main polyglot-clojure.core
  :source-paths ["clj"]
  :java-source-paths ["java"]
  :scala-source-paths ["scala"]
  :scala-version "2.10.2"
  :prep-tasks ["scalac"]
  :repl-options {:init-ns polyglot-clojure.core})
