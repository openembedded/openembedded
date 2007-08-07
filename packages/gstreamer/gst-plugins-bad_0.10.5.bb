require gst-plugins.inc

DEPENDS += "gst-plugins-base"

# fails compiling (doesn't find vorbisdec.h)
DEFAULT_PREFERENCE = "-1"

PR = "r0"
