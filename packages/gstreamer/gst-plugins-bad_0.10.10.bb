require gst-plugins.inc
DEPENDS += "gst-plugins-base"
EXTRA_OECONF += "--disable-apexsink --disable-dvdnav"
RCONFLICTS_gst-plugin-mpegdemux = "gst-plugin-fluendo-mpegdemux"
RREPLACES_gst-plugin-mpegdemux = "gst-plugin-fluendo-mpegdemux"
