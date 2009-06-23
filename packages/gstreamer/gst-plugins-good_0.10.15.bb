require gst-plugins.inc
DEPENDS += "gst-plugins-base"
SRC_URI += "file://sed-with-autoconf-2.59.patch;patch=1;pnum=1 \
	file://gst-plugins-good_configure_skip_shave.patch;patch=1;pnum=0 \
	file://backport_matroskademux_memleak_fix.patch;patch=1;pnum=1"
PR = "r2"