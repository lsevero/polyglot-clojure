(ns polyglot-clojure.core
  (:require [clojure.reflect :as cr]
            [clojure.pprint :as pp])
  (:import [polyglot.java JavaExample]
           [polyglot.scala ScalaExample ScalaExample$]
           [scala.collection.immutable List Map Nil Nil$ $colon$colon $colon$colon$]
           [scala.collection JavaConverters JavaConverters$])
  (:gen-class))

(defn describe 
  "Printa uma tabela mostrando todos metodos, argumentos, throws e flags de uma dada classe"
  [klass]
  (->> klass cr/reflect :members (map #(dissoc % :declaring-class)) pp/print-table))

(defn run-clj
  []
  (println  "Hello world from clojure!"))

(defn run-java
  []
  ;Java is by far the easiest language to integrate in clojure, so, is the least interesting one to study.
  ;No need to focus on java interop because is extremelly well documented.
  (let [obj (JavaExample. "severo")]
    (.objSayHello obj))
  (JavaExample/staticSayHello))

(defn run-scala
  []

  (println "Scala with companion objects:")
  (let [obj (ScalaExample. "severo")]
    (.sayHello obj))
  (.sayHello (ScalaExample$/MODULE$))

  (println "Scala trait example")
  (-> (ScalaExample$/MODULE$) .sao_bernardo .bark)

  (println "Immutable scala list in clojure:")
  (let [scala-nil (Nil$/MODULE$)
        one (.apply ($colon$colon$/MODULE$) 1 scala-nil)
        two (.apply ($colon$colon$/MODULE$) 2 one)
        ;How it would look like in java:
        ;
        ;List nil = Nil$.MODULE$; // the empty list
        ;$colon$colon one = $colon$colon$.MODULE$.apply((Integer) 1, nil); // 1::nil
        ;$colon$colon two = $colon$colon$.MODULE$.apply((Integer) 2, one); // 2::1::nil
        ;System.out.println(one);
        ;System.out.println(two);
        ]
    (println one)
    (println two)
    (println "Convert a immutable scala List to a clojure vector")
    (-> (JavaConverters$/MODULE$)
        (.asJavaListConverter two)
        .asJava
        .toArray
        vec
        prn)
  ))

(defn -main
  [& args]
  (run-clj)
  (run-java)
  (run-scala))
