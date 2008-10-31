require gst-plugins.inc
PR = "r0"

SRC_URI += "file://v4l2src_fixformats.patch;patch=1;pnum=0"

EXTRA_OECONF += "--with-check=no"
DEPENDS += "gst-plugins-base"
