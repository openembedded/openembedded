require gst-plugins.inc

EXTRA_OECONF += "--with-check=no"
DEPENDS += "gst-plugins-base"
PR = "r3"
