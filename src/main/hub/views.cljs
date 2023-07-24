(ns hub.views
  (:require [hub.events :as events]
            [hub.db :as db]
            [hub.components :as components]
            [hub.pkg :as pkg]))

(defn easter
  []
  [:div {:class "flex flex-col justify-center items-center py-12 sm:px-6 lg:px-8 h-screen"}
   [:img {:class "w-full md:w-1/2 lg:w-1/3" :src "https://cdnb.artstation.com/p/assets/images/images/042/776/543/original/jonah-factory-export.gif?1635408446"}]
   [:a {:href "#"
        :on-click #(events/exit)
        :class "block px-4 py-2 mt-4 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900" :role "menuitem"}
    "✈️"]])

(defn hub
  []
  [:div {:class "h-screen flex flex-col lg:flex-row overflow-hidden bg-white"}
   [:div {:class "lg:flex lg:flex-shrink-0"}
    [:div {:class "flex flex-col w-full lg:w-64 border-r border-gray-200 pt-5 pb-4 bg-gray-200"}
     [:div {:class "flex items-center flex-shrink-0 px-4 lg:px-6"}
      [:div {:class "text-center text-3xl font-bold text-gray-900"} "Hub"]]
     [:div {:class "h-0 flex-1 flex flex-col overflow-y-auto"}
      [:div {:class "px-1 lg:px-3 mt-6 relative inline-block text-left"}
       [:div
        [:button {:type "button"
                  :on-click #(events/toggle-dropdown)
                  :class "group w-full bg-gray-100 rounded-md px-3.5 py-2 text-sm font-medium text-gray-700 hover:bg-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-100 focus:ring-emerald-500"
                  :id "options-menu"
                  :aria-expanded "false"
                  :aria-haspopup "true"}
         [:span {:class "flex w-full justify-between items-center"}
          [:span {:class "flex min-w-0 items-center justify-between space-x-3"}
           [:span {:class "text-3xl"} "🏭"]
           [:span {:class "text-gray-900 text-sm font-medium truncate"} "Official Links"]]
          [:svg {:class "flex-shrink-0 h-5 w-5 text-gray-400 group-hover:text-gray-500" :xmlns "http://www.w3.org/2000/svg" :viewBox "0 0 20 20" :fill "currentColor" :aria-hidden "true"}
           [:path {:fill-rule "evenodd" :d "M10 3a1 1 0 01.707.293l3 3a1 1 0 01-1.414 1.414L10 5.414 7.707 7.707a1 1 0 01-1.414-1.414l3-3A1 1 0 0110 3zm-3.707 9.293a1 1 0 011.414 0L10 14.586l2.293-2.293a1 1 0 011.414 1.414l-3 3a1 1 0 01-1.414 0l-3-3a1 1 0 010-1.414z" :clip-rule "evenodd"}]]]]]
       (when (:dropdown? @db/state)
         [:div {:class "z-10 mx-3 origin-top absolute right-0 left-0 mt-1 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5 divide-y divide-gray-200 focus:outline-none" :role "menu" :aria-orientation "vertical" :aria-labelledby "options-menu"}
          [:div {:class "py-1" :role "none"}
           [:a {:href "https://www.polyfact.com" :class "block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900" :role "menuitem"} "Changelog"]
           [:a {:href "https://app.polyfact.com" :class "block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900" :role "menuitem"} "Dashboard"]
           [:a {:href "https://discord.gg/CKS5D9sQup" :class "block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900" :role "menuitem"} "Support"]]])

       [:nav {:class "pr-3 mt-6"}
        [:div {:class "mt-8"}
         [:h3 {:class "px-3 text-xs font-semibold text-gray-500 uppercase tracking-wider" :id "teams-headline"} "SDKs"]
         [:div {:class "mt-1 space-y-1" :role "group" :aria-labelledby "teams-headline"}
          [:a {:href "https://www.npmjs.com/package/polyfact" :class "group flex items-center px-3 py-2 text-sm font-medium text-gray-700 rounded-md hover:text-gray-900 hover:bg-gray-50"}
           [:span {:class "truncate"} "Javascript"]]]]]]]]]


   [:div {:class "flex flex-col w-full flex-1 overflow-hidden"}
    [:main {:class "flex-1 relative z-0 overflow-y-auto bg-gray-100 focus:outline-none" :tabIndex "0"}
     [:div {:class "fixed top-1 right-2 w-5 h-5 group" :role "none"}
      [:a {:href "#"
           :on-click #(events/enter)
           :class "hidden text-xl group-hover:block" :role "menuitem"}
       "🐣"]]
     [:div {:class "px-4 mt-6 sm:px-6 lg:px-8"}
      [:h2 {:class "text-gray-500 mb-4 text-xs font-medium uppercase tracking-wide"} "Packages"]
      [:ul {:role "list" :class "grid grid-cols-1 gap-6 sm:grid-cols-2 lg:grid-cols-3"}
       (for [pkg pkg/pkg-list] [components/pkg-card pkg])]]]]])


