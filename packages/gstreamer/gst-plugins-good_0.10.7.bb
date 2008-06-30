require gst-plugins.inc
PR = "r1"

EXTRA_OECONF += "--with-check=no"
DEPENDS += "gst-plugins-base esound"
