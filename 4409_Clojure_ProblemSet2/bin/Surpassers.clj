(ns Surpassers)
(use 'clojure.test)

(defn generateTails [coll]
  (loop [toReturn (), current coll]
    (if (empty? current) 
      (map #(apply str %) toReturn)
      (recur (cons current toReturn), (rest current))
      )
    )
  )



;; Tests for generateTails
(is (= '("t" "st" "est" "test") (generateTails "test")))

;; Tests for num-surpassers
(is (= 5 (num-surpassers "generating")))
(is (= 6 (num-surpassers "enerating")))
(is (= 2 (num-surpassers "nerating")))
(is (= 5 (num-surpassers "erating")))