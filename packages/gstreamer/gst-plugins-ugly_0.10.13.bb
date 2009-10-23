require gst-plugins.inc
SRC_URI += "file://gst-plugins_configure_skip_shave.patch;patch=1;pnum=0"
DEPENDS += "gst-plugins-base"
