require cornucopia.inc
DEPENDS += "gstreamer"
PV = "0.0.1+gitr${SRCREV}"
PR = "${INC_PR}.1"

RDEPENDS += "\
  gst-plugin-volume \
  gst-plugin-mad \
  gst-plugin-ogg \
  gst-plugin-ivorbis \
  gst-plugin-audioconvert \
  gst-plugin-flac \
  gst-plugin-wavparse \
  gst-plugin-sid \
  gst-plugin-alsa \
"
RRECOMMENDS += "\
  gst-plugin-souphttp \
  gst-plugin-mms \
  gst-plugin-modplug \
  "
