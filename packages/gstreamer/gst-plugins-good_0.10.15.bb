require gst-plugins.inc
SRC_URI += "file://sed-with-autoconf-2.59.patch;patch=1;pnum=1"
DEPENDS += "gst-plugins-base"
SRC_URI += "file://gst-plugins-good_configure_skip_shave.patch;patch=1;pnum=0"