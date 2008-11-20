DESCRIPTION = "Plugin for gstreamer: dvbmediasink"
SECTION = "multimedia"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@openembedded.org>"
DEPENDS = "gstreamer"
PV = "0.10+${SRCDATE}"
PR = "r1"

inherit autotools pkgconfig

SRCDATE_dm7025 = "20080907"
SRCDATE = "20081005"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/dvbmediasink;module=dvbmediasink;method=pserver"

S = "${WORKDIR}/dvbmediasink"

FILES_${PN} = "${libdir}/gstreamer-0.10/*.so*"

do_stage() {
	autotools_stage_all
}
