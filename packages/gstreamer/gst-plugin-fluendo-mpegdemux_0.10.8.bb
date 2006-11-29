DESCRIPTION = "Plugin for gstreamer: fluendo-mpegdemux"
SECTION = "multimedia"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@openembedded.org>"
DEPENDS = "gstreamer"
PR = "r0"

inherit autotools pkgconfig

SRC_URI = "http://core.fluendo.com/gstreamer/src/gst-fluendo-mpegdemux/gst-fluendo-mpegdemux-${PV}.tar.gz"
S = "${WORKDIR}/gst-fluendo-mpegdemux-${PV}"

FILES_${PN} = "${libdir}/gstreamer-0.10/*.so*"

do_stage() {
	autotools_stage_all
}
