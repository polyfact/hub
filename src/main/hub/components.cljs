(ns hub.components)

(defn pkg-card [pkg]
  [:li {:class "col-span-1 divide-y divide-gray-200 rounded-lg bg-white/50 shadow" :key (:name pkg)}
   [:div {:class "flex w-full items-center justify-between space-x-6 p-6"}
    [:div {:class "flex-1 "}
     [:div {:class "flex items-center space-x-3"}
      [:h3 {:class " text-sm font-medium text-gray-900"} (:name pkg)]
      ;; [:span {:class "inline-flex flex-shrink-0 items-center rounded-full bg-green-50 px-1.5 py-0.5 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20"} "Admin"]
      ]
     [:p {:class "h-10 mt-1 text-sm text-gray-500 overflow-hidden"} (:description pkg)]]]
   [:div
    [:div {:class "-mt-px flex divide-x divide-gray-200"}
     [:div {:class "flex w-0 flex-1"}
      [:a {:href (:github-link pkg)
           :class "relative -mr-px inline-flex w-0 flex-1 items-center justify-center gap-x-3 rounded-bl-lg border border-transparent py-4 text-sm font-semibold text-gray-900 hover:bg-gray-200"}
       [:img {:src "/img/github.png" :class "h-7 w-7"}]]]
     [:div {:class "-ml-px flex w-0 flex-1"}
      [:a {:href (:npm-link pkg)
           :class "relative inline-flex w-0 flex-1 items-center justify-center gap-x-3 rounded-br-lg border border-transparent py-4 text-sm font-semibold text-gray-900 hover:bg-gray-200"}
       [:img {:src "/img/npm.png" :class "h-auto w-10"}]]]]]])
