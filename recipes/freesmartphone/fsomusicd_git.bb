require cornucopia.inc
DEPENDS += "gstreamer"
PV = "0.0.1+gitr${SRCREV}"
PR = "${INC_PR}.0"

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
