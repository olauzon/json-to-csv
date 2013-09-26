(ns json-to-csv.core
  (require [clojure.string    :as string]
           [clojure.java.io   :as io]
           [clojure.data.csv  :as csv]
           [clojure.data.json :as json]))

(defn extract-keys
  [extract-paths]
  (map #(string/split % #"\.") (string/split extract-paths #",")))

(def extract-keys-memo
  (memoize extract-keys))

(defn extract-row
  [json-map extract-paths]
  (map #(get-in json-map %) (extract-keys-memo extract-paths)))

(defn run!
  "Run JSON to CSV transformation"
  [input-file output-file extract-paths]
  (with-open [rdr (io/reader input-file)]
    (with-open [wtr (io/writer output-file :append true)]
      (doseq [line (line-seq rdr)]
        (let [json-map (json/read-str line)]
          (csv/write-csv wtr
            [(extract-row json-map extract-paths)]))))))

(defn -main
  [input-file output-file extract-paths]
  (time (run! input-file output-file extract-paths)))
