require cornucopia.inc
DEPENDS += "gstreamer"
PR = "${INC_PR}.0"
PV = "0.0.1"

RDEPENDS += "\
  gst-plugin-volume \
  gst-plugin-mad \
  gst-plugin-oggdemux \
  gst-plugin-ivorbisdec \
  gst-plugin-audioconvert \
  gst-plugin-flacdec \
  gst-plugin-waveparse \
  gst-plugin-siddec \
  gst-plugin-modplug \
  gst-plugin-filesrc \
  gst-plugin-souphttpsrc \
  gst-plugin-mmssrc \
  gst-plugin-alsasink \
"
