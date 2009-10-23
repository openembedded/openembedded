require gst-plugins.inc
DEPENDS += "gst-plugins-base"
EXTRA_OECONF += "--disable-apexsink --disable-dvdnav"
RCONFLICTS_gst-plugin-mpegdemux = "gst-plugin-fluendo-mpegdemux"
RREPLACES_gst-plugin-mpegdemux = "gst-plugin-fluendo-mpegdemux"
SRC_URI += "file://gst-plugins_configure_skip_shave.patch;patch=1;pnum=0 \
	file://mpegpsdemux_speedup.diff;patch=1;pnum=0 \
	file://mpegtsdemux_fix_ac3_detection.diff;patch=1;pnum=0"
