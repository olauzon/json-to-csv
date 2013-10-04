(ns json-to-csv.core
  (require [clojure.string    :as string]
           [clojure.java.io   :as io]
           [clojure.data.csv  :as csv]
           [clojure.data.json :as json]))

(defn extract-keys-fn
  [extract-paths]
  (map #(string/split % #"\.") (string/split extract-paths #",")))

(def extract-keys
  (memoize extract-keys-fn))

(defn extract-row
  [line extract-paths]
  (let [json-map (json/read-str line)]
    (map #(get-in json-map %) (extract-keys extract-paths))))

(defn run!
  "Run JSON to CSV transformation"
  [input-file output-file extract-paths]
  (with-open [rdr (io/reader input-file)]
    (with-open [wtr (io/writer output-file :append true)]
      (doseq [line (line-seq rdr)]
        (csv/write-csv wtr
          [(extract-row line extract-paths)])))))

(defn -main
  [input-file output-file extract-paths]
  (time (run! input-file output-file extract-paths)))
