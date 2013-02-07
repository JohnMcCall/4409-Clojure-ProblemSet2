(ns IntoCamelCase)
(use 'clojure.test)

(defn intoCamelCase [string]
  (let [words (clojure.string/split string #"-")]
    (apply str (first words) (map clojure.string/capitalize (rest words)))    
    )
  )

(is (= (intoCamelCase "something") "something"))

(is (= (intoCamelCase "multi-word-key") "multiWordKey"))

(is (= (intoCamelCase "leaveMeAlone") "leaveMeAlone"))
