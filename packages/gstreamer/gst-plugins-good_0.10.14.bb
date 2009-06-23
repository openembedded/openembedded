require gst-plugins.inc
SRC_URI += "file://sed-with-autoconf-2.59.patch;patch=1;pnum=1 \
	file://backport_matroskademux_memleak_fix.patch;patch=1;pnum=1"
PR = "r1"
DEPENDS += "gst-plugins-base"
