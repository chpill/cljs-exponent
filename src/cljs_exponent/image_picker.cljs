(ns cljs-exponent.image-picker
  "Provides access to the system's UI for selecting images from the phone's photo library or taking a photo with the camera."
  (:require [cljs-exponent.core :refer [exponent]]))

(def ImagePicker (aget exponent "ImagePicker"))

(defn launch-image-library-async
  "Display the system UI for choosing an image from the phone's photo library.

   Arguments
     options (object) --
     A map of options:

     allowsEditing (boolean) -- Whether to show a UI to edit the image after it is picked. On Android the user can crop and rotate the image and on iOS simply crop it. Defaults to false.
     aspect (array) -- An array with two entries [x, y] specifying the aspect ratio to maintain if the user is allowed to edit the image (by passing allowsEditing: true). This is only applicable on Android, since on iOS the crop rectangle is always a square.
     Returns
       If the user cancelled the image picking, returns { cancelled: true }.
       Otherwise, returns { cancelled: false, uri, width, height } where uri is a URI to the local image file (useable in a react-native Image tag) and width, height specify the dimensions of the image."
  [options]
  (.call (aget ImagePicker "launchImageLibraryAsync")
         ImagePicker (clj->js options)))

(defn launch-camera-async
  "Display the system UI for taking a photo with the camera.

   Arguments
     options (object) --
     A map of options:

     allowsEditing (boolean) -- Whether to show a UI to edit the image after it is picked. On Android the user can crop and rotate the image and on iOS simply crop it. Defaults to false.
     aspect (array) -- An array with two entries [x, y] specifying the aspect ratio to maintain if the user is allowed to edit the image (by passing allowsEditing: true). This is only applicable on Android, since on iOS the crop rectangle is always a square.
     Returns
       If the user cancelled taking a photo, returns { cancelled: true }.
       Otherwise, returns { cancelled: false, uri, width, height } where uri is a URI to the local image file (useable in a React Native Image tag) and width, height specify the dimensions of the image."
  [options]
  (.call (aget ImagePicker "launchCameraAsync")
         ImagePicker (clj->js options)))
