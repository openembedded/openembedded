require gst-plugins.inc

DEPENDS += "gst-plugins-base directfb"
SRC_URI += "file://cross-compile.patch;patch=1"
PR = "r6"
