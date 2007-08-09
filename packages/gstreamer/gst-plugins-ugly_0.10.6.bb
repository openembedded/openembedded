require gst-plugins.inc

DEPENDS += "gst-plugins-base"
SRC_URI += "file://cross-compile.patch;patch=1"

PR = "r0"
