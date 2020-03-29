(ns learn-ring.core
  (:require [reitit.ring :as ring]
            [reitit.coercion.spec]
            [ring.adapter.jetty :as jetty]
            [ring.logger :as logger]
            [ring.util.response :refer [content-type response resource-response]]
            [reitit.dev.pretty :as pretty]
            [reitit.ring.middleware.exception :as exception]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            )
  (:gen-class))

(defn ping [request]
  (content-type (response "Ping") "text/plain"))

(defn handler [_]
  (resource-response "index.html" {:root "public"}))


(def router
  (ring/ring-handler
    (ring/router
      [["/" handler]
       ["/ping" {:name ::ping
                 :get ping}]]
      {:exception pretty/exception})
    (ring/create-default-handler
      {:not-found (constantly {:status 404, :body "oops"})})))

(def app (-> #'router
             (wrap-reload)
             (wrap-resource "public")
             ))


(defn -main
  [& args]
  (jetty/run-jetty (logger/wrap-with-logger #'app) {:port 4000, :join? false})
  (println "server running in port 4000"))

