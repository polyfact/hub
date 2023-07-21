(ns hub.db
  (:require [reagent.core :as r]))

(defonce state (r/atom {:easter? false
                        :dropdown? false}))