(defproject learn-ring "0.1.0-SNAPSHOT"
  :description "Learn Ring"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [metosin/reitit-ring "0.4.2"]
                 [ring/ring-core "1.8.0"]
                 [ring/ring-jetty-adapter "1.8.0"]
                 [ring-logger "1.0.1"]
                 [metosin/reitit-middleware "0.4.2"]
                 [metosin/reitit-dev "0.4.2"]
                 [metosin/reitit-spec "0.4.2"]
                 [ring/ring-devel "1.8.0"]]
  :repl-options {:init-ns learn-ring.core}
  :main ^:skip-aot learn-ring.core
  :resource-paths ["resources" "target/resources"])
