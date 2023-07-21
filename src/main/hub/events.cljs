(ns hub.events
  (:require [hub.db :as db]))

(defn exit
  []
  (swap! db/state assoc :easter? false))

(defn enter
  []
  (swap! db/state assoc :easter? true))

(defn toggle-dropdown
  []
  (let [dropdown (:dropdown? @db/state)]
    (swap! db/state assoc :dropdown? (not dropdown))))