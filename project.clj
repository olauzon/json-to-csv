(defproject json-to-csv "0.1.0-SNAPSHOT"
  :description "Converts JSON input files to CSV output files"
  :url "https://github.com/olauzon/json-to-csv"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
    [org.clojure/clojure   "1.5.1"]
    [org.clojure/data.csv  "0.1.2"]
    [org.clojure/data.json "0.2.3"]
  ]
  :aot :all
  :main json-to-csv.core)
