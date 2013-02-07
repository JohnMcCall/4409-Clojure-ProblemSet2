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

(defn num-surpassers [coll]
  (count (filter #(< (int (first coll)) (int %)) (rest coll)))
  )


;; Tests for generateTails
(is (= '("t" "st" "est" "test") (generateTails "test")))

;; Tests for num-surpassers
(is (= 5 (num-surpassers "generating")))
(is (= 6 (num-surpassers "enerating")))
(is (= 2 (num-surpassers "nerating")))
(is (= 5 (num-surpassers "erating")))

;; Tests for max-surpasser-count
(is (= 0 (max-surpasser-count [5])))
(is (= 0 (max-surpasser-count [\a])))
(is (= 0 (max-surpasser-count [1 0])))
(is (= 1 (max-surpasser-count [0 1])))
; The first \e has six larger characters to its right
(is (= 6 (max-surpasser-count [\g \e \n \e \r \a \t \i \n \g])))
(is (= 6 (max-surpasser-count "generating")))