include gst-plugins.inc
PROVIDES_${PN} += "gst-plugins"
RCONFLICTS_gst-plugins-base = "libgstapp-0.10-0"
RREPLACES_gst-plugins-base = "libgstapp-0.10-0"
EXTRA_OECONF += "--with-audioresample-format=int"
RDEPENDS += "gstreamer (>= ${PV})"

PR = "r2"
SRCDATE = "20090606"
REL = "0.10.23"

SRC_URI = "http://gstreamer.freedesktop.org/src/${PN}/${PN}-${REL}.tar.bz2 \
file://${PN}_${REL}_to_git${SRCDATE}.patch;patch=1;pnum=1 \
file://gst-plugins_configure_skip_shave.patch;patch=1;pnum=0"

S = "${WORKDIR}/${PN}-${REL}"