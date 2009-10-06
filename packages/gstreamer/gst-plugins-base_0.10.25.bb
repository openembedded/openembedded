include gst-plugins.inc
PROVIDES_${PN} += "gst-plugins"
RCONFLICTS_gst-plugins-base = "libgstapp-0.10-0"
RREPLACES_gst-plugins-base = "libgstapp-0.10-0"
EXTRA_OECONF += "--with-audioresample-format=int --disable-pango"
SRC_URI += "file://gst-plugins_configure_skip_shave.patch;patch=1;pnum=0 \
	file://gst-plugins_disable_introspection.patch;patch=1;pnum=0"
